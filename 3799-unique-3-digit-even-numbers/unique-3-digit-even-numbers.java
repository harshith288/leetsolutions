class Solution {
    public int totalNumbers(int[] digits) {
        int[] f = new int[10];

        for (int d : digits) {
            f[d]++;
        }

        int ans = 0;
        for (int last = 0; last <= 8; last += 2) {
            if (f[last] == 0) continue;

            f[last]--;
            for (int first = 1; first <= 9; first++) {
                if (f[first] == 0) continue;

                f[first]--;
                for (int middle = 0; middle <= 9; middle++) {
                    if (f[middle] > 0) {
                        ans++;
                    }
                }
                f[first]++;
            }

            f[last]++;
        }

        return ans;
    }
}