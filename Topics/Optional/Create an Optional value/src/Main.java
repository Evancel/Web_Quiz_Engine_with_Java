import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        InputStringReader reader = new InputStringReader();        
        Optional<String> value = reader.getValue();
        if (value.isPresent()) {
            System.out.println("Value is present: " + value.get());
        } else {
            System.out.println("Value is empty");
        }
    }
}

class InputStringReader {
    public Optional<String> getValue() {
        // implement
        Scanner scanner = new Scanner(System.in);
        Optional<String> input = Optional.ofNullable(scanner.nextLine());
        if(input.isPresent() && input.get().equals("empty")){
            input = Optional.empty();
        }
        scanner.close();
        return input;
    }
}