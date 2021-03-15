package com.example.demo.portfoliostock;

import com.example.demo.portfolio.Portfolio;
import com.example.demo.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioStockRepository extends JpaRepository<PortfolioStock, Long>
{
    @Query("SELECT ps FROM PortfolioStock ps WHERE ps.owner = ?1 AND ps.stock = ?2")
    PortfolioStock findPortfolioStockByOwnerANDStock(Portfolio owner, Stock stock);

    @Query("SELECT ps FROM PortfolioStock ps WHERE ps.owner = ?1")
    List<PortfolioStock> findPortfolioStocksByOwner(Portfolio owner);
}
