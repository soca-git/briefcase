package com.example.demo.portfoliostock;

import com.example.demo.portfolio.Portfolio;
import com.example.demo.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioStockService
{
    private final PortfolioStockRepository portfolioStockRepository;

    @Autowired
    public PortfolioStockService(PortfolioStockRepository portfolioStockRepository)
    {
        this.portfolioStockRepository = portfolioStockRepository;
    }

    public PortfolioStock getOrCreatePortfolioStock(Portfolio portfolio, Stock stock, int quantity)
    {
        PortfolioStock portfolioStockByOwnerAndStock = portfolioStockRepository.findPortfolioStockByOwnerANDStock(
                portfolio, stock
        );
        if (portfolioStockByOwnerAndStock != null)
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            portfolioStockByOwnerAndStock.getStock().getName(),
                            portfolioStockByOwnerAndStock.getOwner().getName()
                    )
            );
            return portfolioStockByOwnerAndStock;
        }
        else
        {
            return createPortfolioStock(portfolio, stock, quantity);
        }
    }

    public PortfolioStock createPortfolioStock(Portfolio portfolio, Stock stock, int quantity)
    {
        PortfolioStock portfolioStock = new PortfolioStock(portfolio, stock, quantity);
        this.portfolioStockRepository.save(portfolioStock);
        return portfolioStock;
    }

    public List<PortfolioStock> getPortfolioStocks(Portfolio portfolio)
    {
        return portfolioStockRepository.findPortfolioStocksByOwner(portfolio);
    }
}
