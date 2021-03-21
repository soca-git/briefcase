package com.example.demo.stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    private Stock stock;

    @BeforeEach
    void setUp() {
        stock = new Stock(
                1L,
                "Microsoft",
                "MSFT",
                200
        );
    }

    @Test
    void getId() {
        Long id = stock.getId();
        assertEquals(1L, id);
    }

    @Test
    void getName() {
        String name = stock.getName();
        assertEquals("Microsoft", name);
    }

    @Test
    void getTicker() {
        String ticker = stock.getTicker();
        assertEquals("MSFT", ticker);
    }

    @Test
    void getPrice() {
        double price = stock.getPrice();
        assertEquals(200, price);
    }

    @Test
    void setId() {
        stock.setId(2L);
        assertEquals(2L, stock.getId());
    }

    @Test
    void setName() {
        stock.setName("Apple");
        assertEquals("Apple", stock.getName());
    }

    @Test
    void setTicker() {
        stock.setTicker("AAPL");
        assertEquals("AAPL", stock.getTicker());
    }

    @Test
    void setPrice() {
        stock.setPrice(120);
        assertEquals(120, stock.getPrice());
    }
}
