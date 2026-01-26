import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrencesInFile {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file path
        String targetWord = "example"; // Change this to the word you want to count
        int count = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}
