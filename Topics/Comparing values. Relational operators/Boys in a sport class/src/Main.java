import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        boolean isAscArray = true;
        boolean isDescArray = true;
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int i = 1; i < arr.length; i++) {
                if (isAscArray && arr[i - 1] > arr[i]) {
                    isAscArray = false;
                    break;
                }
            }

            for (int i = 1; i < arr.length; i++) {
                if (isDescArray && arr[i - 1] < arr[i]) {
                    isDescArray = false;
                    break;
                }
            }

            System.out.println(isAscArray || isDescArray);
        } catch (RuntimeException e) {
            System.out.println("Invalid input");
        } finally {
            scanner.close();
        }
    }
}