package com.example.demo.portfolioitem;

import com.example.demo.item.Item;
import com.example.demo.portfolio.Portfolio;

import javax.persistence.*;

@Entity
@Table(name="portfolio_item")
public class PortfolioItem
{
    @Id
    @SequenceGenerator(
            name = "pitem_sequence",
            sequenceName = "pitem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pitem_sequence"
    )
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="portfolio", nullable=false)
    private Portfolio owner;

    @ManyToOne
    @JoinColumn(name="item")
    private Item item;

    @Column(name="buyPrice")
    private double buyPrice;

    @Column(name="quantity")
    private double quantity;

    public PortfolioItem() {
    }

    public PortfolioItem(Portfolio owner, Item item, double buyPrice, double quantity) {
        this.owner = owner;
        this.item = item;
        this.buyPrice = buyPrice;
        this.quantity = quantity;
    }

    public PortfolioItem(Long id, Portfolio owner, Item item, double buyPrice, double quantity) {
        this.id = id;
        this.owner = owner;
        this.item = item;
        this.buyPrice = buyPrice;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Portfolio getOwner() {
        return owner;
    }

    public Item getItem() {
        return item;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(Portfolio owner) {
        this.owner = owner;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PortfolioItem{" +
                "id=" + id +
                ", owner=" + owner +
                ", item=" + item +
                ", buyPrice=" + buyPrice +
                ", quantity=" + quantity +
                '}';
    }
}
