package com.sample.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of CountingSort
 */
public class CountingSort {

    class SortNode implements Comparable<SortNode> {
        int value = 0;
        int count = 0;
        int index = 0;

        void incrementCount() {
            count += 1;
        }

        @Override
        public int compareTo(SortNode o) {
            if (this.count < o.count) {
                return 1;
            } else if (this.count > o.count) {
                return -1;
            } else {
                return new Integer(o.index).compareTo(this.index);
            }
        }

        public String toString() {
            return this.value + " " + this.count;
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(array);
    }

    public void countingSort(int[] array) {
        Map<Integer, SortNode> map = new HashMap<>();
        for (int cnt = 0; cnt < array.length; cnt++) {
            if (map.containsKey(array[cnt])) {
                map.get(array[cnt]).incrementCount();
            } else {
                SortNode node = new SortNode();
                node.value = array[cnt];
                node.index = cnt;
                node.count = 1;
                map.put(array[cnt], node);
            }
        }
        List<SortNode> nodes = new ArrayList<>();
        for (Integer nodeValue : map.keySet()) {
            nodes.add(map.get(nodeValue));
        }
        Collections.sort(nodes);
        int index = 0;
        for (SortNode a : nodes) {
            for (int cnt = 0; cnt < a.count; cnt++) {
                array[index++] = a.value;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
