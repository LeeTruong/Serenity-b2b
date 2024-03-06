package utils;

public class Utils {

    public static String generateRandomChars( int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt((int) (Math.random() * candidateChars.length())));
        }
        return sb.toString();
    }
}
