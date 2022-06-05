package me.practice.problems.string;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

import java.util.ArrayList;
import java.util.List;

public class LongestRepeatingCharReplacement extends Code {

    @AllArgsConstructor
    static class I implements Input {
        String s;
        Integer k;
    }

    @AllArgsConstructor
    static class O implements Output {
        Integer k;
        String sample;
        Integer solution;
    }

    @Override
    public List<Input> getInputs() {
        List<Input> testCases = new ArrayList<>();
//        testCases.add(new I("ABAB", 2)); // 4 Replace the two 'A's with two 'B's or vice versa.
        testCases.add(new I("ABABB", 2)); // 4 Replace the two 'A's with two 'B's or vice versa.
//        testCases.add(new I("AABABBA", 1)); // 4
        /*
         * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
         * The substring "BBBB" has the longest repeating letters, which is 4.
         */
        return testCases;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(in.k, in.s, lrcr(in.k, in.s));
    }

    @Override
    public void print(Output output) {
        O o = (O) output;
        System.out.println("Solution for sample=" + o.sample + " with k=" + o.k + " is " + o.solution);
    }

    private int lrcr(int k, String s) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
