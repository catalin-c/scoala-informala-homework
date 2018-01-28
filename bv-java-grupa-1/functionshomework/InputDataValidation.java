import java.util.Scanner;
import java.util.regex.Pattern;

public class InputDataValidation {
    //The reader class member is declared and instantiated
    Scanner reader = new Scanner(System.in);

    /**
     * The method starts with a while loop so the program can continue or stop according to the user input.
     * It asks the user to write the time (first the hour and after that the minutes which are assigned to their
     * corresponding variables (hour and minutes).
     *
     * If either of the two variables (hour and minutes) has the value "exit" then the while loop will break
     * and the program will stop.
     *
     * The method checks if the hour and the minutes variables given by the user
     * have the correct values by calling the checkHourFormat() and checkMinutesFormat() methods.
     * If they do, the hour and minutes variables are assigned their formatted values
     * (by calling the formatTime() method) and then print them in the console.
     * Otherwise, the method prints a message that informs the user that the given time is incorrect.
     *
     */
    public void start() {
        while (true) {
            System.out.println("What time is it? (Write the hour then the minutes)");
            String hour = this.reader.next();
            String minutes = this.reader.next();

            if (hour.equals("exit") || minutes.equals("exit")) {
                break;
            }

            if(checkHourFormat(hour) && checkMinutesFormat(minutes)) {
                hour = formatTime(hour);
                minutes = formatTime(minutes);
                System.out.println("The time is: " + hour + ":" + minutes);
            } else {
                System.out.println("Incorrect time!");
            }
        }
    }

    /**
     * The method takes a String (which represents the time) as a parameter.
     * If the integer value of the parameter is smaller than 10 and it doesn't contain 0
     * Then the method returns the correctly formatted time (Eg. if the parameter is 9,
     * the method will return 09 so it can be printed correctly).
     *
     * @param time is the given time that needs to be formatted
     * @return if the time is correct already, it will return it back
     */
    public String formatTime(String time) {
        if (Integer.valueOf(time) < 10 && !(time.contains("0"))) {
            return "0" + time;
        }
        return time;
    }

    /**
     * The method takes a String hour as input.
     * If the parameter has the right format, it calls the method isInBetween() on the integer value of the String.
     * If the hour is between the 0 and 23 (including 0 and 23), then the checkHourFormat will return true
     * and otherwise false.
     *
     * @param hour is the given hour that needs to be checked
     * @return returns a boolean if the given hour is bigger or equal than 0 and smaller or equal than 23
     */
    public boolean checkHourFormat(String hour) {
        if(!(Pattern.matches("[a-zA-Z]+", hour))) {
            return isInBetween(Integer.valueOf(hour), 0, 23);
        }
        return false;
    }

    /**
     * The method takes a String hour as input.
     * If the parameter has the right format, it calls the method isInBetween() on the integer value of the String.
     * If the minutes value is between the 0 and 59 (including 0 and 59), then the checkHourFormat will return true
     * and otherwise false.
     *
     * @param minutes is the given minutes value that needs to be checked
     * @return returns a boolean if the given minutes value is bigger or equal than 0 and smaller or equal than 23
     */
    public boolean checkMinutesFormat(String minutes) {
        if(!(Pattern.matches("[a-zA-Z]+", minutes))) {
            return isInBetween(Integer.valueOf(minutes), 0, 59);
        }
        return false;
    }

    /**
     * The methods checks if the first parameter(num) is bigger or equal than the second parameter(min)
     * and smaller or equal than the third parameter(max).
     * If it is, the method returns true and otherwise false.
     *
     * @param num is the number that needs to be compared
     * @param min is the lower limit that the num will compare to
     * @param max is the highest limit that the num will compare to
     * @return returns true or false according to the conditions
     */
    public boolean isInBetween(int num, int min, int max) {
        if (num >= min && num <= max) {
            return true;
        }
        return false;
    }

    /**
     * The main method instantiates the InputDataValidation class.
     * Then, it calls the start() method that starts the whole program.
     */
    public static void main(String[] args) {
        InputDataValidation test = new InputDataValidation();
        test.start();
    }
}
