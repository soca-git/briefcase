package com.example.demo.item;

import javax.persistence.*;

@Entity
public class Item
{
    // Setup automatic generation of stock ids
    // for storage in the database.
    // Ids are generated sequentially.
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    @Column(name="id")
    protected Long id;

    @Column(name="name")
    protected String name;

    @Column(name="ticker")
    protected String ticker;

    @Column(name="price")
    protected double price;

    public Item() {
    }

    public Item(String name, String ticker, double price) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
    }

    public Item(Long id, String name, String ticker, double price) {
        this.id = id;
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

    public double getPrice() {
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

    public void setPrice(double price) {
        this.price = price;
    }
}
