public class TwoVariables implements IProductionBody {
    private final Variable firstVariable;
    private final Variable secondVariable;

    public TwoVariables(Variable firstVariable, Variable secondVariable) {
        this.firstVariable = new Variable(firstVariable);
        this.secondVariable = new Variable(secondVariable);
    }

    public TwoVariables(TwoVariables orig) {
        firstVariable = new Variable(orig.firstVariable);
        secondVariable = new Variable(orig.secondVariable);
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final TwoVariables other = (TwoVariables) obj;

        return firstVariable.equals(other.firstVariable) && secondVariable.equals(other.secondVariable);
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (firstVariable != null ? firstVariable.hashCode() : 0);
        hash = 53 * hash + (secondVariable != null ? secondVariable.hashCode() : 0);
        return hash;
    }
}
