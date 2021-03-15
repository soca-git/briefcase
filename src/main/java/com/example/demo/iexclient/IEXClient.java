package com.example.demo.iexclient;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.*;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

public class IEXClient
{
    private final String publicKey;
    private final IEXCloudToken token;
    private final IEXCloudClient cloudClient;

    public IEXClient() {
        this.publicKey = "pk_d7996497b8844a999541274497663935";
        this.token = new IEXCloudTokenBuilder().withPublishableToken(this.publicKey).build();
        this.cloudClient = IEXTradingClient.create(
                IEXTradingApiVersion.IEX_CLOUD_STABLE,
                this.token
        );
    }

    public Quote getQuote(String ticker)
    {
        Quote quote = cloudClient.executeRequest(
                new QuoteRequestBuilder().withSymbol(ticker).build()
        );
        return quote;
    }
}
