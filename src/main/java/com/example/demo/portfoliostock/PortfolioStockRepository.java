package com.example.demo.portfoliostock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioStockRepository extends JpaRepository<PortfolioStock, Long>
{
    @Query("SELECT ps FROM PortfolioStock ps WHERE ps.owner = ?1 AND ps.stock.ticker = ?2")
    Optional<PortfolioStock> findPortfolioStockByOwnerANDStockTicker(String owner, String ticker);
}
