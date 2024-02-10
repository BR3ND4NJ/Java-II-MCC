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


class InvalidGrade extends Exception {
    public InvalidGrade(String line, String name, float grade) {
        super(String.format("Encountered an error parsing: \"%s\n" +
                "Record for student %s - has an invalid grade: %.1f", line, name, grade));
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        /* Create input file for the program */
        PrintWriter pw = new PrintWriter("students.txt");
        pw.print("Minnie Mouse -7\nBob Builder 65.8\nMickey Mouse 110\nDonald Duck 90.8\n");
        pw.close();
        PrintWriter pw2 = new PrintWriter("students2.txt");
        pw2.print("Donald Duck 177.77\nTweety Bird -10\nCharlie Brown 101\nMickey Mouse 90.8\n");
        pw2.close();
        /* End of creating the input file */

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
            String name = null;

            try {
                name = cut[0] + " " + cut[1];

                grade = Float.parseFloat(cut[2]);

                if (grade < 0 || grade > 100) {
                    throw new InvalidGrade(line, name, grade);
                } else {
                    a.add(new Student(name, grade));
                }
            } catch (InputMismatchException ime) {
                System.out.println('"' + line + '"' + " contains an invalid grade. For input string: " +
                        cut[2]);
            } catch (ArrayIndexOutOfBoundsException aio) {
                System.out.println('"' + line + '"' + " does not contain all 3 needed pieces.");
            } catch (NumberFormatException nfe) {
                System.out.println('"' + line + '"' + " contains an invalid grade. For input string: \"" + cut[2] + '"');
            } catch (InvalidGrade ig) {
                System.out.println(String.format("Encountered an error parsing: \"" + line +"\n" +
                       // "Record for student %s - has an invalid grade: %.1f", line, name, grade));
                        "Record for student "+ name + " - has an invalid grade: " + grade));

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