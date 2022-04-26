public abstract class CodeTemplateOld<I,O> {

    public void invokeSolver(){
        O output = solve(getInput());
        print(output);
    }

    public abstract I getInput();

    public abstract O solve(I input);

    public abstract void print(O output);

}
