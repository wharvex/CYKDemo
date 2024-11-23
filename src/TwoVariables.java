public class TwoVariables implements IProductionBody {
    private final Variable firstVariable;
    private final Variable secondVariable;

    public TwoVariables(Variable firstVariable, Variable secondVariable) {
        this.firstVariable = firstVariable;
        this.secondVariable = secondVariable;
    }

    public TwoVariables(TwoVariables orig) {
        firstVariable = new Variable(orig.firstVariable);
        secondVariable = new Variable(orig.secondVariable);
    }
}
