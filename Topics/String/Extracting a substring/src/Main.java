import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input = scanner.nextLine();
        int num1 = 0;
        int num2 = 0;

        try {
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
//            scanner.nextLine();

            if (num1 < 0 || num1 >= input.length() ||
                    num2 < 0 || num2 >= input.length()) {
                throw new RuntimeException("Both numbers are always greater than or equal to 0 and less than the string length.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        System.out.println(input.substring(num1, num2+1));
        scanner.close();
    }
}