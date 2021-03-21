package com.example.demo.crypto;

import com.example.demo.iexclient.IEXClient;
import com.example.demo.item.ItemService;
import com.example.demo.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import java.util.List;

@Service
public class CryptoService extends ItemService
{
    private final CryptoRepository cryptoRepository;
    private final IEXClient iexClient;

    @Autowired
    public CryptoService(CryptoRepository cryptoRepository)
    {
        this.cryptoRepository = cryptoRepository;
        this.iexClient = new IEXClient();
    }

    public Crypto getOrCreateCrypto(String ticker)
    {
        Crypto cryptoByTicker = cryptoRepository.findCryptoByTicker(ticker);
        if (cryptoByTicker != null)
        {
            System.out.println(String.format("The %s ticker already exists!", cryptoByTicker.getTicker()));
            return cryptoByTicker;
        }
        else
        {
            return createCrypto(ticker);
        }
    }

    public Crypto createCrypto(String ticker)
    {
        Quote quote = iexClient.getCryptoQuote(ticker);
        double price = quote.getLatestPrice().doubleValue();
        Crypto crypto = new Crypto(ticker, price);
        cryptoRepository.save(crypto);
        return crypto;
    }

    public void updatePrice(Crypto crypto)
    {
        Quote quote = iexClient.getStockQuote(crypto.getTicker());
        crypto.setPrice(quote.getLatestPrice().doubleValue());
        cryptoRepository.save(crypto);
    }

    public List<Crypto> getCryptos()
    {
        return cryptoRepository.findAll();
    }
}
