import java.util.HashSet;
import java.util.Set;

public class Ez1876SubStringWithDistinctCharacter {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings1("aababcabc"));
    }

    public static int countGoodSubstrings1(String s) {
        int l = s.length();
        if (l < 3) return 0;
        int count = 0;

        for (int i = 0; i < l - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1)
                    && s.charAt(i + 1) != s.charAt(i + 2)
                    && s.charAt(i) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }

    public static int countGoodSubstrings2(String s) {
        int l = s.length();
        if (l < 3) return 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        set.add(s.charAt(1));

        for (int i = 2; i < l; i++) {
            if (set.size() == 2 && !set.contains(s.charAt(i))) {
                count++;
            }
            if (set.size() == 2) set.remove(s.charAt(i - 2));
            set.add(s.charAt(i));
        }
        return count;
    }


}
