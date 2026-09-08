class Solution {
    public int countCommas(int n) {
        int count=0;
        int temp=n;
        while(n>0){
            count++;
            n=n/10;

        }
        int c=0;
        if(count>=4){
            for(int i=temp;i>=1000;i--){
                c++;
            }
            return c;
        }
        return 0;
    }
}