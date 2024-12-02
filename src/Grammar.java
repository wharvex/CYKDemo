import java.util.*;
import java.util.stream.Collectors;

/**
 * G = (V, T, P, S)
 */
public class Grammar {

    private final Set<Variable> variables;
    private final Set<Terminal> terminals;
    private final Map<Variable, List<IProductionBody>> productions;
    private Variable startSymbol;

    public Grammar(Variable startSymbol) {
        variables = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
        this.startSymbol = new Variable(startSymbol);
        addVariable(startSymbol);
    }

    public Grammar() {
        variables = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
    }

    public static Grammar sampleGrammar() {
        var varS = new Variable('S');
        var varA = new Variable('A');
        var varB = new Variable('B');
        var varC = new Variable('C');
        var termA = new Terminal('a');
        var termB = new Terminal('b');
        var pairAB = new TwoVariables(varA, varB);
        var pairBC = new TwoVariables(varB, varC);
        var pairBA = new TwoVariables(varB, varA);
        var pairCC = new TwoVariables(varC, varC);
        var ret = new Grammar(varS);
        ret.addProduction(varS, pairAB);
        ret.addProduction(varS, pairBC);
        ret.addProduction(varA, pairBA);
        ret.addProduction(varA, pairBA);
        ret.addProduction(varA, termA);
        ret.addProduction(varB, pairCC);
        ret.addProduction(varB, termB);
        ret.addProduction(varC, pairAB);
        ret.addProduction(varC, termA);
        return ret;
    }

    public Optional<List<IProductionBody>> getProduction(Variable variable) {
        return Optional.ofNullable(productions.get(new Variable(variable)));
    }

    public void addProduction(Variable variable, IProductionBody bodyToAdd) {
        addVariable(variable);
        var copyOfBodyToAdd = copyBody(bodyToAdd);
        if (bodyToAdd instanceof Terminal) {
            addTerminal((Terminal) bodyToAdd);
        }
        getProduction(variable).ifPresentOrElse(presentBodies -> presentBodies.add(copyOfBodyToAdd), () -> productions.put(new Variable(variable), new ArrayList<>(List.of(copyOfBodyToAdd))));
    }

    public void addVariable(Variable variable) {
        variables.add(new Variable(variable));
    }

    public void addTerminal(Terminal terminal) {
        terminals.add(new Terminal(terminal));
    }

    public Set<Variable> getProductionHeadsFromBody(IProductionBody body) {
        return variables.stream().filter(v -> getProduction(v).orElseGet(List::of).contains(copyBody(body))).collect(Collectors.toSet());
    }

    public IProductionBody copyBody(IProductionBody orig) {
        return switch (orig) {
            case Epsilon ignored -> new Epsilon();
            case Terminal t -> new Terminal(t);
            case TwoVariables tv -> new TwoVariables(tv);
            default -> throw new IllegalStateException("Unexpected value: " + orig);
        };
    }
}
