import java.util.*;
class SingletonInheritanceCheck{
    private static SingletonInheritanceCheck inst =null;
    int j;
    private SingletonInheritanceCheck()
    {
        j=10;
    }
    public static SingletonInheritanceCheck getInstance()
    {
        if (inst == null)
        {
            inst = new SingletonInheritanceCheck();
        }
        return inst;
    }
}

public class Assignment2Q1 {
    public static void main(String args[])
    {
        SingletonInheritanceCheck obj=SingletonInheritanceCheck.getInstance();
        obj.j=40;
        System.out.println("Singleton Instance value "+obj.j);
    }
}