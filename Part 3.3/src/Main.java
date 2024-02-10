import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;


class Rectangle implements Comparable<Rectangle>{
    private float length;
    private float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }
    public Rectangle() {
        this(0, 0);
    }

    public void setLength(float length) {
        this.length = length;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public float getLength() {
        return length;
    }
    public float getWidth() {
        return width;
    }

    public float calcArea() {
        return length * width;
    }
    public float calcPerimeter() {
        return (length * 2) + (width * 2);
    }
    public String toString() {
        String s = String.format("Rectangle length = %.1f, width = %.1f", length, width);
        return s;
    }

    @Override
    public int compareTo(Rectangle o) {
        return Float.compare(this.calcArea(), o.calcArea());
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("How many rectangles would you like to create?");
        int num = sn.nextInt();
        Rectangle[] arr = new Rectangle[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Rectangle();
            System.out.printf("Enter Rectangle %d's length:\n", i + 1);
            arr[i].setLength(sn.nextInt());
            System.out.printf("Enter Rectangle %d's width:\n", i + 1);
            arr[i].setWidth(sn.nextInt());
        }

        System.out.println("Sorting based on area:");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Sorting based on perimeter (largest to smallest):");
        Arrays.sort(arr, Comparator.comparing(r -> -1 * r.calcPerimeter()));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Sorting based on perimeter (smallest to largest):");
        Arrays.sort(arr, Comparator.comparing(r -> r.calcPerimeter()));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}