import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FahrenheitToCelsiusTest {

    @Test
    public void testPositiveParamTransformFahrenheitToCelsius() {
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        double celciusDegrees = fahrenheitToCelsius.transformFahrenheitToCelsius(89);
        assertEquals(celciusDegrees, 31.666666666666668, 1e-15);
    }

    @Test
    public void testNegativeParamTransformFahrenheitToCelsius() {
        FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsius();
        double celciusDegrees = fahrenheitToCelsius.transformFahrenheitToCelsius(-66);
        assertEquals(celciusDegrees, -54.44444444444444, 1e-15);
    }
}
