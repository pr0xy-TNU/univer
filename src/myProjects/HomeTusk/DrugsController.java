package myProjects.HomeTusk;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 4/21/2016.
 */
public class DrugsController
{
    public static Map<Drugs, Integer> allDrugs = new HashMap<Drugs, Integer>();

    static
    {
        Drugs panadol = new Drugs();
        panadol.setName("Panadol");
        allDrugs.put(panadol, 10);

        Drugs analgin = new Drugs();
        analgin.setName("Analgin");
        allDrugs.put(analgin, 20);

        Drugs placebo = new Drugs();
        placebo.setName("Placebo");
        allDrugs.put(placebo, 23);
    }

    public synchronized void sell(Drugs drug, int count)
    {
        String name = Thread.currentThread().getName();
        if (!allDrugs.containsKey(drug))
        {
            System.out.println("Нет в наличии");
        }
        Integer currentCount = allDrugs.get(drug);
        if (currentCount < count)
        {
            System.out.println(String.format("%s хочет %s %d шт. В наличии - %d", name, drug.getName(), count, currentCount));
        }
        else
        {
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s купил(а) %s %d шт. Осталось - %d", name, drug.getName(), count, (currentCount - count)));
        }
    }
    public synchronized void buy(Drugs drugs, int count)
    {
        System.out.println("Закупка " + drugs.getName() + " " + count);
        if (!allDrugs.containsKey(drugs))
        {
            allDrugs.put(drugs, 0);
        }

        Integer currentCount = allDrugs.get(drugs);
        allDrugs.put(drugs, (currentCount - count));
    }



}
