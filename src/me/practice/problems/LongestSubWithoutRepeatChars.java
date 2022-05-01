package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubWithoutRepeatChars extends Code {

    @AllArgsConstructor
    static class I implements Input {
        String s;
    }

    @AllArgsConstructor
    static class O implements Output {
        Integer len;
        String sample;
    }

    @Override
    public List<Input> getInputs() {
        List<Input> testCases = new ArrayList<>();
        testCases.add(new I("abcabcbb")); // 3 abc
        testCases.add(new I("bbbbb")); // 1 b
        testCases.add(new I("pwwkew")); // 3 wke
        testCases.add(new I("au")); // 2 au
        testCases.add(new I("aa")); // 1 a
        testCases.add(new I("")); // 0 ""
        testCases.add(new I("dvdf")); // 3 "vdf"
        return testCases;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(lswrc2(in.s), in.s);
    }

    @Override
    public void print(Output output) {
        O out = (O) output;
        System.out.println("The length of longest substring for " + out.sample + " is " + out.len);
    }

    private int lswrc(String s) {
/*
//        Older Leetcode answer
        char[] sample = s.toCharArray();
        Map<Character, Boolean> visited = new HashMap<>();

        if (sample.length == 0 || sample.length == 1) return sample.length;

        int maxLength = 0;
        for (int i = 0, length = 0; i < sample.length; i++) {
            if (!visited.containsKey(sample[i])) {
                length++;
                maxLength = Math.max(length, maxLength);
                visited.put(sample[i], true);
            } else {
                maxLength = Math.max(length, maxLength);
                length = 1;
            }
        }
        return maxLength;
*/

        char[] sample = s.toCharArray();
        Map<Character, Integer> visited = new HashMap<>();

        if (sample.length == 0 || sample.length == 1) return sample.length;

        int maxLength = 0, start = 0, endIndex = 0;
        for (int i = 0, length = 0; start < sample.length; i++) {
//            if (!visited.containsKey(sample[i])) {
//                length++;
//                maxLength = Math.max(length, maxLength);
//                visited.put(sample[i], true);
//            } else {
//                maxLength = Math.max(length, maxLength);
//                length = 1;
//                visited = new HashMap<>();
//            }
            char c = sample[i];
            if (visited.containsKey(sample[i])) {
                maxLength = Math.max(length, maxLength);
                length = 1;

                start = visited.get(c) + 1;
                endIndex = start;
                visited.put(sample[start], start);
                i = start;
            } else {
                visited.put(c, i);
                length++;
                endIndex++;
                maxLength = Math.max(length, maxLength);

            }
        }
        return maxLength;
    }

    // Accepted answer
    private int lswrc2(String s) {
        char[] sample = s.toCharArray();
        Map<Character, Integer> visited = new HashMap<>();

        if (sample.length == 0 || sample.length == 1) return sample.length;

        int maxLength = 0, start = 0;
        for (int i = 0, length = 0; i < sample.length; i++) {
            char c = sample[i];
            if (visited.containsKey(c)) {
                maxLength = Math.max(length, maxLength);
                length = 1;

                start = visited.get(c) + 1;
                visited = new HashMap<>();
                visited.put(sample[start], start); // update visited index
                i = start;
            } else {
                visited.put(c, i);
                length++;
                maxLength = Math.max(length, maxLength); // need to decide
            }
        }
        return maxLength;
    }
}
