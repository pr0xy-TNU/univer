package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double maney;

    public Money(double amount)
    {
        this.maney = amount;
    }

    public double getAmount()
    {
        return this.maney;
    };


    public abstract String getCurrencyName();
}

