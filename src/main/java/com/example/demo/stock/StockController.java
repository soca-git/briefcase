package com.example.demo.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/stock")
public class StockController
{
    private final StockService stockService;

    // Autowired is used for dependency injection.
    // StudentService is instantiated for injection in the
    // constructor. The alternative is to directly
    // instantiate a new StockService object in the
    // constructor, but apparently this is bad.
    // Read up about dependency injection.
    @Autowired
    public StockController(StockService stockService)
    {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStocks()
    {
        return stockService.getStocks();
    }

    // RequestBody maps the JSON body received in the
    // post request to a Stock object for insertion
    // into the database.
    @PostMapping
    public void addNewStock(@RequestBody Stock stock)
    {
        stockService.addNewStock(stock);
    }
}
