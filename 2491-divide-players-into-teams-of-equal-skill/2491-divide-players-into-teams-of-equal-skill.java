class Solution {
    public long dividePlayers(int[] skill) {
        int n=skill.length;
        Arrays.sort(skill);
        long sum=0;
        int i=0;
        int j=n-1;
        int first=skill[i]+skill[j];
        sum+=skill[i++]*skill[j--];
        while(i<j){
            int pair=skill[i]+skill[j];
            if(pair!=first)return -1;
            sum+=skill[i++]*skill[j--];
        }
        return sum;
    }
}