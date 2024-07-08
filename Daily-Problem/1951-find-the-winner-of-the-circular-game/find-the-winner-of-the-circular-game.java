class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.offer(i);
        }
        int count = 1;
        while(q.size() != 1){
            if(count == k){
                q.poll();
                count = 1;
            }else{
                q.offer(q.poll());
                count++;
            }
        }
        return q.poll();
    }
}