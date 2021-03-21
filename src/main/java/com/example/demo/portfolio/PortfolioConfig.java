package com.example.demo.portfolio;

import com.example.demo.iexclient.IEXClient;
import com.example.demo.portfolioitem.PortfolioItemRepository;
import com.example.demo.stock.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.zankowski.iextrading4j.api.stocks.Quote;

// Here we are creating a set of instructions
// to be run on the server command line.
// Allows us to test some functionalities of
// the database.
@Configuration
public class PortfolioConfig
{

    @Bean
    CommandLineRunner commandLineRunner(PortfolioRepository portfolioRepository, StockRepository stockRepository, PortfolioItemRepository portfolioItemRepository)
    {
        return args -> {

        };
    }
}
