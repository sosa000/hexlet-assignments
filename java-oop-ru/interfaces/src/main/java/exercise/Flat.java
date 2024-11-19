package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    private double totalArea;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        this.totalArea = area + balconyArea;
    }

    @Override
    public double getArea() {
        return this.totalArea;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + this.totalArea + " метров на " + this.floor + " этаже";
    }
}
// END
