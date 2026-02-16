class Pair{
    int count,availableTime;
    Pair(int count, int availableTime)
    {
        this.count = count;
        this.availableTime = availableTime;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        int[] countArray = new int[26];
        for(char character : tasks)
            countArray[character-65]++;
        for(int count : countArray)
        {
            if(count !=0)
            maxHeap.add(count);
        }
        while(!maxHeap.isEmpty() || !queue.isEmpty())
        {
            time++;
            if(!maxHeap.isEmpty())
            {
                int count = maxHeap.poll();
                if(count > 1)
                    queue.offer(new Pair(count-1,time+n));
            }
            if(!queue.isEmpty() && queue.peek().availableTime == time)
            {
                Pair p = queue.poll();
                maxHeap.add(p.count);
            }
        }        
        return time;
    }
}