import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrammarTest {
    Grammar grammar;

    @BeforeEach
    void setUp() {
        grammar = new Grammar(new Variable('S'));
        grammar.addProduction(new Variable('A'), new Terminal('a'));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetProduction() {
        var head = new Variable('A');
        var expectedBody = new Terminal('a');
        assertEquals(expectedBody, grammar.getProduction(head).orElseThrow().getFirst());
    }
}