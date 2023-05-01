import java.util.HashSet;
import java.util.Set;

public class Ez129ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        final int len = nums.length;
        if (len < 2) return false;
        final Set<Integer> windowSet = new HashSet<>();
        for (int i = 0; i <= k && i < len; i++) {
            if (windowSet.contains(nums[i])) return true;
            windowSet.add(nums[i]);
        }

        for (int i = 1; i < len - k; i++) {
            windowSet.remove(nums[i - 1]);
            if (windowSet.contains(nums[i + k])) return true;
            windowSet.add(nums[i + k]);
        }
        return false;
    }
}

