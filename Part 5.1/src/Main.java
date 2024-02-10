import java.util.Scanner;

public class Main {
    public static int product(int x, int y) {
        if (x > 1) {
            return y + product(x - 1, y);
        }
        return y;
    }


    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int x = sn.nextInt();
        int y = sn.nextInt();
        System.out.println(product(x, y));
    }
}