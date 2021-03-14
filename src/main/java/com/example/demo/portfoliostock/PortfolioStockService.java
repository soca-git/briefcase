package com.example.demo.portfoliostock;

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

    public List<PortfolioStock> getPortfolioStocks()
    {
        return portfolioStockRepository.findAll();
    }

    public PortfolioStock getOrCreatePortfolioStock(PortfolioStock pStock)
    {
        PortfolioStock portfolioStockByOwnerAndStock = portfolioStockRepository.findPortfolioStockByOwnerANDStock(
                pStock.getOwner(), pStock.getStock()
        );
        if (portfolioStockByOwnerAndStock != null)
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            pStock.getStock().getName(),
                            pStock.getOwner().getName()
                    )
            );
            return portfolioStockByOwnerAndStock;
        }
        else
        {
            portfolioStockRepository.save(pStock);
            return pStock;
        }
    }
}
