import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine().replaceAll(" ","");
        String secondLine = scanner.nextLine().replaceAll(" ","");
        System.out.println(firstLine.equals(secondLine));

        scanner.close();
    }
}