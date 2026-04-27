class Solution {
    public int[] findOrder(int cou, int[][] pre) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<cou;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            map.get(pre[i][1]).add(pre[i][0]);
        }
        Stack<Integer> st=new Stack();
        int vis[]=new int[cou];
        for(int i=0;i<cou;i++){
            if(vis[i]==0){
                if(dfs(map,i,st,vis)) return new int[]{};
            }
        }
        int ans[]=new int[st.size()];
        int j=0;
        System.out.println(st);
        while(!st.isEmpty()){
            ans[j++]=st.pop();
        }
        return ans;
    }
    public static boolean dfs(HashMap<Integer,ArrayList<Integer>> map,int i,Stack<Integer>st,int vis[]){
        vis[i]=1;
        for(int nbrs:map.get(i)){
            if(vis[nbrs]==0){
                if(dfs(map,nbrs,st,vis)) return true;
            }
            else if(vis[nbrs]==1){
                return true;
            }   
        }
        vis[i]=2;
        st.push(i);
        return false;
    }
   
}