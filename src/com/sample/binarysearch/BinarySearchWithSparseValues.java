package com.sample.binarysearch;

/**
 * Modified Binary Search with sparse inputs.
 */
public class BinarySearchWithSparseValues {

    public static void main(String[] args) {
        String[] array = { "a", "", "", "", "", "bbb", "", "", "", "bbbc", "bc", "", "", "", "", "", "ccc", "", "",
                "d", "ddd" };
        String query = "bc";

        String result = binarySearchSpaseValues(array, query, 0, array.length);
        System.out.println(result);
    }

    private static String binarySearchSpaseValues(String[] array, String query, int low, int high) {

        if (low > high)
            return "-1";
        int mid = (low + high) / 2;

        if (array[mid].equals(query)) {
            return query;
        }
        if (array[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            outer: while (true) {
                if (left < low || right > high) {
                    return "-1";
                }

                if (!array[left].isEmpty()) {
                    mid = left;
                    break outer;
                }
                if (!array[right].isEmpty()) {
                    mid = right;
                    break outer;
                }
                left--;
                right++;
            }
        }

        if (array[mid].compareTo(query) < 0) {
            return binarySearchSpaseValues(array, query, mid + 1, high);
        } else {
            return binarySearchSpaseValues(array, query, low, mid - 1);
        }
    }

}
