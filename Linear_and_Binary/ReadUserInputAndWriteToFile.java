import java.io.*;

public class ReadUserInputAndWriteToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Change this to your desired output file
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {
            String input;
            System.out.println("Enter text (type 'exit' to finish):");
            while (true) {
                input = br.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(input + System.lineSeparator());
            }
            System.out.println("Input saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
