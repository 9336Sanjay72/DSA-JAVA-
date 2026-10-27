class Solution {
    public String[] createGrid(int m, int n) {
        char[][]grid=new char[m][n];
        for(char[]arr:grid){
            Arrays.fill(arr,'#');
        }
        for(int i=0;i<m;i++){
            grid[i][0]='.';
        }
        for(int j=0;j<n;j++){
            grid[m-1][j]='.';
        }
        String[]result=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++ ){
                sb.append(grid[i][j]);
            }
            result[i]=sb.toString();
        }
        return result;
    }
}