package com.example.demo.portfolioitem;

import com.example.demo.item.Item;
import com.example.demo.portfolio.Portfolio;
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

    public PortfolioItem getOrCreatePortfolioItem(Portfolio portfolio, Item item, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItemByOwnerAndItem = portfolioItemRepository.findPortfolioItemByOwnerANDItem(
                portfolio, item
        );
        if (portfolioItemByOwnerAndItem != null)
        {
            System.out.println(
                    String.format(
                            "The %s stock already exists for owner %s!",
                            portfolioItemByOwnerAndItem.getItem().getTicker(),
                            portfolioItemByOwnerAndItem.getOwner().getName()
                    )
            );
            return portfolioItemByOwnerAndItem;
        }
        else
        {
            return createPortfolioItem(portfolio, item, buyPrice, quantity);
        }
    }

    public PortfolioItem createPortfolioItem(Portfolio portfolio, Item item, double buyPrice, double quantity)
    {
        PortfolioItem portfolioItem = new PortfolioItem(portfolio, item, buyPrice, quantity);
        portfolioItemRepository.save(portfolioItem);
        return portfolioItem;
    }

    public List<PortfolioItem> getPortfolioItems(Portfolio portfolio)
    {
        return portfolioItemRepository.findPortfolioItemsByOwner(portfolio);
    }

    public void deletePortfolioItem(Long id)
    {
        boolean exists = portfolioItemRepository.existsById(id);
        if (exists)
        {
            portfolioItemRepository.deleteById(id);
        }
    }
}
