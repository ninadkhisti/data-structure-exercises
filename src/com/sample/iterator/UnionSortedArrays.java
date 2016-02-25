package com.sample.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of UnionSortedArrays
 */
public class UnionSortedArrays {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);

        Iterable<Integer> result1 = union(a.iterator(), b.iterator());
        Iterable<Integer> result = intersection(a.iterator(), b.iterator());

        for (Integer num : result) {
            System.out.println(num);
        }

        for (Integer num : result1) {
            System.out.println(num);
        }

    }

    private static Iterable<Integer> intersection(Iterator<Integer> i1, Iterator<Integer> i2) {
        if (i1 == null && i2 == null)
            return null;
        List<Integer> result = new ArrayList<>();

        Integer i = i1.hasNext() ? i1.next() : null;
        Integer j = i2.hasNext() ? i2.next() : null;
        while (i != null && j != null) {
            if (i == j) {
                result.add(i);
                i = i1.hasNext() ? i1.next() : null;
                j = i2.hasNext() ? i2.next() : null;
            } else if (i < j) {
                i = i1.hasNext() ? i1.next() : null;
            } else if (i > j) {
                j = i2.hasNext() ? i2.next() : null;
            }
        }

        return result;
    }

    private static Iterable<Integer> union(Iterator<Integer> i1, Iterator<Integer> i2) {
        if (i1 == null && i2 == null)
            return null;
        List<Integer> result = new ArrayList<>();

        Integer i = i1.hasNext() ? i1.next() : null;
        Integer j = i2.hasNext() ? i2.next() : null;

        while (i != null && j != null) {
            if (i == j) {
                result.add(i);
                i = i1.hasNext() ? i1.next() : null;
                j = i2.hasNext() ? i2.next() : null;
            } else if (i < j) {
                result.add(i);
                i = i1.hasNext() ? i1.next() : null;
            } else if (i > j) {
                result.add(j);
                j = i2.hasNext() ? i2.next() : null;
            }
        }
        while (i1.hasNext()) {
            result.add(i1.next());
        }
        while (i2.hasNext()) {
            result.add(i2.next());
        }

        return result;
    }
}
