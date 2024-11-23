public class Terminal implements IProductionBody {
    private final char symbol;

    public Terminal(char symbol) {
        this.symbol = symbol;
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

        final Terminal other = (Terminal) obj;

        return this.symbol == other.symbol;
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.symbol;
        return hash;
    }
}
