package com.example.demo.crypto;

import com.example.demo.iexclient.IEXClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import java.util.List;

@Service
public class CryptoService
{
    private final CryptoRepository cryptoRepository;
    private final IEXClient iexClient;

    @Autowired
    public CryptoService(CryptoRepository cryptoRepository)
    {
        this.cryptoRepository = cryptoRepository;
        this.iexClient = new IEXClient();
    }

    public Crypto getOrCreateCrypto(String ticker, double buyPrice)
    {
        Crypto cryptoByTicker = cryptoRepository.findCryptoByTicker(ticker);
        if (cryptoByTicker != null)
        {
            System.out.println(String.format("The %s ticker already exists!", cryptoByTicker.getTicker()));
            return cryptoByTicker;
        }
        else
        {
            return createCrypto(ticker, buyPrice);
        }
    }

    public Crypto createCrypto(String ticker, double buyPrice)
    {
        Quote quote = iexClient.getCryptoQuote(ticker);
        double price = quote.getLatestPrice().doubleValue();
        Crypto crypto = new Crypto(ticker, buyPrice, price);
        cryptoRepository.save(crypto);
        return crypto;
    }

    public List<Crypto> getCryptos()
    {
        return cryptoRepository.findAll();
    }
}
