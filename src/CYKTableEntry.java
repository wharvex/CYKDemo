import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CYKTableEntry {
    private final int i;
    private final int j;
    private final Set<Variable> variables;

    public CYKTableEntry(int i, int j) {
        this.i = i;
        this.j = j;
        this.variables = new HashSet<>();
    }

    public CYKTableEntry(CYKTableEntry orig) {
        this.i = orig.i;
        this.j = orig.j;
        this.variables = orig.variables.stream().map(Variable::new).collect(Collectors.toSet());
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Set<TwoVariables> cartesianProduct(CYKTableEntry other) {
        var ret = new HashSet<TwoVariables>();
        variables.forEach(v -> other.variables.forEach(v2 -> ret.add(new TwoVariables(v, v2))));
        return ret;
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

        final CYKTableEntry other = (CYKTableEntry) obj;

        return getI() == other.getI() && getJ() == other.getJ() && variables.equals(other.variables);
    }

    public void addVariable(Variable variable) {
        variables.add(new Variable(variable));
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
        hash = 53 * hash + variables.stream().map(Variable::hashCode).reduce(0, Integer::sum);
        return hash;
    }
}
