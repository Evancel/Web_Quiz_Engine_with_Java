import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heightBus, numberBridges;
        int[] heightBridges;
        boolean isCrash = false;
        int indexBridge = 0;

        try{
            heightBus = scanner.nextInt();
            numberBridges = scanner.nextInt();
            scanner.nextLine();
            if(heightBus <= 0 || numberBridges <= 0){
                throw new RuntimeException("Invalid input");
            }
            heightBridges = new int[numberBridges];
            for(int i = 0; i < heightBridges.length; i++){
                heightBridges[i] = scanner.nextInt();
                if(!isCrash && heightBridges[i] <= heightBus){
                    isCrash = true;
                    indexBridge = i + 1;
                }
            }

            System.out.println(isCrash ? "Will crash on bridge " + indexBridge :
                    "Will not crash");
        } catch (RuntimeException e) {
            System.out.println("Invalid input");
        }finally {
            scanner.close();
        }
    }
}