package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

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
        return null;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(in.s, longestPalindrome(in.s));
    }

    @Override
    public void print(Output output) {
        O o = ((O) output);
        System.out.println("The is LongestPalindromeSubstring for " + o.sample + " " + o.solution);
    }

    private String longestPalindrome(String s) {
        return "";
    }

}
