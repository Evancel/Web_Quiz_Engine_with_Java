// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> String info(T[] array){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if(i < array.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
/*
    public static void main(String[] args) {
        Integer[] array = new Integer[]{8,11,3,7};
        System.out.println(info(array));
    }

 */
}