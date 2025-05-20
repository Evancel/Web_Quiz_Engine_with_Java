import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];

        try {
            for (int i = 0; i < box1.length; i++) {
                box1[i] =sc.nextInt();
                if(box1[i] <= 0){
                    throw new Exception();
                }
            }
//            sc.nextLine();

            for (int i = 0; i < box1.length; i++) {
                box2[i] =sc.nextInt();
                if(box2[i] <= 0){
                    throw new Exception();
                }
            }
//            sc.nextLine();
        }catch (Exception e){
            System.out.println("Invalid input");
            sc.close();
            return;
        }

        Arrays.sort(box1);
        Arrays.sort(box2);

        int smaller = 0;
        int bigger = 0;
        for(int i = 0; i < box1.length; i++){
            if(box1[i] < box2[i]){
                smaller++;
            }else if(box1[i] > box2[i]){
                bigger++;
            }
        }

        if(smaller == 3){
            System.out.println("Box 1 < Box 2");
        }else if(bigger == 3){
            System.out.println("Box 1 > Box 2");
        }else{
            System.out.println("Incompatible");
        }

        sc.close();
    }
}