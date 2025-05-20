/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = sc.nextLine().trim().split(" ");
        int givenInteger;
        int[] nums = new int[input.length];
        List<Integer> numsToOutput = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        try {
            givenInteger = Integer.parseInt(sc.nextLine().trim());

            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(input[i]);

                int difference = Math.abs(givenInteger - nums[i]);
                if (min > difference) {
                    numsToOutput.clear();
                    min = difference;
                    numsToOutput.add(nums[i]);
                } else if (min == difference) {
                    numsToOutput.add(nums[i]);
                }
            }
            numsToOutput.sort(Integer::compareTo);
            for (Integer item : numsToOutput) {
                System.out.print(item + " ");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } finally {
            sc.close();
        }
    }
}
 */


class MainClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}

class MyThread implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}