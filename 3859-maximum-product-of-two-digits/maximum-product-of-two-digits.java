class Solution {
    public static int maxProduct(int n) {
        int maxp;
        int product=0;
        List<Integer> list=new ArrayList<>();
        while(n>0){
            list.add(n%10);
            n=n/10;
        }
        for(int i=0;i<list.size();i++){
              for(int j=i+1;j<list.size();j++){
                maxp=list.get(i)*list.get(j);
                product=Math.max(maxp,product);
              }
        }
        return product;
    }
}