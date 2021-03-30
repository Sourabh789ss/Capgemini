import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
    public static void main(String[] args)
    {
        System.out.println(" Elements to be inserted: 2 3 3 4 9");

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        LinkedHashSet<Integer> set1 = new LinkedHashSet<Integer>();

        set1=ordered(set);
        System.out.print("Elements of LinkedHashSet: ");
        System.out.println(set1);


        HashSet<Integer> numSet = new HashSet<Integer>();
        HashSet<Integer> numSet1 = new HashSet<Integer>();

        numSet1=unordered(numSet);
        System.out.print("Elements of HashSet: ");
        System.out.print(numSet1);
    }

    public static LinkedHashSet<Integer> ordered(LinkedHashSet<Integer> linkedHashSet)
    {
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        linkedHashSet.add(3);
        linkedHashSet.add(4);
        linkedHashSet.add(9);

        return linkedHashSet;
    }

    public static HashSet<Integer> unordered(HashSet<Integer> hashSet)
    {
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(9);
        return hashSet;
    }
}