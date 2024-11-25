public class IJPair {
    private final int i;
    private final int j;

    public IJPair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public IJPair(IJPair orig) {
        i = orig.getI();
        j = orig.getJ();
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
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

        final IJPair other = (IJPair) obj;

        return getI() == other.getI() && getJ() == other.getJ();
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + getI();
        hash = 53 * hash + getJ();
        return hash;
    }
}
