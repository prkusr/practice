package me.practice.problems;

import lombok.AllArgsConstructor;
import me.practice.mothership.Code;

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
        inputs.add(new I(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        return inputs;
    }

    @Override
    public Output solve(Input input) {
        I in = (I) input;
        return new O(in.height, maxArea(in.height));
    }

    @Override
    public void print(Output output) {
        O o = (O) output;
        System.out.println("The max area of water the container can contain for " + Arrays.toString(o.sample) + " is " + o.solution);
    }

    public int maxArea(int[] height) {
        return 0;
    }

}
