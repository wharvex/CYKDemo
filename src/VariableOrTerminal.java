public class VariableOrTerminal {
    private final char symbol;

    protected VariableOrTerminal(char symbol) {
        this.symbol = symbol;
    }

    protected VariableOrTerminal(VariableOrTerminal orig) {
        symbol = orig.symbol;
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

        final VariableOrTerminal other = (VariableOrTerminal) obj;

        return symbol == other.symbol;
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + symbol;
        return hash;
    }
}
