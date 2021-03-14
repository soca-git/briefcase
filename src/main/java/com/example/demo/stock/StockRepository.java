package com.example.demo.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// The type of the Stock id is 'Long'.
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>
{
    // JPA SQL Query
    @Query("SELECT s FROM Stock s WHERE s.ticker = ?1")
    Stock findStockByTicker(String ticker);
}
