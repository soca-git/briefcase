package com.example.demo.portfolio;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
public class Portfolio
{
    @Id
    @SequenceGenerator(
            name = "portfolio_sequence",
            sequenceName = "portfolio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "portfolio_sequence"
    )
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    public Portfolio() {
    }

    public Portfolio(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Portfolio(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
