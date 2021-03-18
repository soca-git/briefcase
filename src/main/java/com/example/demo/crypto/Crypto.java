package com.example.demo.crypto;

import com.example.demo.item.Item;

import javax.persistence.*;

@Entity
@Table(name="crypto")
public class Crypto extends Item
{
    public Crypto() {
    }

    public Crypto(String ticker, double buyPrice, double price) {
        this.name = "Cryptocurrency - " + ticker;
        this.ticker = ticker;
        this.buyPrice = buyPrice;
        this.price = price;
    }

    public Crypto(String name, String ticker, double buyPrice, double price) {
        this.name = name;
        this.ticker = ticker;
        this.buyPrice = buyPrice;
        this.price = price;
    }

    public Crypto(Long id, String name, String ticker, double buyPrice, double price) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.buyPrice = buyPrice;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", buyPrice=" + buyPrice +
                ", price=" + price +
                '}';
    }
}
