public class Terminal extends VariableOrTerminal implements IProductionBody {
    public Terminal(char symbol) {
        super(symbol);
    }

    public Terminal(Terminal orig) {
        super(orig);
    }
}
