import java.util.*;

/**
 * G = (V, T, P, S)
 */
public class Grammar {

    private final Set<Variable> variables;
    private final Set<Terminal> terminals;
    private final Map<Variable, List<IProductionBody>> productions;
    private final Variable startSymbol;

    public Grammar(Variable startSymbol) {
        variables = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
        this.startSymbol = new Variable(startSymbol);
        addVariable(startSymbol);
    }

    public Optional<List<IProductionBody>> getProduction(Variable variable) {
        return Optional.ofNullable(productions.get(new Variable(variable)));
    }

    public void addProduction(Variable variable, IProductionBody bodyToAdd) {
        addVariable(variable);
        IProductionBody copyOfBodyToAdd;
        if (bodyToAdd instanceof Terminal) {
            copyOfBodyToAdd = new Terminal((Terminal) bodyToAdd);
            addTerminal((Terminal) bodyToAdd);
        } else {
            copyOfBodyToAdd = new TwoVariables((TwoVariables) bodyToAdd);
        }
        getProduction(variable).ifPresentOrElse(presentBodies -> presentBodies.add(copyOfBodyToAdd), () -> productions.put(variable, new ArrayList<>(List.of(copyOfBodyToAdd))));
    }

    public void addVariable(Variable variable) {
        variables.add(new Variable(variable));
    }

    public void addTerminal(Terminal terminal) {
        terminals.add(new Terminal(terminal));
    }
}
