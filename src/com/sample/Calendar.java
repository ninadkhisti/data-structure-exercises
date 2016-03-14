package com.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of Calendar
 */
public class Calendar {

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();

        Interval a = new Interval(10, 20);
        Interval b = new Interval(30, 40);
        Interval c = new Interval(60, 70);
        Interval a1 = new Interval(11, 15);
        Interval b1 = new Interval(18, 40.9);
        Interval c1 = new Interval(64, 79.9);

        List<Interval> aList = new ArrayList<>();
        aList.add(a);
        aList.add(b);
        aList.add(c);
        List<Interval> a1List = new ArrayList<>();
        a1List.add(a1);
        a1List.add(b1);
        a1List.add(c1);
        input.add(aList);
        input.add(a1List);

        List<Interval> result = computeFreeIntervals(input);
        System.out.println(result.toString());
    }

    private static List<Interval> computeFreeIntervals(List<List<Interval>> input) {
        List<Interval> merged = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (i == 0)
                merged.addAll(input.get(0));
            else {
                for (Interval interval : input.get(i)) {
                    merged = mergeIntervals(merged, interval);
                }
            }
        }
        List<Interval> result = new ArrayList<>();
        double start = Double.MIN_VALUE;
        for (Interval mergeInterval : merged) {
            Interval i = new Interval(start, mergeInterval.start);
            result.add(i);
            start = mergeInterval.end;
        }
        Interval lastInterval = new Interval(start, Double.MAX_VALUE);
        result.add(lastInterval);
        return result;
    }

    public static List<Interval> mergeIntervals(List<Interval> nonOverlapInt, Interval another) {
        List<Interval> merge = new ArrayList<Interval>();
        for (Interval current : nonOverlapInt) {
            if (current.end <= another.start || another.end <= current.start) {
                merge.add(current);
            } else {
                another.start = (current.start < another.start) ? current.start : another.start;
                another.end = (current.end > another.end) ? current.end : another.end;
            }
        }
        merge.add(another);
        return merge;
    }

    static class Interval {
        double start;
        double end;

        public Interval(double start, double end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

}
