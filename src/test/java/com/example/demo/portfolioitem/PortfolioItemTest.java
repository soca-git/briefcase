package com.example.demo.portfolioitem;

import com.example.demo.item.Item;
import com.example.demo.portfolio.Portfolio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioItemTest {

    private Portfolio portfolio;
    private Item item;
    private PortfolioItem portfolioItem;

    @BeforeEach
    void setUp() {
        portfolio = new Portfolio("test");
        item = new Item("Apple", "AAPL", 120);
        portfolioItem = new PortfolioItem(
                1L,
                portfolio,
                item,
                100,
                50
        );
    }

    @Test
    void getId() {
        Long id = portfolioItem.getId();
        assertEquals(1L, id);
    }

    @Test
    void getOwner() {
        Portfolio owner = portfolioItem.getOwner();
        assertEquals(portfolio, owner);
    }

    @Test
    void getItem() {
        Item item = portfolioItem.getItem();
        assertEquals(this.item, item);
    }

    @Test
    void getBuyPrice() {
        double buyPrice = portfolioItem.getBuyPrice();
        assertEquals(100, buyPrice);
    }

    @Test
    void getQuantity() {
        double quantity = portfolioItem.getQuantity();
        assertEquals(50, quantity);
    }

    @Test
    void setId() {
        portfolioItem.setId(2L);
        assertEquals(2L, portfolioItem.getId());
    }

    @Test
    void setOwner() {
        portfolio = new Portfolio("test2");
        portfolioItem.setOwner(portfolio);
        assertEquals(portfolio, portfolioItem.getOwner());
    }

    @Test
    void setItem() {
        item = new Item("Microsoft", "MSFT", 200);
        portfolioItem.setItem(item);
        assertEquals(item, portfolioItem.getItem());
    }

    @Test
    void setBuyPrice() {
        portfolioItem.setBuyPrice(150);
        assertEquals(150, portfolioItem.getBuyPrice());
    }

    @Test
    void setQuantity() {
        portfolioItem.setQuantity(100);
        assertEquals(100, portfolioItem.getQuantity());
    }
}
