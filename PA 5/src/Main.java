import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        else {
            sb.append(s.charAt(s.length()-1)).append(reverseString(s.substring(0, s.length()-1)));
        }
        return sb.toString();
    }


    public static ArrayList<String> reverseArrayList(ArrayList<String> al, int index) {
        ArrayList<String> al2 = new ArrayList<>();
        return reverseHelper(al, al2, index);
    }


    public static ArrayList<String> reverseHelper(ArrayList<String> al, ArrayList<String> al2, int index) {
        if (index == 0) {
            al2.add(al.get(index));
            return al2;
        }
        else {
            al2.add(al.get(index));
            reverseHelper(al, al2, index - 1);
        }
        return al2;
    }


    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();

        System.out.println("Enter a series of Strings, each on a different line. " +
                "When done, type \"Done\".");
        String s = sn.nextLine();

        while(!s.equalsIgnoreCase("done")) {
            al.add(s);
            s = sn.nextLine();
        }

        if (al.size() > 0) {
            System.out.println("Reversed ArrayList of reversed strings:");
            for (String st : reverseArrayList(al, al.size() - 1)) {
                System.out.println(reverseString(st));
            }

            System.out.println("Original ArrayList:");
            for (String st : al) {
                System.out.println(st);
            }
        }
    }
}