package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Ярослав on 05.07.2016.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        String dot = "";
        for (int i = 0; i < Math.round(this.getDistance()); i++) {
            dot += '.';
        }
        dot += this.getName();
        System.out.println(dot);
    }
}
