package com.example.demo.portfoliostock;

import com.example.demo.portfolio.Portfolio;
import com.example.demo.stock.Stock;

import javax.persistence.*;

@Entity
@Table(name="portfolio_stock")
public class PortfolioStock
{
    @Id
    @SequenceGenerator(
            name = "pstock_sequence",
            sequenceName = "pstock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pstock_sequence"
    )
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="portfolio", nullable=false)
    private Portfolio owner;

    @ManyToOne
    @JoinColumn(name="stock", nullable = false)
    private Stock stock;

    @Column(name="quantity")
    private int quantity;

    public PortfolioStock() {
    }

    public PortfolioStock(Long id, Portfolio owner, Stock stock, int quantity) {
        this.id = id;
        this.owner = owner;
        this.stock = stock;
        this.quantity = quantity;
    }

    public PortfolioStock(Portfolio owner, Stock stock, int quantity) {
        this.owner = owner;
        this.stock = stock;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Portfolio getOwner() {
        return owner;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(Portfolio owner) {
        this.owner = owner;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PortfolioStock{" +
                "id=" + id +
                ", owner=" + owner +
                ", stock=" + stock +
                ", quantity=" + quantity +
                '}';
    }
}
