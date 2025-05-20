import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            } else if (num % 2 == 0) {
                System.out.println("even");
            } else if (num % 2 == 1) {
                System.out.println("odd");
            } else {
                System.out.println("unknown error");
            }
        }
        scanner.close();
    }
}
