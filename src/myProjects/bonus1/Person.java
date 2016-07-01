package myProjects.bonus1;

import java.util.Date;

/**
 * Created by User on 4/24/2016.
 */
public class Person
{
    private String name;
    private Sex sex;
    private Date birthDay;

    public Person(String name, Sex sex, Date birthDay)
    {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay)
    {
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay)
    {
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }

    public String getName()
    {
        return name;
    }

    public Sex getSex()
    {
        return sex;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }

    @Override
    public String toString()
    {
        return this.getName() + " " + this.getSex() + " " + this.getBirthDay();
    }
}
