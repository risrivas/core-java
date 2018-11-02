package ctci.moderate;

public class Intersection {

    private static class Point {
        private double _x;
        private double _y;

        public Point(double x, double y) {
            _x = x;
            _y = y;
        }

        public void setLocation(double x, double y) {
            _x = x;
            _y = y;
        }

        public void display() {
            System.out.printf("x=%.2f, y=%.2f", _x, _y);
        }

    }

    private static class Line {
        private double slope;
        private double yintercept;

        public Line(Point start, Point end) {
            double deltaY = end._y - start._y;
            double deltaX = end._x - start._x;
            slope = deltaY / deltaX;
            yintercept = end._y - (slope * end._x);
        }

    }

    private static Point intersection(Point start1, Point end1, Point start2, Point end2) {
        if (start1._x > end1._x) swap(start1, end1);
        if (start2._x > end2._x) swap(start2, end2);
        if (start1._x > start2._x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
                return start2;
            }
            return null;
        }

        // formula
        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope); // x = (c2 - c1)/(m1 - m2)
        double y = x * line1.slope + line1.yintercept; // y = mx + c

        Point intersection = new Point(x, y);
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) return intersection;
        return null;
    }

    private static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start._x, middle._x, end._x) && isBetween(start._y, middle._y, end._y);
    }

    private static boolean isBetween(double start, double middle, double end) {
        if (start < end) return start <= middle && middle <= end;
        else return end <= middle && middle <= start;
    }

    private static void swap(Point one, Point two) {
        double onex = one._x;
        double oney = one._y;

        one.setLocation(two._x, two._y);
        two.setLocation(onex, oney);
    }

    public static void main(String[] args) {
        Point intersection = intersection(new Point(-3, -3), new Point(2, 7), new Point(-6, 10), new Point(4, 5));
        if (intersection != null)
            intersection.display();
    }

}
