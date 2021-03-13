package com.example.demo.stock;

import javax.persistence.*;

@Entity
@Table
public class Stock
{
    // Setup automatic generation of stock ids
    // for storage in the database.
    // Ids are generated sequentially.
    @Id
    @SequenceGenerator(
            name = "stock_sequence",
            sequenceName = "stock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )
    private Long id;
    private String name;
    private String ticker;
    private int price;

    public Stock() {
    }

    public Stock(Long id, String name, String ticker, int price) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.price = price;
    }

    public Stock(String name, String ticker, int price) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", price=" + price +
                '}';
    }
}
