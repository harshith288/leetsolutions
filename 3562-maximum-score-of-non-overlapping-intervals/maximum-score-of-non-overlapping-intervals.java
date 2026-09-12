class Solution {

    record State(long weight, List<Integer> indices) {}

    public int[] maximumWeight(List<List<Integer>> intervals) {

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            List<Integer> x = intervals.get(i);

            // l, r, weight, original index
            arr.add(new int[]{
                x.get(0), x.get(1), x.get(2), i
            });
        }

        // Sort by starting point
        arr.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        State[][] dp = new State[arr.size()][5];

        State ans = solve(arr, 0, 4, dp);

        return ans.indices.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private State solve(
            List<int[]> arr,
            int i,
            int k,
            State[][] dp) {

        if (i == arr.size() || k == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // OPTION 1: Don't take current interval
        State skip = solve(arr, i + 1, k, dp);

        // OPTION 2: Take current interval
        int[] cur = arr.get(i);

        int right = cur[1];
        int weight = cur[2];
        int originalIndex = cur[3];

        // First interval whose start > current right
        int next = findNext(arr, i + 1, right);

        State nextState = solve(arr, next, k - 1, dp);

        List<Integer> selected = new ArrayList<>();
        selected.add(originalIndex);
        selected.addAll(nextState.indices);

        // Lexicographical comparison needs sorted indices
        Collections.sort(selected);

        State take = new State(
                weight + nextState.weight,
                selected
        );

        // Choose better option
        State result;

        if (take.weight > skip.weight) {
            result = take;
        }
        else if (take.weight < skip.weight) {
            result = skip;
        }
        else {
            // Same weight → lexicographically smaller
            if (compare(take.indices, skip.indices) < 0)
                result = take;
            else
                result = skip;
        }

        dp[i][k] = result;

        return result;
    }

    // First interval with start > right
    private int findNext(
            List<int[]> arr,
            int start,
            int right) {

        int lo = start;
        int hi = arr.size();

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr.get(mid)[0] > right) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    // Lexicographical comparison
    private int compare(
            List<Integer> a,
            List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}