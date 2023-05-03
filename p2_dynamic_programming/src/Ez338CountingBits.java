public class Ez338CountingBits {
    public int[] countBits(int n) {
        // f(n) = f(n / 2) + n%2
        int[] arr = new int[n + 1]; // initial all values are 0
        for (int i = 0; i <= n; i++) {
            arr[i] = arr[i / 2] + i % 2;
        }
        return arr;
    }
}