import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateMaxTest {

    @Test
    public void testASmallerBGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(5, 8);
        assertEquals(maxNumber, 8);
    }

    @Test
    public void testABSmallerGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(9, 7);
        assertEquals(maxNumber, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testABEqualGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(8, 8);

    }

    @Test
    public void testANegativeBGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(-3, 5);
        assertEquals(maxNumber, 5);
    }

    @Test
    public void testABNegativeGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(6, -2);
        assertEquals(maxNumber, 6);
    }

    @Test
    public void testANegativeBNegativeGetMax() {
        CalculateMax calculateMax = new CalculateMax();
        int maxNumber = calculateMax.getMax(-7, -3);
        assertEquals(maxNumber, -3);
    }
}
