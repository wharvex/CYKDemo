import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CYKTableEntryTest {
    CYKTableEntry entry;
    CYKTableEntry usedEntry_CTE2;
    Variable usedVariable_CTE2a;
    Variable usedVariable_CTE2c;
    Variable usedVariable_CTE2s;
    TwoVariables expectedPair_CTE2as;
    TwoVariables expectedPair_CTE2ac;
    TwoVariables expectedPair_CTE2cs;
    TwoVariables expectedPair_CTE2cc;
    Set<TwoVariables> expectedPairs_CTE2;


    @BeforeEach
    void setUp() {
        // Initial setup.
        entry = new CYKTableEntry(2, 2);

        // Test CTE2 setup.
        usedVariable_CTE2a = new Variable('A');
        usedVariable_CTE2c = new Variable('C');
        usedVariable_CTE2s = new Variable('S');
        entry.addVariable(usedVariable_CTE2a);
        entry.addVariable(usedVariable_CTE2c);
        usedEntry_CTE2 = new CYKTableEntry(3, 4);
        usedEntry_CTE2.addVariable(usedVariable_CTE2s);
        usedEntry_CTE2.addVariable(usedVariable_CTE2c);
        expectedPair_CTE2as = new TwoVariables(usedVariable_CTE2a, usedVariable_CTE2s);
        expectedPair_CTE2ac = new TwoVariables(usedVariable_CTE2a, usedVariable_CTE2c);
        expectedPair_CTE2cs = new TwoVariables(usedVariable_CTE2c, usedVariable_CTE2s);
        expectedPair_CTE2cc = new TwoVariables(usedVariable_CTE2c, usedVariable_CTE2c);
        expectedPairs_CTE2 = Set.of(expectedPair_CTE2as, expectedPair_CTE2ac, expectedPair_CTE2cs, expectedPair_CTE2cc);
    }

    @Test
    void cartesianProduct_CTE2() {
        var actualPairs_CTE2 = entry.cartesianProduct(usedEntry_CTE2);
        assertEquals(expectedPairs_CTE2, actualPairs_CTE2);
    }
}