package com.sample.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO: Describe purpose and behavior of BlackPixelArea
 */
public class BlackPixelArea {

    public static void main(String[] args) {
        char[][] image = { { '0', '0', '1', '0' }, { '0', '1', '1', '0' }, { '0', '1', '0', '0' } };
        //int area = pixelarea(image, 0, 2);
        //System.out.println(area);

        int[] result = { Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE };
        pixelareaDFS(image, 0, 2, result);
        System.out.println((result[1] - result[0] + 1) * (result[3] - result[2] + 1));
    }

    private static void pixelareaDFS(char[][] image, int i, int j, int[] result) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if (image[i][j] == '0') {
            return;
        }
        image[i][j] = '0';
        result[0] = Math.min(result[0], i);
        result[1] = Math.max(result[1], i);
        result[2] = Math.min(result[2], j);
        result[3] = Math.max(result[3], j);

        pixelareaDFS(image, i, j - 1, result);
        pixelareaDFS(image, i - 1, j, result);
        pixelareaDFS(image, i, j + 1, result);
        pixelareaDFS(image, i + 1, j, result);
    }

    private static int pixelarea(char[][] image, int x, int y) {
        if (image == null || image.length == 0)
            return 0;
        int r = image.length - 1;
        int c = image[0].length - 1;

        Queue<int[]> bfs = new LinkedList<>();
        int[] point = { x, y };
        bfs.add(point);
        int minr = Integer.MAX_VALUE, minc = Integer.MAX_VALUE, maxr = Integer.MIN_VALUE, maxc = Integer.MIN_VALUE;

        while (!bfs.isEmpty()) {
            int[] curr = bfs.remove();
            int i = curr[0], j = curr[1];
            image[i][j] = (char) -1; //visited

            minr = Math.min(minr, i);
            maxr = Math.max(maxr, i);
            minc = Math.min(minc, j);
            maxc = Math.max(maxc, j);

            if (j > 0 && image[i][j - 1] == '1') {
                bfs.add(new int[] { i, j - 1 });
            }
            if (i > 0 && image[i - 1][j] == '1') {
                bfs.add(new int[] { i - 1, j });
            }
            if (j < c && image[i][j + 1] == '1') {
                bfs.add(new int[] { i, j + 1 });
            }
            if (i < r && image[i + 1][j] == '1') {
                bfs.add(new int[] { i + 1, j });
            }
        }

        return (maxr - minr + 1) * (maxc - minc + 1);
    }
}
