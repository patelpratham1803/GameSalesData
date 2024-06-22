package com.example.videogamesales;

import java.math.BigDecimal;

public class SalesData {
    private String gameTitle;        // Title of the game
    private String platform;         // Platform (e.g., PS4, Xbox One)
    private int yearOfRelease;       // Year of release
    private String genre;            // Genre of the game
    private String publisher;        // Publisher of the game
    private BigDecimal globalSales;  // Global sales of the game

    public SalesData(String gameTitle, String platform, int yearOfRelease, String genre, String publisher, BigDecimal globalSales) {
        this.gameTitle = gameTitle;
        this.platform = platform;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.publisher = publisher;
        this.globalSales = globalSales;
    }

    // Getters and Setters

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(BigDecimal globalSales) {
        this.globalSales = globalSales;
    }
}
