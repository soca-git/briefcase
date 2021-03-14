package com.example.demo.portfolio;

import com.example.demo.portfoliostock.PortfolioStock;
import com.example.demo.portfoliostock.PortfolioStockRepository;
import com.example.demo.stock.Stock;
import com.example.demo.stock.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// Here we are creating a set of instructions
// to be run on the server command line.
// Allows us to test some functionalities of
// the database.
@Configuration
public class PortfolioConfig
{

    @Bean
    CommandLineRunner commandLineRunner(PortfolioRepository portfolioRepository, StockRepository stockRepository, PortfolioStockRepository portfolioStockRepository)
    {
        return args -> {
            Portfolio soca = new Portfolio("soca");
            portfolioRepository.save(soca);

            Stock apple = new Stock("Apple", "AAPL", 120);
            Stock nio = new Stock("Nio", "NIO", 50);
            stockRepository.saveAll(List.of(apple, nio));

            PortfolioStock portfolio_apple = new PortfolioStock(soca, apple, 20);
            PortfolioStock portfolio_nio = new PortfolioStock(soca, nio, 50);
            portfolioStockRepository.saveAll(List.of(portfolio_apple, portfolio_nio));
        };
    }
}
