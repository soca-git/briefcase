package com.example.demo.portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    Portfolio portfolio;

    @BeforeEach
    void setUp() {
        portfolio = new Portfolio(1L, "test");
    }

    @Test
    void getId() {
        Long id = portfolio.getId();
        assertEquals(1L, id);
    }

    @Test
    void getName() {
        String name = portfolio.getName();
        assertEquals("test", name);
    }

    @Test
    void setId() {
        portfolio.setId(2L);
        assertEquals(2L, portfolio.getId());
    }

    @Test
    void setName() {
        portfolio.setName("test2");
        assertEquals("test2", portfolio.getName());
    }
}
