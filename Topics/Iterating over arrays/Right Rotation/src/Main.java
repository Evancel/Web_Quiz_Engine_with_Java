import java.util.Arrays;
import java.util.Scanner;

class Main {
    // implement me
//    1 2 3 4 5
    private static void rotate(int[] arr, int steps) {
        steps = steps % arr.length;
        int[] tmp = new int[arr.length];
        if (steps == 0) return;

        //src, startPos src, target, startPos target, length
        System.arraycopy(arr, arr.length - steps, tmp, 0, steps); //copy right items
        System.arraycopy(arr, 0, tmp, steps, arr.length - steps); //copy left items
        System.arraycopy(tmp, 0, arr, 0, arr.length);  //copy tmp to arr
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}