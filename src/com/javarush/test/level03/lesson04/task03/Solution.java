package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg z1= new Zerg();
        z1.name = "ad1";
        Zerg z2= new Zerg();
        z2.name = "ad2";
        Zerg z3= new Zerg();
        z3.name = "ad3";
        Zerg z4= new Zerg();
        z4.name = "ad4";
        Zerg z5= new Zerg();
        z5.name = "ada";
        Zerg z6= new Zerg();
        z6.name = "ad6";
        Zerg z7= new Zerg();
        z7.name = "ad34";
        Zerg z8= new Zerg();
        z8.name = "ad98";
        Zerg z9= new Zerg();
        z9.name = "ad97";
        Zerg z10= new Zerg();
        z10.name = "ad96";

        Protos p1= new Protos();
        p1.name = "protos1";
        Protos p2= new Protos();
        p2.name = "protos2";
        Protos p3= new Protos();
        p3.name = "protos3";
        Protos p4= new Protos();
        p4.name = "protos4";
        Protos p5= new Protos();
        p5.name = "protos5";

        Terran t1= new Terran();
        t1.name = "terranium1";
        Terran t2= new Terran();
        t2.name = "terranium2";
        Terran t3= new Terran();
        t3.name = "terranium3";
        Terran t4= new Terran();
        t4.name = "terranium4";
        Terran t5= new Terran();
        t5.name = "terranium5";
        Terran t6= new Terran();
        t6.name = "terranium6";
        Terran t7= new Terran();
        t7.name = "terranium77";
        Terran t8= new Terran();
        t8.name = "terranium8";
        Terran t9= new Terran();
        t9.name = "terranium9";
        Terran t10= new Terran();
        t10.name = "terranium10";
        Terran t11= new Terran();
        t11.name = "terranium11";
        Terran t12= new Terran();
        t12.name = "terranium12";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}