import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class InputDataValidationTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFormatTime() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        String formattedTime = inputDataValidation.formatTime("5");
        assertEquals(formattedTime, "05");
    }

    @Test
    public void testAlreadyCorrectValueFormatTime() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        String formattedTime = inputDataValidation.formatTime("11");
        assertEquals(formattedTime, "11");
    }

    @Test
    public void testWrongInputCheckHourFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean isCorrectHour = inputDataValidation.checkHourFormat("asd");
        assertEquals(isCorrectHour,false);
    }

    @Test
    public void testWrongInputTypeCheckMinutesFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean isCorrectHour = inputDataValidation.checkMinutesFormat("ddd");
        assertEquals(isCorrectHour,false);
    }

    @Test
    public void testWrongValueCheckHourFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean isCorrectHour = inputDataValidation.checkHourFormat("25");
        assertEquals(isCorrectHour, false);
    }

    @Test
    public void testCorrectValueCheckHourFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean isCorrectHour = inputDataValidation.checkHourFormat("18");
        assertEquals(isCorrectHour, true);
    }

    @Test
    public void testWrongValueCheckMinutesFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean correctMinutes = inputDataValidation.checkMinutesFormat("-5");
        assertEquals(correctMinutes, false);
    }

    @Test
    public void testCorrectValueCheckMinutesFormat() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean correctMinutes = inputDataValidation.checkMinutesFormat("44");
        assertEquals(correctMinutes, true);
    }

    @Test
    public void testCorrectValueIsInBetween() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean value = inputDataValidation.isInBetween(7, 2, 9);
        assertEquals(value, true);
    }

    @Test
    public void testWrongValueIsInBetween() {
        InputDataValidation inputDataValidation = new InputDataValidation();
        boolean value = inputDataValidation.isInBetween(-4, 2, 9);
        assertEquals(value, false);
    }

}
