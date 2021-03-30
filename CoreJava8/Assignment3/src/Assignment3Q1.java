import com.sun.source.tree.Tree;

import java.util.*;

class Person {

    private String name;
    private int height;
    private double weight;

    public Person() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String toString() {
        return name + height + weight;
    }
}

 class Test {

    public static void main(String[] args) {
       List<Person> persons = (List<Person>) new TreeSet<Person>();
        persons.add(new Person("abc", 178, 55.6));
        persons.add(new Person("def", 160, 62.0));
        persons.add(new Person("xyz", 155, 98.7));
        persons.add(new Person("opw", 182, 77.3));

        Collections.sort(persons, new Comparator<Person>() {

            public int compare(Person t, Person t1) {
                int comp = Double.compare(t.getWeight(),t1.getWeight());
                if (comp != 0) {
                    return comp;
                }
                return t.getHeight() - t1.getHeight();
            }
        });
        System.out.println(persons);

    }
}