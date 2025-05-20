import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        while(scanner.hasNextLine()){
            String input = scanner.nextLine();
            if(input.matches(".*[a-z].*")){
                System.out.println(input.toUpperCase());
            }else{
                System.out.println("FINISHED");
                break;
            }
        }
    }
}

//class Main{
//    public static void main(String[] args) {
//        Thread t = new StringProcessor();
//        t.start();
//    }
//}