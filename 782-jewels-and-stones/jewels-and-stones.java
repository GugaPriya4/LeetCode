class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n1=jewels.length();
        int n2=stones.length();
        int count=0;
        int n=Math.max(n1,n2);
        for(int i=0;i<n2;i++){
            for(int j=0;j<n1;j++){
                            if(jewels.charAt(j)==stones.charAt(i)){
                count++;
            }
        }}
        return count;
    }
    }