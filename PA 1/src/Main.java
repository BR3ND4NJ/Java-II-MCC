import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;


class tools {
    public static int wordCounter(String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                num++;
            }
        }
        num++;

        return num;
    }


    public static String convertToString(ArrayList<Character> al) {
        StringBuilder sb = new StringBuilder();

        for (char c : al) {
            sb.append(c);
        }

        return sb.toString();
    }


    public static char mostFound(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        s = s.toUpperCase();

        for (int i = 0; i < s.length(); i++) {
            if (!h.containsKey(s.charAt(i))) {
                h.put(s.charAt(i), 1);
            }
            else {
                h.replace(s.charAt(i), h.get(s.charAt(i)) + 1);
            }
        }

        int max = 0;
        char done = ' ';

        for (char c : h.keySet()) {
            if (h.get(c) > max) {
                max = h.get(c);
                done = c;
            }
        }

        return done;
    }


    public static String replacePart (String o, String tr, String rw) {
        String n = o.replace(tr, rw);

        return n;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter a String:");
        String s = sn.nextLine();
        System.out.println("Enter string to replace:");
        String tr = sn.nextLine();
        System.out.println("Enter string to replace with:");
        String rw = sn.nextLine();

        System.out.printf("The number of words in '%s'': %d\n", s, tools.wordCounter(s));
        System.out.printf("The characater that appears " +
                "the most in '%s'': %s\n", s, tools.mostFound(s));
        System.out.printf("New string after replacement: %s\n", tools.replacePart(s, tr, rw));

        System.out.println("Enter a series of characters, " +
                "each character on a line. When done, enter .");
        ArrayList<Character> al = new ArrayList<>();
        char c = sn.nextLine().charAt(0);

        while (c != '.') {
            al.add(c);
            c = sn.nextLine().charAt(0);
        }

        String l = tools.convertToString(al);

        System.out.println(l);
        System.out.println(l.toUpperCase());
    }
}