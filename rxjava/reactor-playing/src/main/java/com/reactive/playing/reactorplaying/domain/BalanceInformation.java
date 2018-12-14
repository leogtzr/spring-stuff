package com.reactive.playing.reactorplaying.domain;

public class BalanceInformation {

    private double price;

    public BalanceInformation(final double price) {
        this.price = price;
    }

    public BalanceInformation() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BalanceInformation{" +
                "price=" + price +
                '}';
    }

}
