import java.util.HashMap;
import java.util.Map;

public class TwoSum extends CodeTemplateOld<TwoSum.Input, TwoSum.Output> {

    // Accepted
    public static Integer[] twoSum(Integer[] nums, Integer target) {

        for (Integer i = 0; i < nums.length; i++) {
            for (Integer j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[2];
    }

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
    public Input getInput() {
        return new Input(new Integer[]{7, 6, 13, 11}, 24);
    }

    @Override
    public Output solve(Input input) {
        return new Output(twoSumBest(input.nums, input.target));
    }

    @Override
    public void print(Output output) {
        System.out.println("Solution is : " + output.output[0] + " " + output.output[1]);
    }


    static class Input {
        Integer[] nums = {7, 6, 13, 11};
        int target = 24;

        Input(Integer[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }
    }

    static class Output {
        Integer[] output;

        Output(Integer[] output) {
            this.output = output;
        }
    }
}

