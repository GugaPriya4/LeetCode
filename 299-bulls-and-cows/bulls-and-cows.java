class Solution {
    public String getHint(String secret, String guess) {
    int cows=0,bulls=0;
    int[] scount=new int[10];
    int[] gcount=new int[10];
    for(int i=0;i<secret.length();i++){
        char s=secret.charAt(i);
        char g=guess.charAt(i);
        if(s==g){
            bulls++;
        }
        else{
            scount[s-'0']++;
            gcount[g-'0']++; // the thing why we minus 0 from g is it is character it has its ascii code which is 48 for 0. if we subtract 48 from the c it gives the value in integer which can be stored as index.
        }}
        for (int d=0;d<10;d++){
            cows+=Math.min(scount[d],gcount[d]);
        }
        

    
    return bulls+"A"+cows+"B";
}}