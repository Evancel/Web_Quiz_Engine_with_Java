import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // implement this method
        for (int i = 0; scanner.hasNextLine(); i++) {
            int num = Integer.parseInt(scanner.nextLine().trim());
            if (num == 0) {
                break;
            } else if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}