package myProjects.bonus1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Runtime.getRuntime;

/**
 * Created by User on 4/24/2016.
 */
public class Main
{
    public volatile static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(new Person("Ивано Петрович", Sex.MALE, new Date()));
        allPeople.add(new Person("Зинаида Ивановна", Sex.FEMALE, new Date()));
        allPeople.add(new Person("Ivan Won", Sex.FEMALE, new Date()));
    }



    public static void main(String[] args) throws IOException, ParseException
    {
        while (true)
        {
            String value =  in.readLine();
            if (value.toLowerCase().equals("exit"))
            {
                writePersonInFile();
                break;
            }
            String[] param = value.split(" ");
            if (param[0].equals("-c"))
            {
                if (param.length != 4)
                    return;
                Person person = createPerson(param);
                allPeople.add(person);
            }
            if (param[0].equals("-d"))
            {
                if (param.length !=2)
                    return;
                int index = Integer.parseInt(param[1]);
                allPeople.remove(index);
            }
            if (param[0].equals("-u"))
            {
                if (param.length != 5)
                    return;
                Person person = createPerson(param);
                allPeople.add(Integer.parseInt(param[1]), person);
            }
            if (param[0].equals("-i"))
            {
                if (param[1].equals("all"))
                {
                    for (Person person : allPeople)
                    {
                        System.out.println(person);
                    }
                }
                if(!param[1].isEmpty())
                {
                    System.out.println(allPeople.get(Integer.parseInt(param[1])));
                }
            }
        }
    }
    public static Person createPerson(String[] param) throws ParseException
    {
        int shiftIndex = 0;
        if (param[0].equals("-c"))
        {
            shiftIndex = 0;
        }
        if (param[0].equals("-u"))
        {
            shiftIndex = 1;
        }
        Person person;
        if (param[2].equals("м"))
            person = Person.createMale(param[1 + shiftIndex], format.parse(param[3 + shiftIndex]));
        else
            person = Person.createFemale(param[1 + shiftIndex], format.parse(param[3 + shiftIndex]));
        return person;
    }
    public static void writePersonInFile() throws IOException
    {
        RandomAccessFile file = new RandomAccessFile("D:\\per.txt", "rw");
        file.skipBytes((int)file.length());
        for (Person person : allPeople)
        {
            file.writeBytes(person.toString() + "\n");
        }
        file.close();
    }
}
