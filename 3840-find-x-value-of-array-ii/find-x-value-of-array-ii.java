class Solution {

    class Node {
        int[] cnt;
        int product;

        Node(int k) {
            cnt = new int[k];
            product = 1 % k;
        }
    }

    int k;
    int n;
    Node[] tree;

    Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node(k);

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

        // Prefixes containing all of left
        // and some prefix of right
        for (int r = 0; r < k; r++) {

            if (right.cnt[r] > 0) {

                int newRem =
                    (int)(((long) left.product * r) % k);

                res.cnt[newRem] += right.cnt[r];
            }
        }

        // Product of the whole segment
        res.product =
            (int)(((long) left.product * right.product) % k);

        return res;
    }

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {

            tree[node] = new Node(k);

            int rem = nums[l] % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(
        int node,
        int l,
        int r,
        int index,
        int value
    ) {

        if (l == r) {

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {

            update(
                node * 2,
                l,
                mid,
                index,
                value
            );

        } else {

            update(
                node * 2 + 1,
                mid + 1,
                r,
                index,
                value
            );
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node query(
        int node,
        int l,
        int r,
        int ql,
        int qr
    ) {

        if (r < ql || l > qr) {
            return null;
        }

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        Node left = query(
            node * 2,
            l,
            mid,
            ql,
            qr
        );

        Node right = query(
            node * 2 + 1,
            mid + 1,
            r,
            ql,
            qr
        );

        return merge(left, right);
    }

    public int[] resultArray(
        int[] nums,
        int k,
        int[][] queries
    ) {

        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            nums[index] = value;

            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            // Query nums[start ... n-1]
            Node ans = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            // Number of valid prefixes
            result[i] = ans.cnt[x];
        }

        return result;
    }
}