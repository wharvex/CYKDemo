import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class GrammarTest {
    Grammar grammar;
    Variable usedHead_1;
    Variable usedHead_2;
    List<IProductionBody> expectedBodies_2;
    Terminal expectedBody_2a;
    TwoVariables expectedBody_2b;
    Variable expectedHead_3a;
    Variable expectedHead_3b;
    Terminal usedBody_3;
    Set<Variable> expectedHeads_3;

    @BeforeEach
    void setUp() {
        // Initial setup.
        usedHead_1 = new Variable('S');
        grammar = new Grammar(usedHead_1);

        // Test 2 setup.
        usedHead_2 = new Variable('A');
        expectedBody_2a = new Terminal('a');
        expectedBody_2b = new TwoVariables(usedHead_2, usedHead_2);
        expectedBodies_2 = new ArrayList<>(List.of(expectedBody_2a, expectedBody_2b));
        grammar.addProduction(usedHead_2, expectedBody_2a);
        grammar.addProduction(usedHead_2, expectedBody_2b);

        // Test 3 setup.
        expectedHead_3a = new Variable('B');
        expectedHead_3b = new Variable('C');
        expectedHeads_3 = Set.of(expectedHead_3a, expectedHead_3b);
        usedBody_3 = new Terminal('b');
        grammar.addProduction(expectedHead_3a, usedBody_3);
        grammar.addProduction(expectedHead_3b, usedBody_3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProduction_2() {
        var actualBodies_2 = grammar.getProduction(usedHead_2).orElseThrow();
        assertIterableEquals(expectedBodies_2, actualBodies_2);
    }

    @Test
    void testGetProductionHeadsFromBody_3() {
        var actualHeads_3 = grammar.getProductionHeadsFromBody(usedBody_3);
        assertEquals(expectedHeads_3, actualHeads_3);
    }
}