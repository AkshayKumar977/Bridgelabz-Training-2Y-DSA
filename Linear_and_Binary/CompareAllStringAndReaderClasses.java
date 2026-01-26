import java.io.*;

public class CompareAllStringAndReaderClasses {
    public static void main(String[] args) {
        // Part 1: StringBuilder and StringBuffer Concatenation
        int n = 1_000_000;
        String text = "hello";

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbBuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long durationBuilder = endBuilder - startBuilder;

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbBuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long durationBuffer = endBuffer - startBuffer;

        System.out.println("StringBuilder time: " + durationBuilder / 1_000_000 + " ms");
        System.out.println("StringBuffer time: " + durationBuffer / 1_000_000 + " ms");

        // Part 2: FileReader and InputStreamReader Word Count
        String filePath = "largefile.txt"; // Change to your large file path
        String charset = "UTF-8";
        int wordCountFileReader = 0;
        int wordCountInputStreamReader = 0;

        // FileReader
        long startFileReader = System.nanoTime();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountFileReader += words.length;
            }
        } catch (IOException e) {
            System.out.println("FileReader error: " + e.getMessage());
        }
        long endFileReader = System.nanoTime();
        long durationFileReader = endFileReader - startFileReader;

        // InputStreamReader
        long startInputStreamReader = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountInputStreamReader += words.length;
            }
        } catch (IOException e) {
            System.out.println("InputStreamReader error: " + e.getMessage());
        }
        long endInputStreamReader = System.nanoTime();
        long durationInputStreamReader = endInputStreamReader - startInputStreamReader;

        System.out.println("FileReader word count: " + wordCountFileReader + ", time: " + durationFileReader / 1_000_000 + " ms");
        System.out.println("InputStreamReader word count: " + wordCountInputStreamReader + ", time: " + durationInputStreamReader / 1_000_000 + " ms");
    }
}
