package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumV2 extends Code {

    // Best solution
    public static Integer[] twoSumBest(Integer[] nums, Integer target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (Integer i = 0; i < nums.length; ++i) {
            if (seen.containsKey(target - nums[i])) {
                return new Integer[]{seen.get(target - nums[i]), i};
            }
            seen.put(nums[i], i);
        }
        return new Integer[2];
    }

    @Override
    public List<Input> getInputs() {
        List<Input> testCases = new ArrayList<>();
        testCases.add(new CodeInput(new Integer[]{7, 6, 13, 11}, 24));
        testCases.add(new CodeInput(new Integer[]{2, 7, 11, 15}, 9));
        return testCases;
    }

    @Override
    public Output solve(Input input) {
        CodeInput m = (CodeInput) input;
        return new CodeOutput(twoSumBest(m.nums, m.target));
    }

    @Override
    public void print(Output out) {
        CodeOutput output = (CodeOutput) out;
        System.out.println("Solution is : " + output.output[0] + " " + output.output[1]);
    }

    @AllArgsConstructor
    static class CodeInput implements Input {
        Integer[] nums;
        int target;

//        CodeInput(Integer[] nums, int target) {
//            this.nums = nums;
//            this.target = target;
//        }

    }

    @AllArgsConstructor
    static class CodeOutput implements Output {
        Integer[] output;

//        CodeOutput(Integer[] output) {
//            this.output = output;
//        }
    }
}
