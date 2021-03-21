package com.example.demo.portfolio;

import com.example.demo.crypto.CryptoService;
import com.example.demo.item.Item;
import com.example.demo.portfolioitem.PortfolioItem;
import com.example.demo.portfolioitem.PortfolioItemService;
import com.example.demo.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioService
{
    private final PortfolioRepository portfolioRepository;
    private final PortfolioItemService portfolioItemService;
    private final StockService stockService;
    private final CryptoService cryptoService;

    @Autowired
    public PortfolioService(
            PortfolioRepository portfolioRepository,
            PortfolioItemService portfolioItemService,
            StockService stockService,
            CryptoService cryptoService
    )
    {
        this.portfolioRepository = portfolioRepository;
        this.portfolioItemService = portfolioItemService;
        this.stockService = stockService;
        this.cryptoService = cryptoService;
    }

    public Portfolio getOrCreatePortfolio(String portfolio_name)
    {
        Portfolio portfolioByName = portfolioRepository.findPortfolioByName(portfolio_name);
        if (portfolioByName != null)
        {
            System.out.println(String.format("The %s portfolio already exists!", portfolioByName.getName()));
            return portfolioByName;
        }
        else
        {
            return createPortfolio(portfolio_name);
        }
    }

    public Portfolio createPortfolio(String portfolio_name)
    {
        Portfolio portfolio = new Portfolio(portfolio_name);
        portfolioRepository.save(portfolio);
        return portfolio;
    }

    public void addItem(Portfolio portfolio, String type, String ticker, double quantity, double buyPrice)
    {
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
    }

    public void updatePrices(Portfolio portfolio)
    {
        for (PortfolioItem pItem : portfolioItemService.getPortfolioItems(portfolio))
        {
            String itemClass = pItem.getItem().getClass().getSimpleName();
            if ("Stock".equals(itemClass))
            {
                stockService.updatePrice(pItem.getItem());
            }
            else if ("Crypto".equals(itemClass))
            {
                cryptoService.updatePrice(pItem.getItem());
            }
        }
    }

    public void deleteItem(Long id)
    {
        portfolioItemService.deletePortfolioItem(id);
    }

    public List<PortfolioItem> getPortfolioItems(Portfolio portfolio)
    {
        return portfolioItemService.getPortfolioItems(portfolio);
    }

    public List<Portfolio> getPortfolios()
    {
        return portfolioRepository.findAll();
    }
}
