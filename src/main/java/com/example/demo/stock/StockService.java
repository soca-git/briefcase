package com.example.demo.stock;

import com.example.demo.iexclient.IEXClient;
import com.example.demo.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zankowski.iextrading4j.api.stocks.Quote;

import java.util.List;

// Spring 'bean' for auto-wire to
// stock controller.
@Service
public class StockService extends ItemService
{
    private final StockRepository stockRepository;
    private final IEXClient iexClient;

    // Again, using dependency injection
    // to connect to the stock repository interface.
    @Autowired
    public StockService(StockRepository stockRepository)
    {
        this.stockRepository = stockRepository;
        this.iexClient = new IEXClient();
    }

    public Stock getOrCreateStock(String ticker)
    {
        Stock stockByTicker = stockRepository.findStockByTicker(ticker);
        if (stockByTicker != null)
        {
            System.out.println(String.format("The %s ticker already exists!", stockByTicker.getTicker()));
            return stockByTicker;
        }
        else
        {
            return createStock(ticker);
        }
    }

    public Stock createStock(String ticker)
    {
        Quote quote = iexClient.getStockQuote(ticker);
        double price = quote.getLatestPrice().doubleValue();
        String name = quote.getCompanyName();
        Stock stock = new Stock(name, ticker, price);
        stockRepository.save(stock);
        return stock;
    }

    public void updatePrice(Stock stock)
    {
        Quote quote = iexClient.getStockQuote(stock.getTicker());
        System.out.println(quote.getLatestPrice());
        stock.setPrice(quote.getLatestPrice().doubleValue());
        stockRepository.save(stock);
    }

    public List<Stock> getStocks()
    {
        // Now that we have added the JPA repository for the database,
        // we have access to JPA methods available for handling
        // database operations.
        return stockRepository.findAll();
    }
}
