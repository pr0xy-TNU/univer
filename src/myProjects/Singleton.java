package myProjects;


/**
 * Created by User on 4/21/2016.
 */
public class Singleton
{
    private static Singleton singleton;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        synchronized (Singleton.class)
        {
            if (singleton == null)
            {
                singleton = new Singleton();
                return singleton;
            }
        }
        return singleton;
    }
}
