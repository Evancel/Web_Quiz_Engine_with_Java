import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int maxLimit = 1000;
        boolean isZero = false;
        while (scanner.hasNextLine()) {
//            System.out.println("sum = " + sum + ", isZero = " + isZero);
            try {
                int num = Integer.parseInt(scanner.nextLine());

                if(!isZero && sum < maxLimit){
//                    System.out.println("if");
                    sum += num;
                }

                if(num == 0){
                    isZero = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException");
            }
        }

        if(sum >= maxLimit){
            sum -= maxLimit;
        }

        System.out.println(sum);
        scanner.close();
    }
}