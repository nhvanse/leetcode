public class Med1343SubArraySizeKHasAverageGreaterThanThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = arr.length;
        if (l < k) return 0;
        int sum = 0;
        int count = 0;
        int sumThreshold = k * threshold;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= sumThreshold) count++;

        for (int i = k; i < l; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            if (sum >= sumThreshold) count++;
        }
        
        return count;
    }
}
