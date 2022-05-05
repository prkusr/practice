package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubstring extends Code {

    @AllArgsConstructor
    static class I implements Input {
        String s;
    }

    @AllArgsConstructor
    static class O implements Output {
        String sample;
        String solution;
    }

    @Override
    public List<Input> getInputs() {
        List<Input> inputs = new ArrayList<>();
        inputs.add(new I("badad"));
        inputs.add(new I("a"));
        inputs.add(new I("aaaaaaaaaaaa"));
        inputs.add(new I("adada"));
        inputs.add(new I("zz"));
        inputs.add(new I("zy"));
        inputs.add(new I("sejhfgxabaxq"));
        return inputs;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(in.s, longestPalindrome(in.s));
    }

    @Override
    public void print(Output output) {
        O o = ((O) output);
        System.out.println("The is LongestPalindromeSubstring for " + o.sample + " is " + o.solution);
    }

    private String longestPalindrome(String s) {
        int i, j, start = 0, end = 0, max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        if(n == 1)
            return s;
        // Following loop will only fill upper half of the dp matrix
        for (int k = 0; k < n; k++) {
            i = 0;
            j = k;
            while (i < n && j < n) {
                // base condition
                if (i == j) {
                    dp[i][j] = true;
                }
                // compare 2 consecutive chars
                else if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                // When comparing 2 non-consecutive chars
                else {
                    //         If chars are same && previous solution is also palindrome
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                // now that we have the dp generated, let's calc the subString indices
                if (dp[i][j] && max < j - i) {
                    start = i;
                    end = j ;
                    max = j - i;
                }
                i++;
                j++;
            }
        }
        // end needs to be incremented for base case for example zy should return z
        return s.substring(start, end+1);
    }
}
