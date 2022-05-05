package me.practice;

import me.practice.mothership.Code;
import me.practice.problems.ContainerWithMostWater;
//import me.practice.problems.LongestPalindromeSubstring;
//import me.practice.problems.LongestSubWithoutRepeatChars;
//import me.practice.problems.TwoSumV2;

public class Driver {

    public static void main(String[] args) {
//      CodeTemplate<TwoSum.Input, TwoSum.Output> solver =
        Code solver;
//      solver = new TwoSumV2();
//      solver = new LongestSubWithoutRepeatChars();
//      solver = new LongestPalindromeSubstring();
        solver = new ContainerWithMostWater();
        solver.invoke();
    }
}
