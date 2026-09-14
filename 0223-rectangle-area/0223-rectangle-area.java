class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1=Math.abs(ax2-ax1)*Math.abs(ay2-ay1);
        int area2=Math.abs(bx2-bx1)*Math.abs(by2-by1);
        int Area=area1+area2;
        int overlapWidth=Math.min(ax2,bx2)-Math.max(ax1,bx1);
        int overlapHeight=Math.min(ay2,by2)-Math.max(ay1,by1);

        int overlapArea=0;
        if(overlapHeight>0 && overlapWidth>0){
            overlapArea=overlapHeight* overlapWidth;
        }
        else overlapArea=0;
        return Area-overlapArea;
    }
}