package com.sample.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO: Describe purpose and behavior of MergeKSortedIterators
 */
public class MergeKSortedIterators {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);

        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(a.iterator());
        iterators.add(b.iterator());

        Iterable<Integer> result = mergeKSortedIterators(iterators);

        for (Integer num : result) {
            System.out.println(num);
        }
    }

    private static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
        if (iterators == null || iterators.isEmpty())
            return null;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<MyIterator> pq = new PriorityQueue<MergeKSortedIterators.MyIterator>(iterators.size());
        for (Iterator<Integer> i : iterators) {
            if (i.hasNext()) {
                pq.add(new MyIterator(i, i.next()));
            }
        }
        while (!pq.isEmpty()) {
            MyIterator myIterator = pq.poll();
            if (myIterator.hasNext()) {
                result.add(myIterator.value);
            }
            pq.offer(myIterator);
        }

        return result;
    }

    static class MyIterator implements Comparable<MyIterator> {

        Iterator<Integer> iterator;
        Integer value;

        public MyIterator(Iterator<Integer> i, Integer v) {
            this.iterator = i;
            this.value = v;
        }

        public boolean hasNext() {
            if (this.iterator.hasNext()) {
                this.value = this.iterator.next();
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(MyIterator o) {
            return this.value.compareTo(o.value);
        }
    }
}
