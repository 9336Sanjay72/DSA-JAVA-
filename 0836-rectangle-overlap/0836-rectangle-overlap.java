class Solution {
    public boolean isRectangleOverlap(int[] a, int[] b) {
        
        if(a[2]>b[0] && a[3]>b[1] && b[3]>a[1] && b[2]>a[0]  )return true;
        return false;
    }
}