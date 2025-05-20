import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value

        int numberCup = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();

        scanner.close();

        boolean notWeekend = !isWeekend && (numberCup >= 10 && numberCup <= 20);
        boolean weekend = isWeekend && (numberCup >= 15 && numberCup <= 25);

        System.out.println(notWeekend || weekend);
    }
}
