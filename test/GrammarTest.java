import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GrammarTest {
    Grammar grammar;
    Variable head1;
    Variable head2;
    List<IProductionBody> expectedBodies2;
    Terminal expectedBody2a;
    TwoVariables expectedBody2b;

    @BeforeEach
    void setUp() {
        head1 = new Variable('S');
        grammar = new Grammar(head1);
        head2 = new Variable('A');
        expectedBody2a = new Terminal('a');
        expectedBody2b = new TwoVariables(head2, head2);
        grammar.addProduction(head2, expectedBody2a);
        grammar.addProduction(head2, expectedBody2b);
        expectedBodies2 = new ArrayList<>(List.of(expectedBody2a, expectedBody2b));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProduction() {
        assertIterableEquals(expectedBodies2, grammar.getProduction(head2).orElseThrow());
    }
}