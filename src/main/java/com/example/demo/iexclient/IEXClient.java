package com.example.demo.iexclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.*;
import pl.zankowski.iextrading4j.client.rest.request.alternative.CryptoRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

public class IEXClient
{
    private final String publicKey;
    private final String secretKey;
    private final IEXCloudToken token;
    private final IEXCloudClient cloudClient;
    private final String version;

    public IEXClient()
    {
        this.publicKey = "pk_d7996497b8844a999541274497663935";
        this.secretKey = "sk_5b4f8a0d878245189977ce9a2d366c50";
        token = new IEXCloudTokenBuilder().withPublishableToken(publicKey).build();
        version = "IEX_CLOUD_V1";
        cloudClient = IEXTradingClient.create(
                IEXTradingApiVersion.IEX_CLOUD_V1,
                token
        );
    }

    public Quote getStockQuote(String ticker)
    {
        Quote quote = cloudClient.executeRequest(
                new QuoteRequestBuilder().withSymbol(ticker).build()
        );
        return quote;
    }

    public Quote getCryptoQuote(String ticker)
    {
        Quote quote = cloudClient.executeRequest(
                new CryptoRequestBuilder().withSymbol(ticker).build()
        );
        return quote;
    }

    public String getVersion() {
        return version;
    }
}
