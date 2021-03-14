package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Spring 'bean' for auto-wire to
// stock controller.
@Service
public class StockService
{
    private final StockRepository stockRepository;

    // Again, using dependency injection
    // to connect to the stock repository interface.
    @Autowired
    public StockService(StockRepository stockRepository)
    {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks()
    {
        // Now that we have added the JPA repository for the database,
        // we have access to JPA methods available for handling
        // database operations.
        return stockRepository.findAll();
    }

    public Stock getOrCreateStock(Stock stock)
    {
        Stock stockByTicker = stockRepository.findStockByTicker(stock.getTicker());
        if (stockByTicker != null)
        {
            System.out.println(String.format("The %s ticker already exists!", stock.getTicker()));
            return stockByTicker;
        }
        else
        {
            stockRepository.save(stock);
            return stock;
        }
    }
}
