package com.example.demo.crypto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, Long>
{
    @Query("SELECT c FROM Crypto c WHERE c.ticker = ?1")
    Crypto findCryptoByTicker(String Ticker);
}
