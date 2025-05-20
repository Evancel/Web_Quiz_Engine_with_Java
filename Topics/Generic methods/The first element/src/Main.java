// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define getFirst method here
    public static <T> T getFirst(T[] array){
        return array.length == 0 ? null : array[0];
    }
/*
    public static void main(String[] args) {
//        Integer[] array = new Integer[]{10, 6, 2, 3};
        Integer[] array = new Integer[0];
        System.out.println(getFirst(array));
    }

 */
}