import java.io.*;

public class ReadBinaryFileAsCharacters {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file path
        String charset = "UTF-8"; // Change this to your file's charset if needed
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
