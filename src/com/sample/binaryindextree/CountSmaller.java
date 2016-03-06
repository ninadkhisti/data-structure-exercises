package com.sample.binaryindextree;

import java.util.Arrays;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of CountSmaller
 */
public class CountSmaller {

    static int MAX = 11000; //we set max value that can be store in the tree
    int[] tree = new int[MAX];

    public static void main(String[] args) {
        int[] input = { 5, 2, 6, 1, 7, 8, 3, 5, 0, 9, 5, 8, 0, 3, 2, 4, 8, 0, 5, 9, 2, 3, 7, 4, 0, 5 };
        CountSmaller cs = new CountSmaller();
        List<Integer> result = cs.countSmaller(input);
        System.out.println(result.toString());
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        System.out.println(Arrays.toString(nums));
        //make all elements in the array posive while maintaining their order
        makePositive(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = get(nums[i]);
            add(nums[i] + 1, 1);
        }
        System.out.println(Arrays.toString(tree));
        return Arrays.asList(result);
    }

    public void makePositive(int[] nums) {
        int min = MAX;
        for (int i = 0; i < nums.length; i++)
            min = Math.min(min, nums[i]);
        if (min < 0) {
            min = -min + 1;
            for (int i = 0; i < nums.length; i++)
                nums[i] += min;
        }
    }

    public void add(int idx, int val) {
        while (idx < MAX) {
            tree[idx] += val;
            idx += idx & ~(idx - 1);
        }
    }

    public int get(int idx) {
        int result = 0;
        while (idx > 0) {
            result += tree[idx];
            idx -= idx & ~(idx - 1);
        }
        return result;
    }
}
