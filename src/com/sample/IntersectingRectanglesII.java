package com.sample;

import java.util.TreeSet;

/**
 * TODO: Describe purpose and behavior of IntersectingRectanglesII
 */
public class IntersectingRectanglesII {

    public static void main(String[] args) {
        Rectangle[] rects = {

        new Rectangle(1, 1, 3, 3), new Rectangle(2, 5, 4, 6), new Rectangle(2.5, 2, 3.5, 5.5),
                new Rectangle(8, 8, 10, 10), new Rectangle(8.5, 8.5, 11, 11) };
        System.out.println(getNumIntersecting(rects));
    }

    private static int getNumIntersecting(Rectangle[] rects) {
        if (rects == null || rects.length == 0)
            return 0;

        TreeSet<EndPoint> x = new TreeSet<>();
        for (Rectangle rectangle : rects) {
            x.add(rectangle.startx);
            x.add(rectangle.endx);
        }
        int intersections = 0;
        System.out.println(x.toString());
        TreeSet<EndPoint> y = new TreeSet<>();
        for (EndPoint pointx : x) {
            EndPoint starty = pointx.rectangle.starty;
            EndPoint endy = pointx.rectangle.endy;
            if (pointx.start) {
                intersections += y.subSet(starty, false, endy, false).size();
                y.add(starty);
                y.add(endy);
            } else {
                y.remove(starty);
                y.remove(endy);
            }
        }
        System.out.println(y.toString());
        return intersections > 0 ? intersections + 1 : 0;
    }

    public static class Rectangle {
        EndPoint startx;
        EndPoint endx;
        EndPoint starty;
        EndPoint endy;

        public Rectangle(double x, double y, double x1, double y1) {
            startx = new EndPoint(this, x, true);
            starty = new EndPoint(this, y, true);
            endx = new EndPoint(this, x1, false);
            endy = new EndPoint(this, y1, false);
        }
    }

    static class EndPoint implements Comparable<EndPoint> {
        Rectangle rectangle;
        double value;
        boolean start;

        public EndPoint(Rectangle rectangle, double value, boolean start) {
            this.rectangle = rectangle;
            this.value = value;
            this.start = start;
        }

        @Override
        public int compareTo(EndPoint o) {
            int result = 0;
            double diff = this.value - o.value;
            if (diff == 0) {
                result = this.start ? 1 : -1;
                if (this.rectangle != o.rectangle) {
                    result = -result;
                }
            } else {
                result = diff > 0 ? 1 : -1;
            }
            return result;
        }

        public String toString() {
            return "{" + this.value + "-" + this.start + "}";
        }
    }
}
