class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) adj.add(new ArrayList<>());
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Find connected components
        int[] comp = new int[c + 1];
        int compId = 0;
        for (int i = 1; i <= c; i++) {
            if (comp[i] == 0) {
                compId++;
                dfs(i, compId, adj, comp);
            }
        }

        // Step 3: Build heaps for each component
        Map<Integer, PriorityQueue<Integer>> heaps = new HashMap<>();
        for (int i = 1; i <= compId; i++) heaps.put(i, new PriorityQueue<>());
        for (int i = 1; i <= c; i++) heaps.get(comp[i]).offer(i);

        // Step 4: Track online status
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        // Step 5: Process queries
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int grid = comp[x];

            if (type == 1) { // maintenance check
                if (online[x]) {
                    ans.add(x);
                } else {
                    PriorityQueue<Integer> pq = heaps.get(grid);
                    while (!pq.isEmpty() && !online[pq.peek()]) pq.poll();
                    ans.add(pq.isEmpty() ? -1 : pq.peek());
                }
            } else if (type == 2) { // go offline
                online[x] = false;
            }
        }

        // Step 6: Convert result list to array
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private void dfs(int node, int id, List<List<Integer>> adj, int[] comp) {
        Stack<Integer> st = new Stack<>();
        st.push(node);
        comp[node] = id;
        while (!st.isEmpty()) {
            int cur = st.pop();
            for (int nei : adj.get(cur)) {
                if (comp[nei] == 0) {
                    comp[nei] = id;
                    st.push(nei);
                }
            }
        }
    }
}