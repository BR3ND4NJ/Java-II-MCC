import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Please enter the prices of items bought for lunch " +
                "with $ signs and separated by commas and spaces:");

        String s = sn.nextLine();

        String[] price = s.split(", ");
        String num = "";
        float sum = 0;

        for (String p : price) {
            num = p.substring(1);
            sum += Float.parseFloat(num);
        }

        System.out.printf("Total Price: $%,.2f\n", sum);
    }
}