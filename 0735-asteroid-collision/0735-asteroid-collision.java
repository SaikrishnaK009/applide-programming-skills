class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) return asteroids;

        List<Integer> survivedNegative = new ArrayList<>();
        int i = 0; // arr[0: i - 1]: still flying positive

        for (int j = 0; j < asteroids.length; j++) {
            // case 1
            if (asteroids[j] >= 0) {
                asteroids[i++] = asteroids[j];
            }

            // case 2
            else {
                boolean didSurvive = true; // whether arr[j] will survive
                
                while (i >= 1) { // has a flying positive to its left
                    // case 2.1: positive is smaller
                    if (asteroids[i - 1] < Math.abs(asteroids[j])) i--;

                    // case 2.2: equivalently large
                    else if (asteroids[i - 1] == Math.abs(asteroids[j])) {
                        i--;
                        didSurvive = false;
                        break;
                    }

                    // case 2.3: positive is larger
                    else {
                        didSurvive = false;
                        break;
                    }
                }

                if (didSurvive) survivedNegative.add(asteroids[j]);
            }
        }

        // construct result
        int[] result = new int[survivedNegative.size() + i];
        int index = 0;

        // fill all survived negative
        for (int negative: survivedNegative)
            result[index++] = negative;

        // fill all survived positive: arr[0: i - 1]
        for (int k = 0; k < i; k++)
            result[index++] = asteroids[k];

        return result;
    }
}