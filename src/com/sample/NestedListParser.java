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
        List<NestedList> list;

        public NestedList() {
            this.list = new ArrayList<>();
        }

        public void addList(NestedList alist) {
            this.list.add(alist);
        }

        public void setValue(int i) {
            this.value = i;
            number = true;
        }

        public NestedList parse(String raw) {
            if (raw == null || raw.length() == 0)
                return null;

            if (raw.charAt(0) != '[') {
                NestedList list = new NestedList();
                Integer num = Integer.parseInt(raw);
                list.setValue(num);
                return list;
            }

            Stack<NestedList> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            NestedList result = null;
            for (int cnt = 0; cnt < raw.length(); cnt++) {
                char ch = raw.charAt(cnt);
                if (ch == '[') {
                    NestedList nlist = new NestedList();
                    if (!stack.isEmpty()) {
                        stack.peek().addList(nlist);
                    }
                    stack.push(nlist);
                } else if (ch == ',' || ch == ']') {
                    if (ch == ',') {
                        if (sb.length() > 0) {
                            NestedList list = new NestedList();
                            Integer num = Integer.parseInt(sb.toString());
                            list.setValue(num);
                            sb.setLength(0);
                            stack.peek().addList(list);
                        }
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
            if (this.number)
                return this.value + "";
            else
                return this.list.toString();

        }
    }
}
