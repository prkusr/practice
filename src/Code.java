import java.util.List;

public abstract class Code implements CodeInterface {

    public void invoke() {
        getInputs().forEach((i) -> {
                    Output output = solve(i);
                    print(output);
                }
        );

    }

    public abstract List<Input> getInputs();

    public abstract Output solve(Input input);

    public abstract void print(Output output);

}
