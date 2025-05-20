import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<Integer>() {
            int temp = 0;
            @Override
            public Integer get() {
                return temp++;
            }
        };
    }

    public static void main(String[] args) {
        Supplier<Integer> sup = getInfiniteRange();
        for(int i = 0; i < 5; i++) {
            System.out.print(sup.get() + " ");
        }
    }
}