import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileConcatenator {
    public static void main(String[] args) {
        String sourceDir = "Web Quiz Engine with Java/task/src"; // Replace with your actual source directory
        String outputFile = "Web Quiz Engine with Java/task/all_classes.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            Files.walk(Paths.get(sourceDir))
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {
                        try (Stream<String> lines = Files.lines(path)) {
                            writer.write("===== File: " + path.toString() + " =====\n");
                            lines.forEach(line -> {
                                try {
                                    writer.write(line);
                                    writer.newLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            writer.write("\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println("All files have been concatenated into " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
