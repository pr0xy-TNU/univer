package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by User on 4/17/2016.
 */
public class Plane implements Flyable
{
    private int passenger;

    public Plane(int passenger)
    {
        this.passenger = passenger;
    }

    @Override
    public void fly()
    {

    }
}
