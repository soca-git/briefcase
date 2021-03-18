package com.example.demo.stock;

import com.example.demo.item.Item;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock extends Item
{
    public Stock() {
    }

    public Stock(String name, String ticker, double price) {
        this.name = name;
        this.ticker = ticker;
        this.price = price;
    }

    public Stock(Long id, String name, String ticker, double price) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
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
