import java.util.ArrayList;

class Month {
    enum MonthName {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC}
    private MonthName monthName;
    private static int instanceCount = 0;

    public Month(int month) {
        monthName = MonthName.values()[month];
        instanceCount++;
    }
    public Month(String month) {
        monthName = MonthName.valueOf(month);
        instanceCount++;
    }
    public Month() {
        this("JAN");
    }
    public Month(Month o) {
        this(o.getMonthName());
    }

    public void setMonthName(int month) {
        this.monthName = MonthName.values()[month];
    }
    public void setMonthName(String month) {
        this.monthName = MonthName.valueOf(month);
    }
    public String getMonthName() {
        return monthName.name();
    }
    public int getInstanceCount() {
        return instanceCount;
    }

    public String toString() {
        return "Month: " + monthName.name();
    }

    public boolean equals(Month o) {
        if (this.getMonthName() != o.getMonthName()) {
            return false;
        }
        return true;
    }
}


abstract class Student {
    private String name;
    private int id;
    private int year;

    public Student(String name, int id, int year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }
    public Student() {
        this(null, 0, 0);
    }
    public Student(Student o) {
        this(o.getStudentName(), o.getId(), o.getYear());
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public final String getStudentName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getYear() {
        return year;
    }

    public String toString() {
        String s = String.format("Name: %s, ID: %d, Year: %d", getStudentName(), getId(), getYear());
        return s;
    }

    public abstract int getRemainingHours();
}


class CompSciStudent extends Student{
    private final int MATH_HOURS = 20;
    private final int CS_HOURS = 40;
    private final int GEN_ED_HOURS = 60;

    private int mtaken;
    private int ctaken;
    private int gtaken;
    private int training;

    public void setMtaken(int mtaken) {
        this.mtaken = mtaken;
    }
    public void setCtaken(int ctaken) {
        this.ctaken = ctaken;
    }
    public void setGtaken(int gtaken) {
        this.gtaken = gtaken;
    }
    public void setTraining(int training) {
        this.training = training;
    }
    public int getMtaken() {
        return mtaken;
    }
    public int getCtaken() {
        return ctaken;
    }
    public int getGtaken() {
        return gtaken;
    }
    public int getTrainingHoursCompleted() {
        return training;
    }

    public int getRemainingHours() {
        return ((MATH_HOURS - getMtaken()) + (CS_HOURS - getCtaken()) +
                (GEN_ED_HOURS - getGtaken()));
    }

    public String toString() {
        String s = super.toString() + String.format(", Hours Remaining: %d, " +
                        "Training Hours Completed: %d", getRemainingHours(),
                getTrainingHoursCompleted());
        return s;
    }
}


class EnglishStudent extends Student{
    private final int MATH_HOURS = 10;
    private final int ENGLISH_HOURS = 50;
    private final int GEN_ED_HOURS = 60;

    private int mtaken;
    private int etaken;
    private int gtaken;

    public void setMtaken(int mtaken) {
        this.mtaken = mtaken;
    }
    public void setCtaken(int etaken) {
        this.etaken = etaken;
    }
    public void setGtaken(int gtaken) {
        this.gtaken = gtaken;
    }
    public int getMtaken() {
        return mtaken;
    }
    public int getEtaken() {
        return etaken;
    }
    public int getGtaken() {
        return gtaken;
    }

    public int getRemainingHours() {
        return ((MATH_HOURS - getMtaken()) + (ENGLISH_HOURS - getEtaken()) +
                (GEN_ED_HOURS - getGtaken()));
    }

    public String toString() {
        String s = super.toString() + String.format(", Hours Remaining: %d",
                getRemainingHours());
        return s;
    }
}


class MCCStudents {
    private ArrayList<Student> students = new ArrayList<>();
    private CompSciStudent ctutor;
    private EnglishStudent etutor;

    public void createStudents() {
        students.add(new CompSciStudent());
        students.add(new CompSciStudent());
        students.add(new EnglishStudent());
        students.add(new EnglishStudent());
        ctutor = new CompSciStudent();
        etutor = new EnglishStudent();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Student st : students) {
            if (st instanceof CompSciStudent) {
                s.append(((CompSciStudent)st).getTrainingHoursCompleted() + " Training Hours Completed\n");
            }
        }
        if (ctutor.getStudentName() != null) {
            s.append(String.format("CompSciTutor: %s\n", ctutor.getStudentName()));
        }
        if (etutor.getStudentName() != null) {
            s.append(String.format("EnglishTutor: %s\n", etutor.getStudentName()));
        }
        return s.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        ArrayList<Month> al = new ArrayList<>(4);

        Month m1 = new Month();
        al.add(m1);
        Month m2 = new Month(5);
        al.add(m2);
        Month m3 = new Month("AUG");
        al.add(m3);
        Month m4 = new Month(m3);
        al.add(m4);

        System.out.println(m3.equals(m4));

        System.out.println(m4.getInstanceCount());

        for (Month m : al) {
            System.out.println(m.toString());
        }

        MCCStudents m = new MCCStudents();
        m.createStudents();
        System.out.println(m.toString());
    }
}