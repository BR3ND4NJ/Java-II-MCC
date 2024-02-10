import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

abstract class Animal implements Comparator<Animal>{
    private enum AnimalType {Cow, Sheep}
    private String name;
    private AnimalType at;
    private int animalNum;
    private static int nextAnimal = 100;

    public Animal(String name, String at) {
        this.name = name;
        this.at = AnimalType.valueOf(at);
        animalNum = nextAnimal;
        nextAnimal++;
    }

    public final String getName() {
        return name;
    }

    public String toString() {
        String s = String.format("Name: %s, Animal Type: %s, Animal Number: %d,"
                + " Sound: %s\n", name, at.toString(), animalNum, Sound());
        return s;
    }

    public boolean equals(Animal o) {
        if (this.at != o.at && this.animalNum != o.animalNum) {
            return false;
        }
        else {
            return true;
        }
    }

    public abstract String Sound();

    public int compare(Animal a, Animal b) {
        return 0;
    }
}


class Cow extends Animal{
    public Cow(String name) {
        super(name, "Cow");
    }

    public String Sound() {
        return "moo";
    }
}


class Sheep extends Animal {
    public Sheep(String name) {
        super(name, "Sheep");
    }

    public String Sound() {
        return "maa";
    }
}


class Farmer {
    private String fname;
    private String lname;

    public Farmer(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public Farmer() {
        this(null, null);
    }

    public Farmer(Farmer o) {
        this(o.getfname(), o.getlname());
    }

    public void setFirstName(String a) {
        fname = a;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public String getfname() {
        return fname;
    }

    public String getlname() {
        return lname;
    }

    public String toString() {
        String s = String.format("First Name: %s, Last Name: %s", fname, lname);
        return s;
    }
}


class Farm {
    private Farmer f;
    private ArrayList<Animal> al;

    public Farm(Farmer f) {
        this.f = new Farmer(f);
        al = new ArrayList<>();
    }

    public Farm() {
        this(new Farmer());
        al = new ArrayList<>();
    }

    public ArrayList getal() {
        return al;
    }

    public String getFarmer() {
        return f.toString();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(f.toString()).append("\n");
        for (Animal a : al) {
            s.append(a.toString()).append("\n");
        }
        return s.toString();
    }

    public void addAnimal(Animal c) {
        al.add(c);
    }

    public void printCows() {
        for (Animal a : al) {
            if (a instanceof Cow) {
                System.out.println(((Cow) a).toString());
            }
        }
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter the first and last name of Farmer");
        String[] name = sn.nextLine().split(", ");
        Farmer f = new Farmer(name[0], name[1]);
        Farm farm = new Farm(f);

        Cow c1 = new Cow("a");
        Cow c2 = new Cow("c");
        Sheep s1 = new Sheep("b");
        Sheep s2 = new Sheep("d");

        farm.addAnimal(c1);
        farm.addAnimal(c2);
        farm.addAnimal(s1);
        farm.addAnimal(s2);

        System.out.println(farm.toString());

        System.out.println(farm.getFarmer());

        farm.printCows();
    }
}
