import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input = sc.nextLine().trim();
        int count = 1;
        int output = 0;

        boolean isPrevVowel = isVowel(input.charAt(0));
        for(int i = 1; i < input.length(); i++){
            boolean isCurrVowel = isVowel(input.charAt(i));

            if(isPrevVowel == isCurrVowel){
                count++;
                if(count == 3){
                    output++;
                    count = 1; // reset after hypothetical insertion
                }
            }else{
                count = 1;
                isPrevVowel = isCurrVowel;
            }
        }
        System.out.println(output);
        sc.close();
    }

    private static boolean isVowel(char s){
        return "aeiouy".indexOf(s) != -1;
    }
}