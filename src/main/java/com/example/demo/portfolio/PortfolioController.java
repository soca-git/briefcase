package com.example.demo.portfolio;

import com.example.demo.crypto.CryptoService;
import com.example.demo.item.Item;
import com.example.demo.portfolioitem.PortfolioItemService;
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
    private final PortfolioItemService portfolioItemService;
    private final StockService stockService;
    private final CryptoService cryptoService;

    // Autowired is used for dependency injection.
    // StudentService is instantiated for injection in the
    // constructor. The alternative is to directly
    // instantiate a new StockService object in the
    // constructor, but apparently this is bad.
    // Read up about dependency injection.
    @Autowired
    public PortfolioController(
            PortfolioService portfolioService, PortfolioItemService portfolioItemService,
            StockService stockService, CryptoService cryptoService
    )
    {
        this.portfolioService = portfolioService;
        this.portfolioItemService = portfolioItemService;
        this.stockService = stockService;
        this.cryptoService = cryptoService;
    }

    // Portfolio view.
    @GetMapping()
    public String portfolioView(Model model, @RequestParam(name="name", required = false) String portfolio_name)
    {
        if (portfolio_name != null)
        {
            Portfolio portfolio = portfolioService.getOrCreatePortfolio(portfolio_name);
            model.addAttribute("portfolio_name", portfolio_name);
            model.addAttribute("pitems", portfolioItemService.getPortfolioItems(portfolio));
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

    // Add to portfolio form.
    @PostMapping("/add-item")
    public String addItem(
            Model model,
            @RequestParam(name="name") String portfolio_name,
            @RequestParam(name="type") String type,
            @RequestParam(value="ticker") String ticker,
            @RequestParam(value="quantity") double quantity,
            @RequestParam(value="price") double buyPrice
    )
    {
        Portfolio portfolio = portfolioService.getOrCreatePortfolio(portfolio_name);
        Item item = null;
        if (type.equals("stock"))
        {
            item = stockService.getOrCreateStock(ticker);
        }
        else if (type.equals("crypto"))
        {
            item = cryptoService.getOrCreateCrypto(ticker);
        }
        portfolioItemService.getOrCreatePortfolioItem(portfolio, item, buyPrice, quantity);
        return portfolioView(model, portfolio_name);
    }

    // Delete Portfolio Item form/button.
    @PostMapping("/delete-item")
    public String deleteItem(
            Model model,
            @RequestParam(name="name") String portfolio_name,
            @RequestParam(value="id") Long id
    )
    {
        portfolioItemService.deletePortfolioItem(id);
        return portfolioView(model, portfolio_name);
    }

    // Update Portfolio Prices.
    @PostMapping("/update")
    public String updatePrices(
            Model model,
            @RequestParam(name="name") String portfolio_name
    )
    {
        Portfolio portfolio = portfolioService.getOrCreatePortfolio(portfolio_name);
        portfolioService.updatePrices(portfolio);
        return portfolioView(model, portfolio_name);
    }
}
