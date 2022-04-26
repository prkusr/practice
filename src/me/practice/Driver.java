package me.practice;

import me.practice.mothership.Code;
import me.practice.problems.TwoSumV2;

public class Driver {

    public static void main(String[] args) {
//      CodeTemplate<TwoSum.Input, TwoSum.Output> solver =
        Code solver = new TwoSumV2();
        solver.invoke();
    }
}
