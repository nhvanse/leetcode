import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Med3LongestSubStringWithoutRepeatingCharacters {
    public static final String quitString = "q!";

    public static void main(String[] args) {
        Med3LongestSubStringWithoutRepeatingCharacters clazz = new Med3LongestSubStringWithoutRepeatingCharacters();
        Scanner scanner = new Scanner(System.in);
        String s;
        while (true) {
            System.out.print("Input string: ");
            s = scanner.nextLine();
            if (s.equals(quitString)) {
                System.out.printf("Exited");
                return;
            }
            int result = clazz.lengthOfLongestSubstring(s);
            System.out.println("Result: " + result);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet();
        int l = s.length();
        int left = 0, right = 0;
        int result = 0;
        while (right < l) {
            char rightChar = s.charAt(right);
            if (!charSet.contains(rightChar)) {
                charSet.add(rightChar);
                if (result < right - left + 1) {
                    result = right - left + 1;
                }
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }

        return result;
    }
}