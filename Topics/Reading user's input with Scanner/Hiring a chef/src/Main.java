import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String cuisine = sc.nextLine();
        int experience = 0;

        try{
            experience = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            sc.close();
            return;
        }

        System.out.printf("The form for %s is completed. " +
                "We will contact you if we need a chef who cooks %s dishes " +
                "and has %d years of experience.\n", name, cuisine, experience);

        sc.close();
    }
}