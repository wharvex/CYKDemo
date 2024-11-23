import java.util.*;

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

    public Optional<List<IProductionBody>> getProduction(Variable variable) {
        return Optional.ofNullable(productions.get(variable));
    }

    public void addProduction(Variable variable, IProductionBody bodyToAdd) {
        getProduction(variable).ifPresentOrElse(presentBodies -> presentBodies.add(bodyToAdd), () -> productions.put(variable, new ArrayList<>(List.of(bodyToAdd))));
    }
}
