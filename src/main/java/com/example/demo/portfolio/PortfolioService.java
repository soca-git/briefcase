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

    public List<Portfolio> getPortfolios()
    {
        return portfolioRepository.findAll();
    }
}
