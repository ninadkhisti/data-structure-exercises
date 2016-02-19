package com.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of TwoDimensionalIterator
 */
public class TwoDimensionalIterator implements Iterator<Integer> {

    private int row;
    private int col;
    private List<List<Integer>> input;
    private int rowSize;

    public TwoDimensionalIterator(List<List<Integer>> input) {
        this.input = input;
        row = 0;
        col = 0;
        rowSize = input.size();
    }

    @Override
    public boolean hasNext() {
        if (input == null || input.isEmpty())
            return false;
        while (row < rowSize && (this.input.get(row) == null || this.input.get(row).isEmpty())) {
            row++;
        }
        return row < rowSize;
    }

    @Override
    public Integer next() {
        int num = this.input.get(row).get(col);
        col++;
        if (row < rowSize && this.input.get(row).size() - 1 == col) { //last element
            row++;
            col = 0;
        }
        return num;
    }

    @Override
    public void remove() {
        int rowRemove = row;
        int colRemove = col;

        if (colRemove == 0) {
            rowRemove--;
            colRemove = this.input.get(rowRemove).size() - 1;
            this.input.get(rowRemove).remove(colRemove);
        } else {
            this.input.get(rowRemove).remove(colRemove);
        }

        if (this.input.get(rowRemove).isEmpty()) {
            this.input.remove(rowRemove);
            row--;
        }
        if (col != 0)
            col--;
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
