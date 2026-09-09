class Solution {
    public List<List<String>>  result=new ArrayList<>();
    public List<String> build(int n,List<Integer> list){
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            char[]arr=new char[n];
            Arrays.fill(arr,'.');
            arr[list.get(i)]='Q';
            board.add(new String(arr));
        }
        return board;
    }
    public boolean isValid(int row,int col,List<Integer> list){
        // check for previous col
        for(int prevRow=0;prevRow<list.size();prevRow++){
            int prevCol=list.get(prevRow);
            if(prevCol==col)return false;
            if(Math.abs(prevCol-col)==Math.abs(prevRow-row))return false;
        }
        return true;
    }
    public void solve(int n,int row,List<Integer> temp){
        if(row==n){
            result.add(build(n,temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,temp)){
                temp.add(col);
                solve(n,row+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        solve(n,0,new ArrayList<>());// for 0th row
        return result;
    }
}