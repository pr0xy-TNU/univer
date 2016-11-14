package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

/**
 * Created by Ярослав on 05.07.2016.
 */
public class Hippodrome {

    public static Hippodrome game;

    public ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome();
        Horse h1 = new Horse("Ludovic", 3, 0);
        Horse h2 = new Horse("Poli", 3, 0);
        Horse h3 = new Horse("Robert", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move() {
        for (Horse horse : getHorses()
                ) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()
                ) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double dis = 0;
        Horse winner = null;
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > dis) {
                dis = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
