package com.example.demo.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long>
{
    @Query("SELECT p FROM Portfolio p WHERE p.name = ?1")
    Portfolio findPortfolioByName(String name);
}
