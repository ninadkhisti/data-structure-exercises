package com.sample.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Describe purpose and behavior of GroupShiftedStrings
 */
public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] input = { "az", "yx" };
        List<List<String>> result = groupStrings(input);
        System.out.println(result.toString());

    }

    public static List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0)
            return Collections.emptyList();

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String string : strings) {
            if (string == null || string.isEmpty())
                continue;
            int offset = string.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < string.length(); i++) {
                int computedchar = string.charAt(i) - offset < 0 ? string.charAt(i) - offset + 26 : string.charAt(i)
                        - offset;
                key += (char) (computedchar);
            }
            if (groupMap.containsKey(key)) {
                groupMap.get(key).add(string);
            } else {
                List<String> groupList = new ArrayList<>();
                groupList.add(string);
                groupMap.put(key, groupList);
            }
        }
        for (String key : groupMap.keySet()) {
            List<String> group = groupMap.get(key);
            Collections.sort(group);
            result.add(group);
        }
        return result;
    }

}
