package com.javarush.test.level21.lesson08.task02;

import java.lang.reflect.Array;
import java.util.Arrays;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new CloneNotSupportedException();
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }


        @Override
        protected Tree clone() throws CloneNotSupportedException {

            if (branches == null)
                return  new Tree(super.name, null);

            String[] newBranches = Arrays.copyOf(getBranches(), getBranches().length);
            Tree tree = new Tree( super.name, newBranches);
            return tree;
        }
    }
}
