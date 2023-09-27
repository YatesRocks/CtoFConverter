import java.io.InputStreamReader;
import java.util.function.Function;
import java.io.BufferedReader;

public class Main {
    private static <T> T get_valid_input(String prompt, Function<String, T> parser) {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print(prompt);
            try {
                String input = scan.readLine();
                return parser.apply(input);
            } catch (NumberFormatException e) {
                System.err.println(e);
                System.out.println("Error parsing input. Please try again.");
            } catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        int test = get_valid_input("Number: ", Integer::parseInt);
        System.out.println(test);
    }
}