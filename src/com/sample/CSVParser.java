package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO: Describe purpose and behavior of CSVParser
 */
public class CSVParser {

    public static void main(String[] args) {
        System.out.println(parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1"));
        System.out.println(parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
        System.out.println(parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
        System.out.println(parseCSV("\"\"\"Alexandra Alex\"\"\""));
    }

    private static String parseCSV(String raw) {
        StringBuilder sb = new StringBuilder();
        List<String> tokens = tokenize(raw);
        String delimiter = "|";
        if (tokens == null || tokens.isEmpty())
            return sb.toString();
        for (int cnt = 0; cnt < tokens.size(); cnt++) {
            sb.append(tokens.get(cnt));
            if (cnt != tokens.size() - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    private static List<String> tokenize(String raw) {
        if (raw == null || raw.isEmpty())
            return Collections.emptyList();

        StringBuffer sb = new StringBuffer();
        List<String> tokens = new ArrayList<>();
        boolean inQuote = false;
        for (int cnt = 0; cnt < raw.length(); cnt++) {
            char ch = raw.charAt(cnt);

            if (inQuote) {
                if (ch == '"') {
                    if (cnt + 1 < raw.length() && raw.charAt(cnt + 1) == '"') {
                        sb.append(ch);
                        cnt = cnt + 1;
                    } else {
                        inQuote = false;
                    }
                } else if (ch == ',') {
                    sb.append(ch);
                } else {
                    sb.append(ch);
                }

            } else {
                if (ch == '"') {
                    inQuote = true;
                } else if (ch == ',') {
                    String token = sb.toString();
                    tokens.add(token);
                    sb.delete(0, sb.length());
                } else {
                    sb.append(ch);
                }
            }
        }
        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }

        return tokens;
    }

}
