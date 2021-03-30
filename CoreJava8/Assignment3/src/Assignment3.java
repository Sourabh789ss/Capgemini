import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Assignment3
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("Aaman", "Bon", "Ciao", "Dream"));

        ListIterator<String> listItr = alphabets.listIterator();

        System.out.println("Backward Direction Traversing");

        while(listItr.hasPrevious()) {
            System.out.println(listItr.previous());
        }
    }
}

