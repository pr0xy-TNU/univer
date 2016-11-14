package com.javarush.test.level21.lesson08.task01;

import java.util.*;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }


    @Override
    protected Solution clone() throws CloneNotSupportedException {

        Solution clones = new Solution();

        if (this.users != null) {
            for (Map.Entry<String, User> item : this.users.entrySet()) {
                clones.users.put(item.getKey(), new User(item.getValue().age, item.getValue().name));
            }
        }
        return clones;

    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }
}