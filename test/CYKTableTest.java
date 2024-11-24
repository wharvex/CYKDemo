import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CYKTableTest {
    CYKTable table;
    CYKTableEntry usedEntry_CT2;
    Variable usedVariable_CT2;
    int usedI_CT2;
    int usedJ_CT2;
    CYKTableEntry expectedEntry_CT2;

    @BeforeEach
    void setUp() {
        // Initial setup.
        table = new CYKTable();

        // Test CT2 setup.
        usedI_CT2 = 1;
        usedJ_CT2 = 1;
        usedEntry_CT2 = new CYKTableEntry(usedI_CT2, usedJ_CT2);
        usedVariable_CT2 = new Variable('A');
        usedEntry_CT2.addVariable(usedVariable_CT2);
        expectedEntry_CT2 = new CYKTableEntry(usedEntry_CT2);
        table.addEntry(usedEntry_CT2);
    }

    @Test
    void testGetEntry_CT2() {
        var actualEntry_CT2 = table.getEntry(usedI_CT2, usedJ_CT2);
        assertEquals(expectedEntry_CT2, actualEntry_CT2);
    }
}