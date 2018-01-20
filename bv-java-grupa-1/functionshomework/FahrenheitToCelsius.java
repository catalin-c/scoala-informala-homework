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
     * First, the main method instantiates the transformFahrenheitToCelsius class.
     * With a while loop, it asks the user to enter his body temperature in Fahrenheit degrees and it is
     * assigned to the userBodyTemperature variable.
     * Then, the conversion to Celsius is stored in userBodyTemperatureInCelsius.
     * If the Celsius degrees are bigger than 37, it prints the Celsius degrees + a warning message.
     * Else, it prints only the Celsius degrees of the user.
     */
    public static void main(String[] args) {
        FahrenheitToCelsius result = new FahrenheitToCelsius();

        while(true) {
            System.out.println("Write your body temperature(in Fahrenheit degrees): ");
            double userBodyTemperature = result.getUserInput();
            double userBodyTemperatureInCelcius = result.transformFahrenheitToCelsius(userBodyTemperature);

            if(userBodyTemperatureInCelcius > 37) {
                System.out.println("Your body temperature in Celsius degrees is " + userBodyTemperatureInCelcius);
                System.out.println("You are ill!");
            } else {
                System.out.println("Your body temperature in Celsius degrees is " + userBodyTemperatureInCelcius);
            }
        }

    }
}
