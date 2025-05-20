import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        List<String> stringList = new ArrayList<>(List.of(array));
        ListIterator<String> iterator = stringList.listIterator();
        while(iterator.hasNext()){
            String curr = iterator.next();
            if(!curr.matches("J.*")){
                iterator.remove();
            }else{
                iterator.set(curr.substring(1));
            }
        }

        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}