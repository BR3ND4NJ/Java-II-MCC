import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void sort(ArrayList<String> al) {
        for (int i = 0; i < al.size() - 1; i++)
        {
            int maxPos = maximumPosition(al, i);
            swap(al, maxPos, (al.size() - 1) - i);
        }
    }


    private static int minimumPosition(ArrayList<String> al, int from) {
        int minPos = from;
        for (int i = from + 1; i < al.size(); i++) {
            if (al.get(i).compareToIgnoreCase(al.get(minPos)) < 0) {
                minPos = i;
            }
        }
        return minPos;
    }


    private static int maximumPosition(ArrayList<String> al, int from) {
        int maxPos = (al.size() - 1) - from;
        for (int i = (al.size() - 2) - from; i >= 0; i--) {
            if (al.get(i).compareToIgnoreCase(al.get(maxPos)) < 0) {
                maxPos = i;
            }
        }
        return maxPos;
    }



    public static void swap(ArrayList<String> al, int i, int j) {
        String temp = al.get(i);
        al.set(i, al.get(j));
        al.set(j, temp);
    }


    public static int bSearch(ArrayList<String> al, int low, int high, String s)
    {
        int count = 0;
        if (low <= high)
        {
            int mid = (low + high) / 2;
            if (al.get(mid).equalsIgnoreCase(s)) {
                count++;
                count += bSearch(al, low, mid - 1, s);
                count += bSearch(al, mid + 1, high, s);
            }
            else if (al.get(mid).compareToIgnoreCase(s) > 0) {
                count += bSearch(al, mid + 1, high, s);
            }
            else
                count += bSearch(al, low, mid - 1, s);
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter a series of Strings on separate lines. When done, " +
                "type \"End\"");
        ArrayList<String> al = new ArrayList<>();
        String s = sn.nextLine();

        while(!s.equalsIgnoreCase("end")) {
            al.add(s);
            s = sn.nextLine();
        }

        sort(al);
        System.out.println(al);

        System.out.println("Enter a String to search for:");
        s = sn.nextLine();

        System.out.println(String.format("Found \'%s\' %d times.", s,
                bSearch(al, 0, al.size() - 1, s)));
    }
}