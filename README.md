
# Financial Portfolio Application

[![Heroku CI/CD](https://github.com/soca-git/briefcase/actions/workflows/maven.yml/badge.svg)](https://github.com/soca-git/briefcase/actions/workflows/maven.yml)

> A personal project which aims to create a simple but effective application  
> which enables a user to create a portfolio of their financial assets,  
> including  Stocks, Cryptocurrencies and Commodities.  
> A dashboard will present the user with an informative overview of their current holdings,  
> in the form of charts, tables and metrics.  

> All market data is provided by [IEX Cloud](https://iexcloud.io/docs/api/).
> 
> Sample Portfolio:  
> https://briefcase-app.herokuapp.com/api/v1/portfolio?name=example  
> (allow some time for loading)

![dashboard](dashboard.png)


## Application Features

- [x] Create Portfolio.
- [x] Add stock quantity using ticker symbol.
- [x] Add crypto quantity using ticker symbol.
- [ ] Add commodity quantity using ticker symbol.
- [x] Create Client for IEX Cloud interactions.
- [x] Initial metrics.
- [x] Initial charts.
- [x] Portfolio items table.
- [x] Add ability to supply purchase price of item.
- [x] Add profit/loss related metrics.
- [ ] Add available ticker symbol index/search.
- [x] Add ability to update/refresh market prices.
- [x] Add ability to remove items from a portfolio.


## Project Milestones

- [x] Study/research Spring framework.
- [x] Implement Demo Application using Spring framework.
- [x] Implement version control through Git/GitHub.
- [ ] Create project issues on GitHub to manage project timeline.
- [x] Deploy Application to Heroku.
- [x] Implement Test Suite for back-end using JUnit.
- [x] Study/research CI/CD.
- [x] Implement CI/CD pipeline.
- [ ] Investigate front-end framework/libraries.
- [ ] Mobile friendly.


## Technologies

> * Java
> * Maven
> * Spring/Spring Boot
> * Spring Data JPA
> * Postges
> * [iextrading4j](https://github.com/WojciechZankowski/iextrading4j)
> * IEX Cloud API
> * Heroku
> * Git/GitHub
> * Git Actions

> * HTML/CSS
> * JavaScript
> * Bootstrap 4
> * ChartJS
