package com.example.demo.portfolioitem;

import com.example.demo.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long>
{
    @Query("SELECT pi FROM PortfolioItem pi WHERE pi.owner = ?1")
    List<PortfolioItem> findPortfolioItemsByOwner(Portfolio owner);

    @Query("SELECT pi FROM PortfolioItem pi WHERE pi.owner = ?1 AND pi.item = ?2")
    PortfolioItem findPortfolioItemByOwnerANDItem(Portfolio owner, Item item);
}
