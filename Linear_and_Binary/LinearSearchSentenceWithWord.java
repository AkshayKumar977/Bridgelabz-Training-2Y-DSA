public class LinearSearchSentenceWithWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox.",
            "Hello world!",
            "Java is powerful.",
            "Welcome to coding."
        };
        String word = "Java";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
