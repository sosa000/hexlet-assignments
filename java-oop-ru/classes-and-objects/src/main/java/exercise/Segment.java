package exercise;

// BEGIN
public class Segment {
    private Point firstPoint;
    private Point secondPoint;

    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getBeginPoint() {
        return this.firstPoint;
    }

    public Point getEndPoint() {
        return this.secondPoint;
    }

    public Point getMidPoint() {
        int x = (this.firstPoint.getX() + this.secondPoint.getX()) / 2;
        int y = (this.firstPoint.getY() + this.secondPoint.getY()) / 2;
        return new Point(x, y);
    }
}
// END
