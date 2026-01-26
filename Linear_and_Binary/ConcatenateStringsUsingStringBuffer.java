public class ConcatenateStringsUsingStringBuffer {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", "!"};
        String result = concatenate(arr);
        System.out.println("Concatenated string: " + result);
    }
}
