package com.example.demo.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// Here we are creating a set of instructions
// to be run on the server command line.
// Allows us to test some functionalities of
// the database.
@Configuration
public class StockConfig
{

    @Bean
    CommandLineRunner commandLineRunner(StockRepository stockRepository)
    {
        return args -> {
            Stock apple = new Stock("Apple", "AAPL", 120);
            Stock nio = new Stock("Nio", "NIO", 50);

            stockRepository.saveAll(List.of(apple, nio));
        };
    }
}
