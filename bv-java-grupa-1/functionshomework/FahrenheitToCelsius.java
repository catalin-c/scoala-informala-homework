import java.util.InputMismatchException;
import java.util.Scanner;

public class FahrenheitToCelsius {
    //The reader class member is declared and instantiated
    private Scanner reader = new Scanner(System.in);

    /**
     * @return returns the int given by the user in the console
     */
    public double getUserInput() {
        return this.reader.nextDouble();
    }

    /**
     * The method takes the fahrenheit degrees as input and returns the Celsius equivalent
     * calculated with the standard formula.
     *
     * @param fahrenheitDegrees is the fahrenheit degrees given as input
     * @return returns the Celcius equivalent
     */
    public double transformFahrenheitToCelsius(double fahrenheitDegrees) {
        return (fahrenheitDegrees - 32) * 5/9;
    }

    /**
     * First, within a while loop, the main method instantiates the transformFahrenheitToCelsius class.
     * Then, it asks the user to enter his body temperature in Fahrenheit degrees. The variable that will store it
     * is declared and if the user gives the right type of value, it will be assigned
     * to the userBodyTemperature variable in the try/catch block. Otherwise, a message will be printed
     * and the loop starts again.
     * Then, the conversion to Celsius is stored in userBodyTemperatureInCelsius.
     * If the Celsius degrees are bigger than 37, it prints the Celsius degrees + a warning message.
     * Else, it prints only the Celsius degrees of the user.
     */
    public static void main(String[] args) {


        while(true) {
            FahrenheitToCelsius result = new FahrenheitToCelsius();

            System.out.println("Write your body temperature(in Fahrenheit degrees): ");

            double userBodyTemperature;
            try{
                userBodyTemperature = result.getUserInput();
            } catch (InputMismatchException e) {
                System.out.println("Can't use that value!");
                continue;
            }

            double userBodyTemperatureInCelsius = result.transformFahrenheitToCelsius(userBodyTemperature);

            if(userBodyTemperatureInCelsius > 37) {
                System.out.println("Your body temperature in Celsius degrees is " + userBodyTemperatureInCelsius);
                System.out.println("You are ill!");
            } else {
                System.out.println("Your body temperature in Celsius degrees is " + userBodyTemperatureInCelsius);
            }
        }

    }
}
