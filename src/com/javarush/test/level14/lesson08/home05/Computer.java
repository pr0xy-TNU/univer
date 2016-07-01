package com.javarush.test.level14.lesson08.home05;

/**
 * Created by User on 4/7/2016.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }

    public Computer(Keyboard keyboard, Monitor monitor, Mouse mouse)
    {
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;

    }

    public Keyboard getKeyboard()
    {

        return keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }
}
