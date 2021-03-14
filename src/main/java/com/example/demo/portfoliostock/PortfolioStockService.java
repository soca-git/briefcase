package com.example.demo.portfoliostock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewPortfolioStock(PortfolioStock pStock)
    {
        Optional<PortfolioStock> pStockByOwner = portfolioStockRepository.findPortfolioStockByOwnerANDStockTicker(
                pStock.getOwner().getName(), pStock.getStock().getTicker()
        );
        if (pStockByOwner.isPresent())
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            pStock.getStock().getName(),
                            pStock.getOwner()
                    )
            );
        }
        else
        {
            portfolioStockRepository.save(pStock);
        }
    }
}
