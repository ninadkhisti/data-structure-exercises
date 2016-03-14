package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO: Describe purpose and behavior of NestedListParser
 */
public class NestedListParser {

    public static void main(String[] args) {
        NestedListParser.NestedList nestedList = new NestedListParser.NestedList();
        NestedList result = nestedList.parse("[123,456,[788,799,833],[[]],10,[]]");
        System.out.println(result.toString());
    }

    static class NestedList {
        int value;
        boolean number;
        List<NestedList> nestedList;

        public NestedList() {
            this.nestedList = new ArrayList<>();
        }

        public void addToList(NestedList listItem) {
            this.nestedList.add(listItem);
        }

        public void setValue(int value) {
            this.value = value;
            this.number = true;
        }

        public NestedList parse(String input) {
            if (input == null || input.isEmpty())
                return null;

            if (input.charAt(0) != '[') {
                Integer avalue = Integer.parseInt(input);
                NestedList nestedList = new NestedList();
                nestedList.setValue(avalue);
                return nestedList;
            }
            Stack<NestedList> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            NestedList result = null;
            for (int cnt = 0; cnt < input.length(); cnt++) {
                char ch = input.charAt(cnt);
                if (ch == '[') {
                    NestedList alist = new NestedList();
                    if (!stack.isEmpty()) {
                        stack.peek().addToList(alist);
                    }
                    stack.push(alist);
                } else if (ch == ']' || ch == ',') {
                    if (sb.length() > 0) {
                        Integer val = Integer.parseInt(sb.toString());
                        NestedList item = new NestedList();
                        item.setValue(val);
                        stack.peek().addToList(item);
                        sb.setLength(0);
                    }

                    if (ch == ']') {
                        result = stack.pop();
                    }
                } else {
                    sb.append(ch);
                }
            }

            return result;
        }

        public String toString() {
            if (this.number) {
                return this.value + "";
            } else {
                return this.nestedList.toString();
            }
        }
    }

}
