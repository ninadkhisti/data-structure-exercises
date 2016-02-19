package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of ZigZagTwodIterator
 */
public class ZigZagTwodIterator implements Iterator<Integer> {

    private int row;
    private int column;
    private List<List<Integer>> input;
    private int rowSize;

    public ZigZagTwodIterator(List<List<Integer>> input) {
        this.input = input;
        row = 0;
        column = 0;
        rowSize = input.size();
    }

    @Override
    public boolean hasNext() {
        if (input == null || input.isEmpty()) {
            return false;
        }
        while (row < rowSize && (this.input.get(row) == null || this.input.get(row).isEmpty())) {
            row++;
        }
        return row < rowSize;
    }

    @Override
    public Integer next() {
        int num = this.input.get(row).get(column);
        row++;
        if (row == rowSize) {
            row = 0;
            column++;
        }
        while (row <= rowSize - 1
                && (this.input.get(row).size() - 1 < column || this.input.get(row) == null || this.input.get(row)
                        .isEmpty())) {
            row++;
        }

        return num;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] { 1, 2, 3 };
        List<Integer> list1 = Arrays.asList(arr1);

        Integer[] arr2 = new Integer[] { 5, 4 };
        List<Integer> list2 = Arrays.asList(arr2);

        Integer[] arr3 = new Integer[] { 6, 7, 8, 9 };
        List<Integer> list3 = Arrays.asList(arr3);

        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(new ArrayList<Integer>());
        input.add(list3);
        // List<Iterator<Integer>> iterators = new ArrayList<>();
        // iterators.add(list1.iterator());
        // iterators.add(list2.iterator());
        // iterators.add(list3.iterator());

        ZigZagTwodIterator zigZagIterator = new ZigZagTwodIterator(input);

        System.out.println(input.toString());
        while (zigZagIterator.hasNext()) {
            System.out.println(zigZagIterator.next());
        }
    }
}
