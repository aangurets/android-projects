package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    @JsonProperty("code")
    private int mCode;

    @JsonProperty("name")
    private String mName;

    @JsonProperty("author")
    private String mAuthor;

    @JsonProperty("lang")
    private String mLanguage;

    @JsonProperty("pages")
    private int mPages;

    @JsonProperty("price")
    private int mPrice;

    @JsonProperty("link")
    private String mLink;

    private boolean isFavorite;

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getCode() {
        return String.valueOf(mCode);
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        this.mLanguage = language;
    }

    public String getPages() {
        return String.valueOf(mPages);
    }

    public void setPages(int pages) {
        this.mPages = pages;
    }

    public String getPrice() {
        return String.valueOf(mPrice);
    }

    public void setPrice(int price) {
        this.mPrice = price;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        this.mLink = link;
    }

    @Override
    public String toString() {
        return "Book[ " +
                "Code: " + mCode + '\'' +
                ", Name: " + mName + '\'' +
                ", Author: " + mAuthor + '\'' +
                ", Language: " + mLanguage + '\'' +
                ", Pages: " + mPages + '\'' +
                ", Price: " + mPrice + '\'' +
                ", Link: " + mLink + '\'' +
                ']';
    }
}
