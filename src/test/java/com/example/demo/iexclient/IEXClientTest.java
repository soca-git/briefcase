package com.example.demo.iexclient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import static org.junit.jupiter.api.Assertions.*;

class IEXClientTest {

    private IEXClient client;

    @BeforeEach
    void setUp() {
        client = new IEXClient();
    }

    @Test
    void getStockQuote() {
        Quote quote = client.getStockQuote("AAPL");
        assertNotNull(quote);
    }

    @Test
    void getCryptoQuote() {
        Quote quote = client.getCryptoQuote("XRPUSDT");
        assertNotNull(quote);
    }
}
