import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Float> nums = new ArrayList<>();

        System.out.println("Enter a series of numbers. When done, enter -1:");

        float num = 0;
        num = sn.nextFloat();

        while (num != -1) {
            nums.add(num);
            num = sn.nextFloat();
        }

        Collections.sort(nums);

        for (float i : nums) {
            System.out.printf("%.1f\n", i);
        }

        sn.nextLine();

        int upper = 0;
        int digits = 0;
        int whitespace = 0;
        ArrayList<Integer> e = new ArrayList<>();

        System.out.println("Enter a line of text:");
        String line = sn.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isUpperCase(c)) {
                upper++;
            }
            if (Character.isDigit(c)){
                digits++;
            }
            if (Character.isWhitespace(c)) {
                whitespace++;
            }
            if (c == 'e') {
                e.add(i);
            }
        }

        System.out.printf("Uppercase characters: %d\n", upper);
        System.out.printf("Digits: %d\n", digits);
        System.out.printf("Whitespace characters: %d\n", whitespace);
        if (e.isEmpty()) {
            System.out.println("String has no e's");
        }
        else {
            System.out.printf("Location of e's: %s\n", e.toString());
        }
    }
}