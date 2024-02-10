import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int smallestNumber(ArrayList<Integer> arr) {
        return smallestNumber(arr, 0);
    }


    public static int smallestNumber(ArrayList<Integer> arr, int index) {
        if (index == arr.size()-1) {
            return arr.get(index);
        }

        int smallNum = Math.min(arr.get(index), smallestNumber(arr, index + 1));

        return smallNum;
    }


    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Enter a series of integers, each on a different line. " +
                "When done, enter a period.");

        ArrayList<Integer> arr = new ArrayList<>();
        String num = sn.next();

        while (num.charAt(0) != '.') {
            arr.add(Integer.parseInt(num));
            num = sn.next();
        }

        System.out.println(smallestNumber(arr));
    }
}