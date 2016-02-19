package com.sample;

import java.util.Arrays;

/**
 * TODO: Describe purpose and behavior of RobotMovement
 */
public class RobotMovement {

    public static void main(String[] args) {
        System.out.println(doesCircleExist("L"));
        System.out.println(doesCircleExist("LR"));
        System.out.println(doesCircleExist("GGGGRGGGGG"));
        System.out.println(doesCircleExist("GGGRGGGRGGGRGGG"));
        System.out.println(doesCircleExist("GGGGGGGGGGGGLGGGGGGGGGGGGLGGGGGGGGGGGGLGGGGGGGGGGGG"));
        System.out.println(doesCircleExist("GRG"));
    }

    static String doesCircleExist(String commands) {
        if (commands == null || commands.length() == 0)
            return "NO";

        int direction = 0;
        int[] origin = new int[2];
        for (int j = 0; j < 4; j++) {
            for (int cnt = 0; cnt < commands.length(); cnt++) {
                char command = commands.charAt(cnt);

                if (command == 'R') {
                    direction = goRight(direction);
                }
                if (command == 'L') {
                    direction = goLeft(direction);
                }
                if (command == 'G') {
                    origin = moveForward(origin, direction);
                }
            }
        }
        System.out.println(Arrays.toString(origin));
        if (origin[0] == 0 && origin[1] == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static int[] moveForward(int[] origin, int direction) {
        switch (direction) {
        case 0: //north
            origin[1]++;
            break;
        case 1: //east
            origin[0]++;
            break;
        case 2: //south
            origin[1]--;
            break;
        case 3: //west
            origin[0]--;
            break;
        }
        return origin;
    }

    private static int goLeft(int direction) {
        direction -= 1;
        if (direction == -1)
            return 3;
        else
            return direction;
    }

    private static int goRight(int direction) {
        return ++direction % 4;
    }

    /*
    private static int isPresent(Node root, int val){
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        Node p = root;
        queue.add(p);
        
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.data == val) return 1;
            
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return 0;
        
    /* For your reference
    class Node {
            Node left, right;
            int data;
                    Node(int newData) {
                left = right = null;
                data = newData;
            }
        }
    */
    //}
    /*
     *  static int[] StringSimilarity(String[] inputs) {
        if (inputs == null || inputs.length == 0) return null;
        
        int[] result = new int[inputs.length];
        
        int index =0;
        for (String input : inputs) {
            int similarity = input.length();
            for (int cnt =1; cnt < input.length(); cnt++) {
                similarity += getSimilarity(input.substring(cnt), input);
            }
            result[index++] = similarity;
        }
        return result;
    }
    
    static int getSimilarity(String prefix, String input) {
        int result = 0;
        forloop: for (int cnt =0; cnt < prefix.length(); cnt++) {
            if (prefix.charAt(cnt) == input.charAt(cnt)) result++;
            else break forloop;
        }
        return result;
    }
    
     */
}
