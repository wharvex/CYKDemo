import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class HelperTest {
    List<IJPairPair> expectedIJPairPairs_H2;

    @BeforeEach
    void setUp() {
        var expectedIJPair_H2a1 = new IJPair(2, 2);
        var expectedIJPair_H2a2 = new IJPair(3, 4);
        var expectedIJPairPair_H2a = new IJPairPair(expectedIJPair_H2a1, expectedIJPair_H2a2);
        var expectedIJPair_H2b1 = new IJPair(2, 3);
        var expectedIJPair_H2b2 = new IJPair(4, 4);
        var expectedIJPairPair_H2b = new IJPairPair(expectedIJPair_H2b1, expectedIJPair_H2b2);
        expectedIJPairPairs_H2 = List.of(expectedIJPairPair_H2a, expectedIJPairPair_H2b);
    }

    @Test
    void testGetIJPairsForComparison_H2() {
        assertIterableEquals(expectedIJPairPairs_H2, Helper.getIJPairsForComparison(2, 4));
    }
}