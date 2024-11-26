import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CYKTableTest {
    CYKTable table;
    CYKTableEntry usedEntry_CT2;
    Variable usedVariable_CT2;
    int usedI_CT2;
    int usedJ_CT2;
    CYKTableEntry expectedEntry_CT2;
    CYKTable table_CT3;
    List<CYKTableEntry> expectedEntries_CT3;
    CYKTable table_CT4;
    List<CYKTableEntry> expectedEntries_CT4;

    @BeforeEach
    void setUp() {
        // Initial setup.
        table = new CYKTable(null, null);

        // Test CT2 setup.
        usedI_CT2 = 1;
        usedJ_CT2 = 1;
        usedEntry_CT2 = new CYKTableEntry(usedI_CT2, usedJ_CT2);
        usedVariable_CT2 = new Variable('A');
        usedEntry_CT2.addVariable(usedVariable_CT2);
        expectedEntry_CT2 = new CYKTableEntry(usedEntry_CT2);
        table.addEntry(usedEntry_CT2);

        setUp_CT3();
        setUp_CT4();
    }

    void setUp_CT3() {
        table_CT3 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
        var varA = new Variable('A');
        var varB = new Variable('B');
        var varC = new Variable('C');
        var expectedEntry1I = 1;
        var expectedEntry1J = 1;
        var expectedEntry2I = 2;
        var expectedEntry2J = 2;
        var expectedEntry3I = 3;
        var expectedEntry3J = 3;
        var expectedEntry4I = 4;
        var expectedEntry4J = 4;
        var expectedEntry5I = 5;
        var expectedEntry5J = 5;
        var expectedEntry1 = new CYKTableEntry(expectedEntry1I, expectedEntry1J);
        expectedEntry1.addVariable(varB);
        var expectedEntry2 = new CYKTableEntry(expectedEntry2I, expectedEntry2J);
        expectedEntry2.addVariable(varA);
        expectedEntry2.addVariable(varC);
        var expectedEntry3 = new CYKTableEntry(expectedEntry3I, expectedEntry3J);
        expectedEntry3.addVariable(varA);
        expectedEntry3.addVariable(varC);
        var expectedEntry4 = new CYKTableEntry(expectedEntry4I, expectedEntry4J);
        expectedEntry4.addVariable(varB);
        var expectedEntry5 = new CYKTableEntry(expectedEntry5I, expectedEntry5J);
        expectedEntry5.addVariable(varA);
        expectedEntry5.addVariable(varC);
        expectedEntries_CT3 = List.of(expectedEntry1, expectedEntry2, expectedEntry3, expectedEntry4, expectedEntry5);
    }

    void setUp_CT4() {
        table_CT4 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
        var varA = new Variable('A');
        var varB = new Variable('B');
        var varC = new Variable('C');
        var varS = new Variable('S');
        var expectedEntry1I = 1;
        var expectedEntry1J = 2;
        var expectedEntry2I = 2;
        var expectedEntry2J = 3;
        var expectedEntry3I = 3;
        var expectedEntry3J = 4;
        var expectedEntry4I = 4;
        var expectedEntry4J = 5;

        // { S, A }
        var expectedEntry1 = new CYKTableEntry(expectedEntry1I, expectedEntry1J);
        expectedEntry1.addVariable(varS);
        expectedEntry1.addVariable(varA);

        // { B }
        var expectedEntry2 = new CYKTableEntry(expectedEntry2I, expectedEntry2J);
        expectedEntry2.addVariable(varB);

        // { S, C }
        var expectedEntry3 = new CYKTableEntry(expectedEntry3I, expectedEntry3J);
        expectedEntry3.addVariable(varS);
        expectedEntry3.addVariable(varC);

        // { S, A }
        var expectedEntry4 = new CYKTableEntry(expectedEntry4I, expectedEntry4J);
        expectedEntry4.addVariable(varS);
        expectedEntry4.addVariable(varA);

        var expectedEntries_CT4a = List.of(expectedEntry1, expectedEntry2, expectedEntry3, expectedEntry4);
        expectedEntries_CT4 = Stream.concat(expectedEntries_CT3.stream(), expectedEntries_CT4a.stream()).toList();
    }

    @Test
    void testGetEntry_CT2() {
        var actualEntry_CT2 = table.getEntry(usedI_CT2, usedJ_CT2);
        assertEquals(expectedEntry_CT2, actualEntry_CT2);
    }

    @Test
    void testAddBottomRow_CT3() {
        table_CT3.addBottomRow();
        assertIterableEquals(expectedEntries_CT3, table_CT3.getEntries());
    }

    @Test
    void testAddNonBottomRow_CT4() {
        table_CT4.addBottomRow();
        table_CT4.addNonBottomRow(2);
        var actualEntries_CT4 = table_CT4.getEntries();
        assertIterableEquals(expectedEntries_CT4, actualEntries_CT4);
    }
}