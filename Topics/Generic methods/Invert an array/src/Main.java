// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T[] invert(T[] array){
        for(int i = 0; i < array.length / 2; i++){
            T temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
/*
    public static void main(String[] args) {
        Integer[] array = new Integer[]{10,6,2,3};
        Integer[] invertArray = invert(array);
        for(Integer item : invertArray){
            System.out.print(item + " ");
        }
    }

 */
}