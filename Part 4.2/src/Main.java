import java.io.*;
import java.util.*;


class Student {
    private String name;
    private float grade;

    public Student(String name, float grade) {
        this.name = name;
        this.grade = grade;
    }
    public Student() {
        this(null, 0);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public float getGrade() {
        return grade;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        /* Create input file for the program */
        PrintWriter pw = new PrintWriter("students.txt");
        pw.print("Minnie Mouse 98.7\nBob Builder 65.8\nCinderella 89.9\nMickey Mouse twenty\nPopeye 78.6\nDonald Duck 90.8\n");
        pw.close();
        PrintWriter pw2 = new PrintWriter("students2.txt");
        pw2.print("Donald 77.77\nTweety Bird brown\nCharlie Brown 95.231\n");
        pw2.close();
        /* End of creating the input file */
        // Do not modify the code above or below. Your code should come here between them.

        Scanner sn = new Scanner(System.in);

        ArrayList<Student> a = new ArrayList<>();

        System.out.println("Enter input file name:");
        String iFile = sn.nextLine();
        File file = new File(iFile);
        Scanner read = new Scanner(file);

        System.out.println("Enter output file name:");
        String oFile = sn.nextLine();
        pw = new PrintWriter(oFile);

        float grade = 0;


        while(read.hasNext()) {
            String line = read.nextLine();
            String[] cut = line.split(" ");

            try {
                String name = cut[0] + " " + cut[1];

                grade = Float.parseFloat(cut[2]);

                a.add(new Student(name, grade));
            }
            catch (InputMismatchException ime) {
                System.out.println('"' + line + '"' + " contains an invalid grade. For input string: " +
                        cut[2]);
            }
            catch (ArrayIndexOutOfBoundsException aio) {
                System.out.println('"' + line + '"' + " does not contain all 3 needed pieces.");
            }
            catch (NumberFormatException nfe) {
                System.out.println('"' + line + '"' + " contains an invalid grade. For input string: \"" + cut[2] + '"');
            }
        }


        float average = 0;

        for (int i = 0; i < a.size(); i++) {
            pw.print(a.get(i).getName());
            if (i < a.size() - 1) {
                pw.print(", ");
            }
            average += a.get(i).getGrade();
        }

        average = average/a.size();

        pw.println();
        pw.println();
        pw.printf("%-15s %10.1f", "Average", average);

        read.close();
        pw.close();

        /* test output file */
        Scanner testOutput = new Scanner(new File("average.txt"));
        while(testOutput.hasNext())
            System.out.println(testOutput.nextLine());
        /* end of test output file */
    }
}