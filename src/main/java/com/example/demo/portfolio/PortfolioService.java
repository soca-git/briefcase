package com.example.demo.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewPortfolio(Portfolio portfolio)
    {
        Optional<Portfolio> portfolioByName = portfolioRepository.findPortfolioByName(portfolio.getName());
        if (portfolioByName.isPresent())
        {
            System.out.println(String.format("The %s portfolio already exists!", portfolio.getName()));
        }
        else
        {
            portfolioRepository.save(portfolio);
        }
    }
}
