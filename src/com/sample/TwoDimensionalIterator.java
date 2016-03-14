package com.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TwoDimensionalIterator
 */
public class TwoDimensionalIterator implements Iterator<Integer> {

    private int col;
    private int row;
    private int rowsize;
    private List<List<Integer>> data;

    public TwoDimensionalIterator(List<List<Integer>> vec) {
        col = 0;
        row = 0;
        rowsize = vec.size();
        data = vec;
    }

    @Override
    public boolean hasNext() {
        if (data == null || data.size() == 0)
            return false;

        while (row < rowsize && (data.get(row) == null || data.get(row).size() == 0)) {
            row++;
        }
        return row < rowsize;
    }

    @Override
    public Integer next() {
        int result = data.get(row).get(col);
        col++;
        if (col == data.get(row).size()) {
            col = 0;
            row++;
        }
        return result;
    }

    @Override
    public void remove() {
        int rowDeleted;
        int coldeleted;
        List<Integer> candidateList = null;

        if (col == 0) {
            rowDeleted = row - 1;
            candidateList = data.get(rowDeleted);
            coldeleted = candidateList.size() - 1;
            candidateList.remove(coldeleted);
        } else {
            rowDeleted = row;
            coldeleted = col - 1;
            candidateList = data.get(rowDeleted);
            candidateList.remove(coldeleted);
        }
        if (candidateList.isEmpty()) {
            data.remove(candidateList);
            row++;
        }
        if (col != 0) {
            col--;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);

        array.add(row1);

        List<Integer> row3 = new ArrayList<>();
        array.add(row3);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        array.add(row2);

        TwoDimensionalIterator sol = new TwoDimensionalIterator(array);
        while (sol.hasNext()) {
            int result = sol.next();
            System.out.println(result);

            if (result == 3) {
                sol.remove();
            }
        }

        System.out.println();

        for (List<Integer> row : array) {
            System.out.println(row.toString());
        }
    }

}
