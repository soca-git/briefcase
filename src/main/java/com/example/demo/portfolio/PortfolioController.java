package com.example.demo.portfolio;

import com.example.demo.portfoliostock.PortfolioStock;
import com.example.demo.portfoliostock.PortfolioStockService;
import com.example.demo.stock.Stock;
import com.example.demo.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path="api/v1/portfolio")
public class PortfolioController
{
    private final PortfolioService portfolioService;
    private final PortfolioStockService portfolioStockService;
    private final StockService stockService;

    // Autowired is used for dependency injection.
    // StudentService is instantiated for injection in the
    // constructor. The alternative is to directly
    // instantiate a new StockService object in the
    // constructor, but apparently this is bad.
    // Read up about dependency injection.
    @Autowired
    public PortfolioController(PortfolioService portfolioService, PortfolioStockService portfolioStockService, StockService stockService)
    {
        this.portfolioService = portfolioService;
        this.portfolioStockService = portfolioStockService;
        this.stockService = stockService;
    }

    // Portfolio view.
    @GetMapping()
    public String portfolioView(Model model, @RequestParam(name="name", required = false) String portfolio_name)
    {
        if (portfolio_name != null)
        {
            Portfolio portfolio = this.portfolioService.getOrCreatePortfolio(portfolio_name);
            model.addAttribute("portfolio_name", portfolio_name);
            model.addAttribute("pstocks", portfolioStockService.getPortfolioStocks(portfolio));
        }
        return "index";
    }

    // Select portfolio form.
    @PostMapping()
    public String selectPortfolio(Model model, RedirectAttributes redirectAttributes, @RequestParam(name="name") String portfolio_name)
    {
        redirectAttributes.addAttribute("name", portfolio_name);
        return "redirect:/api/v1/portfolio";
    }

    // Add stock form.
    @PostMapping("/add-stock")
    public String addStock(
            Model model,
            @RequestParam(name="name") String portfolio_name,
            @RequestParam(value="ticker") String ticker,
            @RequestParam(value="quantity") int quantity
    )
    {
        Portfolio portfolio = this.portfolioService.getOrCreatePortfolio(portfolio_name);
        Stock stock = this.stockService.getOrCreateStock(ticker);
        PortfolioStock portfolioStock = this.portfolioStockService.getOrCreatePortfolioStock(portfolio, stock, quantity);
        return portfolioView(model, portfolio_name);
    }
}
