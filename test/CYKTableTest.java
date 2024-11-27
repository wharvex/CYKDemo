import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
    CYKTable table_CT5;
    List<CYKTableEntry> expectedEntries_CT5;
    CYKTable table_CT6;
    List<CYKTableEntry> expectedEntries_CT6;
    CYKTable table_CT7;
    List<CYKTableEntry> expectedEntries_CT7;
    CYKTable table_CT8;

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
        setUp_CT5();
        setUp_CT6();
        setUp_CT7();

        table_CT8 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
    }

    // Row 1
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

    // Row 2
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

    // Row 3
    void setUp_CT5() {
        table_CT5 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
        var varB = new Variable('B');
        var expectedEntry1I = 1;
        var expectedEntry1J = 3;
        var expectedEntry2I = 2;
        var expectedEntry2J = 4;
        var expectedEntry3I = 3;
        var expectedEntry3J = 5;

        // { }
        var expectedEntry1 = new CYKTableEntry(expectedEntry1I, expectedEntry1J);

        // { B }
        var expectedEntry2 = new CYKTableEntry(expectedEntry2I, expectedEntry2J);
        expectedEntry2.addVariable(varB);

        // { B }
        var expectedEntry3 = new CYKTableEntry(expectedEntry3I, expectedEntry3J);
        expectedEntry3.addVariable(varB);

        var expectedEntries_CT5a = List.of(expectedEntry1, expectedEntry2, expectedEntry3);
        expectedEntries_CT5 = Stream.concat(expectedEntries_CT4.stream(), expectedEntries_CT5a.stream()).toList();
    }

    // Row 4
    void setUp_CT6() {
        table_CT6 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
        var varA = new Variable('A');
        var varC = new Variable('C');
        var varS = new Variable('S');
        var expectedEntry1I = 1;
        var expectedEntry1J = 4;
        var expectedEntry2I = 2;
        var expectedEntry2J = 5;

        // { }
        var expectedEntry1 = new CYKTableEntry(expectedEntry1I, expectedEntry1J);

        // { S, A, C }
        var expectedEntry2 = new CYKTableEntry(expectedEntry2I, expectedEntry2J);
        expectedEntry2.addVariable(varS);
        expectedEntry2.addVariable(varA);
        expectedEntry2.addVariable(varC);

        var expectedEntries_CT6a = List.of(expectedEntry1, expectedEntry2);
        expectedEntries_CT6 = Stream.concat(expectedEntries_CT5.stream(), expectedEntries_CT6a.stream()).toList();
    }

    // Row 5
    void setUp_CT7() {
        table_CT7 = new CYKTable(CYKTable.sampleInputString(), Grammar.sampleGrammar());
        var varA = new Variable('A');
        var varC = new Variable('C');
        var varS = new Variable('S');
        var expectedEntry1I = 1;
        var expectedEntry1J = 5;

        // { S, A, C }
        var expectedEntry1 = new CYKTableEntry(expectedEntry1I, expectedEntry1J);
        expectedEntry1.addVariable(varS);
        expectedEntry1.addVariable(varA);
        expectedEntry1.addVariable(varC);

        var expectedEntries_CT7a = List.of(expectedEntry1);
        expectedEntries_CT7 = Stream.concat(expectedEntries_CT6.stream(), expectedEntries_CT7a.stream()).toList();
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

    @Test
    void testAddNonBottomRow_CT5() {
        table_CT5.addBottomRow();
        table_CT5.addNonBottomRow(2);
        table_CT5.addNonBottomRow(3);
        var actualEntries_CT5 = table_CT5.getEntries();
        assertIterableEquals(expectedEntries_CT5, actualEntries_CT5);
    }

    @Test
    void testAddNonBottomRow_CT6() {
        table_CT6.addBottomRow();
        table_CT6.addNonBottomRow(2);
        table_CT6.addNonBottomRow(3);
        table_CT6.addNonBottomRow(4);
        var actualEntries_CT6 = table_CT6.getEntries();
        assertIterableEquals(expectedEntries_CT6, actualEntries_CT6);
    }

    @Test
    void testAddNonBottomRow_CT7() {
        table_CT7.addBottomRow();
        table_CT7.addNonBottomRow(2);
        table_CT7.addNonBottomRow(3);
        table_CT7.addNonBottomRow(4);
        table_CT7.addNonBottomRow(5);
        var actualEntries_CT7 = table_CT7.getEntries();
        assertIterableEquals(expectedEntries_CT7, actualEntries_CT7);
    }

    @Test
    void testGetAnswer_CT8() {
        table_CT8.addBottomRow();
        table_CT8.addNonBottomRow(2);
        table_CT8.addNonBottomRow(3);
        table_CT8.addNonBottomRow(4);
        table_CT8.addNonBottomRow(5);
        assertTrue(table_CT8.getAnswer());
    }
}