package com.example.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioService
{
    private final PortfolioRepository portfolioRepository;

    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository)
    {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getPortfolios()
    {
        return portfolioRepository.findAll();
    }

    public Portfolio getOrCreatePortfolio(Portfolio portfolio)
    {
        Portfolio portfolioByName = portfolioRepository.findPortfolioByName(portfolio.getName());
        if (portfolioByName != null)
        {
            System.out.println(String.format("The %s portfolio already exists!", portfolio.getName()));
            return portfolioByName;
        }
        else
        {
            portfolioRepository.save(portfolio);
            return portfolio;
        }
    }
}
