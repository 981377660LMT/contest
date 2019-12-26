package template.string;

public class Manacher {
    /**
     * O(n)找到以i作为中心的奇数长度回文最长长度，并存储于ans[i]
     */
    public static void oddPalindrome(int[] s, int n, int[] ans) {
        int c = -1;
        int mx = -1;
        for (int i = 0; i < n; i++) {
            int len = 0;
            if (mx > i) {
                int mirror = c - (i - c);
                len = Math.min(ans[mirror] - 1, mx - i);
            }
            while (i - (len + 1) >= 0 && i + (len + 1) < n && s[i - (len + 1)] == s[i + (len + 1)]) {
                len++;
            }
            ans[i] = len + 1;
            if (mx < i + len) {
                mx = i + len;
                c = i;
            }
        }
    }

    /**
     * O(n)找到以i-1和i作为中心的奇数长度回文最长长度，并存储于ans[i]
     */
    public static void evenPalindrome(int[] s, int n, int[] ans) {
        int c = -1;
        int mx = -1;
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            int len = 0;
            if (mx >= i) {
                int mirror = c - (i - c);
                len = Math.min(ans[mirror], mx - (i - 1));
            }
            while (i - (len + 1) >= 0 && i - 1 + (len + 1) < n && s[i - (len + 1)] == s[i - 1 + (len + 1)]) {
                len++;
            }
            ans[i] = len;
            if (mx < i - 1 + len) {
                mx = i - 1 + len;
                c = i;
            }
        }
    }
}
