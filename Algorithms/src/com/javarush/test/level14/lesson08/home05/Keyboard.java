package com.javarush.test.level14.lesson08.home05;

/**
 * Created by User on 4/7/2016.
 */
public class Keyboard implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
