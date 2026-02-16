class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
       this.st=new Stack<>();
    }
    public int next(int price) {
        int result=1;
        while(!st.isEmpty()&&st.peek()[0]<=price){
            result+=st.pop()[1];
            
        }
        st.add(new int[]{price,result});
        return result;
    }
}