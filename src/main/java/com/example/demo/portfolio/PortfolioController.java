package com.example.demo.portfolio;

import com.example.demo.portfoliostock.PortfolioStock;
import com.example.demo.portfoliostock.PortfolioStockService;
import com.example.demo.stock.Stock;
import com.example.demo.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public String stockForm(Model model)
    {
        model.addAttribute("pstock", new PortfolioStock());
        model.addAttribute("pstocks", portfolioStockService.getPortfolioStocks());
        return "portfolio";
    }

    // RequestBody maps the JSON body received in the
    // post request to a Stock object for insertion
    // into the database.
    @PostMapping()
    public String stockSubmit(
            @RequestParam(value="portfolio_name") String portfolio_name,
            @RequestParam(value="stock_name") String stock_name,
            @RequestParam(value="ticker") String ticker,
            @RequestParam(value="quantity") int quantity,
            Model model
    )
    {
        Portfolio portfolio = new Portfolio(portfolio_name);
        portfolio = this.portfolioService.getOrCreatePortfolio(portfolio);

        Stock stock = new Stock(stock_name, ticker, 100);
        stock = this.stockService.getOrCreateStock(stock);

        PortfolioStock portfolioStock = new PortfolioStock(portfolio, stock, quantity);
        portfolioStock = this.portfolioStockService.getOrCreatePortfolioStock(portfolioStock);

        return stockForm(model);
    }
}
