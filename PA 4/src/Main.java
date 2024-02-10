import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class InvalidStringException extends Exception{
    public InvalidStringException(String line, int length) {
        super(String.format("\'%s\' has an error\n%s exceeds max length of %d allowed.\n", line, line, length));
    }
    public InvalidStringException(String line) {
        super(String.format("\'%s\' has an error\n%s contains digits which is invalid.\n", line, line));
    }
}


class ValidStrings {
    ArrayList<String> al;
    int length;

    public ValidStrings(int length) {
        al = new ArrayList<>();
        this.length = length;
    }

    public ArrayList<String> getAL() {
        return al;
    }

    public void addString(String s) throws InvalidStringException{
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                throw new InvalidStringException(s);
            }
        }
        if (s.length() <= length) {
            al.add(s);
        } else {
            throw new InvalidStringException(s, length);
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException{
        /* Create input file for the program */
        PrintWriter pw = new PrintWriter("file1.txt");
        pw.print("Headphones CPU Monitor Camera Speakers Keyboard Michigan Illinois Hawaii T99ext");
        pw.close();
        PrintWriter pw2 = new PrintWriter("file2.txt");
        pw2.print("Duck bird bug apples hospital emergency ambulance cake\n");
        pw2.close();
        /* End of creating the input file */

        Scanner sn = new Scanner(System.in);

        System.out.println("Enter input file name:");
        String file = sn.nextLine();
        File iFile = new File(file);
        Scanner read = new Scanner(iFile);

        System.out.println("Enter max length allowed for strings:");
        int length = sn.nextInt();
        ValidStrings v = new ValidStrings(length);

        while (read.hasNext()) {
            String s = read.next();
            try {
                v.addString(s);
            }
            catch (InvalidStringException ise){
                System.out.println(ise.getMessage());
            }
        }

        for (String st : v.getAL()) {
            System.out.print(st + " ");
        }
    }
}