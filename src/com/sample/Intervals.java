package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO: Describe purpose and behavior of Intervals
 */
public class Intervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        intervals.add(i1);
        intervals.add(i4);
        intervals.add(i3);
        intervals.add(i2);
        List<Interval> result = mergeIntervals(intervals);
        System.out.println(result.toString());

        Interval m1 = new Interval(9, 10);
        Interval m2 = new Interval(4, 9);
        Interval m3 = new Interval(4, 17);
        Interval[] meetings = { m1, m2, m3 };
        System.out.println(numberOfRooms(meetings));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty())
            return Collections.emptyList();

        int index = 0;
        List<Interval> result = new ArrayList<>();
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index++));
        }
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(index).start, newInterval.start), Math.max(
                    intervals.get(index).end, newInterval.end));
        }
        while (index < intervals.size()) {
            result.add(intervals.get(index++));
        }
        return result;
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty())
            return Collections.emptyList();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        }); //start times sorted
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval ii = intervals.get(i);
            if (end > ii.start && end > ii.end)
                continue;
            if (end >= ii.start && end <= ii.end) {
                end = ii.end;
            } else {
                Interval merged = new Interval(start, end);
                result.add(merged);
                start = ii.start;
                end = ii.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    private static int numberOfRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        List<Interval> meetings = Arrays.asList(intervals);
        Collections.sort(meetings, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        }); //start times sorted

        PriorityQueue<Interval> pq = new PriorityQueue<Intervals.Interval>(intervals.length,
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.end - o2.end;
                    }
                });

        pq.offer(meetings.get(0));
        for (int cnt = 1; cnt < meetings.size(); cnt++) {
            Interval i = pq.poll();
            if (meetings.get(cnt).start >= i.end) {
                i.end = meetings.get(cnt).end;
            } else {
                pq.offer(meetings.get(cnt));
            }
            pq.offer(i);
        }
        return pq.size();
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

        List<Interval> meetings = Arrays.asList(intervals);
        Collections.sort(meetings, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(meetings.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        pq.offer(meetings.get(0));
        for (int cnt = 1; cnt < meetings.size(); cnt++) {
            Interval i = pq.poll();
            if (meetings.get(cnt).start >= i.end) {
                i.end = meetings.get(cnt).end;
            } else {
                pq.offer(meetings.get(cnt));
            }
            pq.offer(i);
        }
        return pq.size() == 1;
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return new Integer(this.start).compareTo(o.start);
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}
