import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * G = (V, T, P, S)
 */
public class Grammar {

    private final List<Variable> variables;
    private final List<Terminal> terminals;
    private final Map<Variable, List<IProductionBody>> productions;
    private final Variable startSymbol;

    public Grammar(Variable startSymbol) {
        variables = new ArrayList<>();
        terminals = new ArrayList<>();
        productions = new HashMap<>();
        this.startSymbol = startSymbol;
    }
}
