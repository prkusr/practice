package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;
import me.practice.mothership.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 **/

public class ContainerWithMostWater extends Code {

    @AllArgsConstructor
    static class I implements Input {
        int[] height;
    }

    @AllArgsConstructor
    static class O implements Output {
        int[] sample;
        int solution;
    }

    @Override
    public List<Input> getInputs() {
        List<Input> inputs = new ArrayList<>();
//        inputs.add(new I(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        inputs.add(new I(new int[]{1, 4}));
//        inputs.add(new I(new int[]{4}));
//        inputs.add(new I(new int[]{}));
        inputs.add(new I(getSuperLongArr()));
        return inputs;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        int maxArea = maxAreaOptimal(in.height);
        return new O(in.height, maxArea);
    }

    @Override
    public void print(Output output) {
        O o = (O) output;
        System.out.println("The max area of water the container can contain for " + Arrays.toString(o.sample) + " is " + o.solution);
    }

    public int maxArea(int[] heights) {
        int maxArea = 0;

        if (heights.length >= 100000 || heights.length < 2) {
            return 0;
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < i; j++) {
                maxArea = Math.max(maxArea, (i - j) * Math.min(heights[i], heights[j]));
            }
        }
        return maxArea;
    }

    public int maxAreaOptimal(int[] heights) {
        int maxArea = 0;

        if (heights.length > 100000 || heights.length < 2) {
            return 0;
        }

        int start = 0;
        int end = heights.length - 1;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(heights[end], heights[start]));
            if (heights[start] > heights[end])
                end--;
            else
                start++;
        }
        return maxArea;
    }

    // This code won't even compile for this large input
    private int[] getSuperLongArr() {
//      String fileName = "heightArray.csv"; // Answer 705634720
        String fileName = "heightArrayFail1.csv"; // Answer 995042464
        try {
            return FileReader.readNumbersFromFile(fileName, Integer.class)
                    .stream()
                    .mapToInt(Number::intValue)
                    .toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[]{};
    }
}
