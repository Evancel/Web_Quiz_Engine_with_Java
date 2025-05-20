import java.util.*;

public class Main {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static void main(String[] args) {
        int[] input = readInput();
        if (input == null) return;

        String password = generatePassword(input);
        System.out.println(password);
    }

    private static int[] readInput() {
        Scanner sc = new Scanner(System.in);
        try {
            int upper = sc.nextInt();
            int lower = sc.nextInt();
            int digits = sc.nextInt();
            int totalLength = sc.nextInt();

            if (upper < 0 || lower < 0 || digits < 0 || totalLength <= 0 ||
                    (upper + lower + digits > totalLength)) {
                throw new IllegalArgumentException();
            }

            return new int[]{upper, lower, digits, totalLength};
        } catch (Exception e) {
            System.out.println("Invalid input");
            return null;
        } finally {
            sc.close();
        }
    }

    private static String generatePassword(int[] input) {
        final int upperCount = input[0];
        final int lowerCount = input[1];
        final int digitCount = input[2];
        final int totalLength = input[3];

        List<Character> characters = new ArrayList<>();


        addRandomChars(characters, UPPERCASE, upperCount);
        addRandomChars(characters, LOWERCASE, lowerCount);
        addRandomChars(characters, DIGITS, digitCount);

        int remaining = totalLength - characters.size();
        String allChars = UPPERCASE + LOWERCASE + DIGITS;
        addRandomChars(characters, allChars, remaining);

        // Shuffle until no consecutive duplicates
        do {
            Collections.shuffle(characters);
        } while (!isValidPassword(characters));

        return toString(characters);
    }

    private static void addRandomChars(List<Character> list, String source, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(source.charAt(random.nextInt(source.length())));
        }
    }

    private static boolean isValidPassword(List<Character> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static String toString(List<Character> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
