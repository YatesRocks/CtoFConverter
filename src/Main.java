import java.io.InputStreamReader;
import java.util.function.Function;
import java.io.BufferedReader;

public class Main {
    private static <T> T get_valid_input(String prompt, Function<String, T> parser) {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(prompt);
            try {
                String input = scan.readLine();
                return parser.apply(input);
            } catch (NumberFormatException e) {
                System.err.println(e); // TODO: Use logger instead of sys err
                System.out.println("Error parsing input. Please try again.");
            } catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        } while (true);
    }

    public static void main(String[] args) {
        double celsius = get_valid_input("Enter temperature as an integer in celsius: ", Double::parseDouble);
        double fahrenheit = celsius * (9./5.) + 32;
        System.out.println("In fahrenheit that is: " + fahrenheit);
    }
}