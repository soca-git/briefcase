package com.example.demo.portfolioitem;

import com.example.demo.crypto.Crypto;
import com.example.demo.portfolio.Portfolio;
import com.example.demo.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioItemService
{
    private final PortfolioItemRepository portfolioItemRepository;

    @Autowired
    public PortfolioItemService(PortfolioItemRepository portfolioItemRepository)
    {
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public PortfolioItem getOrCreatePortfolioStock(Portfolio portfolio, Stock stock, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItemByOwnerAndStock = portfolioItemRepository.findPortfolioItemByOwnerANDItem(
                portfolio, stock
        );
        if (portfolioItemByOwnerAndStock != null)
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            portfolioItemByOwnerAndStock.getItem().getTicker(),
                            portfolioItemByOwnerAndStock.getOwner().getName()
                    )
            );
            return portfolioItemByOwnerAndStock;
        }
        else
        {
            return createPortfolioStock(portfolio, stock, buyPrice, quantity);
        }
    }

    public PortfolioItem getOrCreatePortfolioCrypto(Portfolio portfolio, Crypto crypto, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItemByOwnerAndCrypto = portfolioItemRepository.findPortfolioItemByOwnerANDItem(
                portfolio, crypto
        );
        if (portfolioItemByOwnerAndCrypto != null)
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            portfolioItemByOwnerAndCrypto.getItem().getTicker(),
                            portfolioItemByOwnerAndCrypto.getOwner().getName()
                    )
            );
            return portfolioItemByOwnerAndCrypto;
        }
        else
        {
            return createPortfolioCrypto(portfolio, crypto, buyPrice, quantity);
        }
    }

    public PortfolioItem createPortfolioStock(Portfolio portfolio, Stock stock, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItem = new PortfolioItem(portfolio, stock, buyPrice, quantity);
        this.portfolioItemRepository.save(portfolioItem);
        return portfolioItem;
    }

    public PortfolioItem createPortfolioCrypto(Portfolio portfolio, Crypto crypto, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItem = new PortfolioItem(portfolio, crypto, buyPrice, quantity);
        this.portfolioItemRepository.save(portfolioItem);
        return portfolioItem;
    }

    public List<PortfolioItem> getPortfolioItems(Portfolio portfolio)
    {
        return portfolioItemRepository.findPortfolioItemsByOwner(portfolio);
    }
}
