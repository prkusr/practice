package me.practice.mothership;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public abstract class Code implements CodeInterface {

    public void invoke(boolean timeAnalysis) {
        getInputs().
                forEach((i) -> {
                            Output output = timeAnalysis ? solveWithTimeAnalysis(i) : solve(i);
                            print(output);
                        }
                );

    }

    public abstract List<Input> getInputs();

    public abstract Output solve(Input input);

    public abstract void print(Output output);

    public Output solveWithTimeAnalysis(Input input) {
        long time = 0;
        Output output = null;
        for (int i = 0; i < 10; i++) {
            Instant start = Instant.now();
            output = solve(input);
            long itrTime = Duration.between(start, Instant.now()).toMillis();
            time += itrTime;
            System.out.println("Time taken for iteration " + (i + 1) + " is " + itrTime + "ms");
        }
        System.out.println("Average time taken for processing is " + (time / 10) + "ms");
        return output;
    }
}
