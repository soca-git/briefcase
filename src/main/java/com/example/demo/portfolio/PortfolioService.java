package com.example.demo.portfolio;

import com.example.demo.item.ItemService;
import com.example.demo.portfolioitem.PortfolioItem;
import com.example.demo.portfolioitem.PortfolioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PortfolioService
{
    private final PortfolioRepository portfolioRepository;
    private final PortfolioItemService portfolioItemService;
    private final ItemService itemService;

    @Autowired
    public PortfolioService(
            PortfolioRepository portfolioRepository,
            PortfolioItemService portfolioItemService,
            ItemService itemService
    )
    {
        this.portfolioRepository = portfolioRepository;
        this.portfolioItemService = portfolioItemService;
        this.itemService = itemService;
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

    public void updatePrices(Portfolio portfolio)
    {
        for (PortfolioItem pItem : portfolioItemService.getPortfolioItems(portfolio))
        {
            itemService.updatePrice(pItem.getItem());
        }
    }

    public List<Portfolio> getPortfolios()
    {
        return portfolioRepository.findAll();
    }
}
