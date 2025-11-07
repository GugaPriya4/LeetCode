class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];

        // Step 1️⃣: Compute initial power for each city using sliding window
        long windowSum = 0;
        for (int i = 0; i <= Math.min(n - 1, r); i++) {
            windowSum += stations[i];
        }
        power[0] = windowSum;

        for (int i = 1; i < n; i++) {
            if (i - r - 1 >= 0) windowSum -= stations[i - r - 1]; // remove left-out city
            if (i + r < n) windowSum += stations[i + r];           // add right-in city
            power[i] = windowSum;
        }

        // Step 2️⃣: Binary search to find max possible minimum power
        long low = 0;
        long total = 0;
        for (int s : stations) total += s;
        long high = total + k;  // upper bound
        long ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;         // possible, try higher
                low = mid + 1;
            } else {
                high = mid - 1;    // not possible, try lower
            }
        }

        return ans;
    }

    // Step 3️⃣: Helper to check if we can make every city's power >= target
    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1]; // for range update tracking
        long active = 0;               // current extra stations effect
        long remain = k;
        int window = 2 * r + 1;

        for (int i = 0; i < n; i++) {
            active += diff[i];  // apply expired effects
            long currPower = power[i] + active;

            if (currPower < target) {
                long need = target - currPower;
                if (need > remain) return false;  // not enough stations
                remain -= need;
                active += need;                   // new stations affect current and next r cities
                if (i + window < diff.length) {
                    diff[i + window] -= need;     // expire effect after range
                }
            }
        }
        return true;
    }}