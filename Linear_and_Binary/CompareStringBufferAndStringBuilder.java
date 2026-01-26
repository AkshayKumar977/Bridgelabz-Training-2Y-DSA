public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int n = 1_000_000;
        String text = "hello";

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbBuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long durationBuffer = endBuffer - startBuffer;

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbBuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long durationBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");
    }
}
