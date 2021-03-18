package com.example.demo.portfolio;

import com.example.demo.crypto.Crypto;
import com.example.demo.crypto.CryptoService;
import com.example.demo.portfolioitem.PortfolioItemService;
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
            Portfolio portfolio = this.portfolioService.getOrCreatePortfolio(portfolio_name);
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
    public String addStock(
            Model model,
            @RequestParam(name="name") String portfolio_name,
            @RequestParam(name="type") String type,
            @RequestParam(value="ticker") String ticker,
            @RequestParam(value="quantity") double quantity,
            @RequestParam(value="price") double buyPrice
    )
    {
        Portfolio portfolio = this.portfolioService.getOrCreatePortfolio(portfolio_name);
        if (type.equals("stock"))
        {
            Stock stock = this.stockService.getOrCreateStock(ticker, buyPrice);
            this.portfolioItemService.getOrCreatePortfolioStock(portfolio, stock, quantity);
        }
        else if (type.equals("crypto"))
        {
            Crypto crypto = this.cryptoService.getOrCreateCrypto(ticker, buyPrice);
            this.portfolioItemService.getOrCreatePortfolioCrypto(portfolio, crypto, quantity);
        }
        return portfolioView(model, portfolio_name);
    }
}
