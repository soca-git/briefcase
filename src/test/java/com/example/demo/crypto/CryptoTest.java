package com.example.demo.crypto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoTest {

    private Crypto crypto;

    @BeforeEach
    void setUp() {
        crypto = new Crypto(
                1L,
                "Bitcoin",
                "BTC",
                10000
        );
    }

    @Test
    void getId() {
        Long id = crypto.getId();
        assertEquals(1L, id);
    }

    @Test
    void getName() {
        String name = crypto.getName();
        assertEquals("Bitcoin", name);
    }

    @Test
    void getTicker() {
        String ticker = crypto.getTicker();
        assertEquals("BTC", ticker);
    }

    @Test
    void getPrice() {
        double price = crypto.getPrice();
        assertEquals(10000, price);
    }

    @Test
    void setId() {
        crypto.setId(2L);
        assertEquals(2L, crypto.getId());
    }

    @Test
    void setName() {
        crypto.setName("Ripple");
        assertEquals("Ripple", crypto.getName());
    }

    @Test
    void setTicker() {
        crypto.setTicker("XRP");
        assertEquals("XRP", crypto.getTicker());
    }

    @Test
    void setPrice() {
        crypto.setPrice(0.5);
        assertEquals(0.5, crypto.getPrice());
    }
}
