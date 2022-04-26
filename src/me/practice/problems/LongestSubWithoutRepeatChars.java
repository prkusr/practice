package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

import java.util.ArrayList;
import java.util.List;

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
        testCases.add(new I("bbbbb")); // 3 b
        testCases.add(new I("pwwkew")); // 3 wke
        testCases.add(new I("a")); // 3 wke
        testCases.add(new I("")); // 3 wke
        return testCases;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(lswrc(in.s), in.s);
    }

    @Override
    public void print(Output output) {
        O out = (O) output;
        System.out.println("The length of longest substring for " + out.sample + " is " + out.len);
    }

    private int lswrc(String s) {
        char[] sample = s.toCharArray();

        if (sample.length == 0 || sample.length == 1) return sample.length;

        int maxLength = 0, currentIndex = 0, itrIndex = 0;
        for (int i = 1, length = 0; i < sample.length; i++) {
            if (sample[i - 1] != sample[i]) {
                length++;
            } else {
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
}
