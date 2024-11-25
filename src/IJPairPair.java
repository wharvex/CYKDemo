public class IJPairPair {
    private final IJPair leftPair;
    private final IJPair rightPair;

    public IJPairPair(IJPair leftPair, IJPair rightPair) {
        this.leftPair = new IJPair(leftPair);
        this.rightPair = new IJPair(rightPair);
    }

    public IJPairPair(IJPairPair orig) {
        leftPair = orig.getLeftPair();
        rightPair = orig.getRightPair();
    }

    public IJPair getRightPair() {
        return new IJPair(rightPair);
    }

    public IJPair getLeftPair() {
        return new IJPair(leftPair);
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

        final IJPairPair other = (IJPairPair) obj;

        return getLeftPair().equals(other.getLeftPair()) && getRightPair().equals(other.getRightPair());
    }

    /**
     * https://stackoverflow.com/a/8180925/16458003
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + getLeftPair().hashCode();
        hash = 53 * hash + getRightPair().hashCode();
        return hash;
    }
}
