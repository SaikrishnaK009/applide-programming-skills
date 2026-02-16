class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        

        int noOfSecond = duration;

        for (int i=1; i<timeSeries.length; i++) {

            noOfSecond += duration;

            int attacksTime = timeSeries[i] - timeSeries[i-1];

            if (attacksTime <= duration) {
                int diff = duration - attacksTime;
                noOfSecond -= diff;
            }
        }
        return noOfSecond;
    }
}