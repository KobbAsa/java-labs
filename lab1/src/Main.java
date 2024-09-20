import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type any positive number: ");
        int number = scanner.nextInt();

        List<Integer> perfectNumbers = findPerfectNumbersInRange(number);

        System.out.println("\nPerfect numbers in range from 1 to " + number + ": " + perfectNumbers);
    }

    public static List<Integer> findPerfectNumbersInRange(int number) {
        List<Integer> perfectNumbers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int sum = 0; // divisors` sum

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }
}