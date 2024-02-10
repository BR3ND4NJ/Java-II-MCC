public class Maker {
    private String make;
    private int year;


    public Maker() {}


    public Maker(String make, int year) {
        this.make = make;
        this.year = year;
    }


    public void setMake(String m) { make = m;}
    public void setYear(int y) { year = y; }
    public String getMake() { return make; }
    public int getYear() { return year; }
}
