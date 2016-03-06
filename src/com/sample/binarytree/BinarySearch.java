package com.sample.binarytree;

/**
 * TODO: Describe purpose and behavior of BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(pow(3, 3));
        System.out.println(pow(2, -3));
        System.out.println(sqrt(64));
    }

    private static double pow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 1)
            return x;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }

    private static int sqrt(int x) {
        int l = 1, r = x, mid = 0, ans = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
