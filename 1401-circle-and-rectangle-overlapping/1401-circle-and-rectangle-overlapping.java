class Solution {
    public boolean checkOverlap(int radius,int c1,int c2, int x1, int y1, int x2, int y2) {
       int Xi=0;
       int Yi=0;
       if(x1>c1)Xi=x1;// if rectangle is on left direction
       else if(x2<c1)Xi=x2; // if rectangle is on right direction
       else Xi=c1;// it means x1> c1 and c1 > x2 it means lie in centre 

       if(y1>c2)Yi=y1;// if rectangle is on left direction
       else if(y2<c2)Yi=y2; // if rectangle is on right direction
       else Yi=c2;
       
       double dist=Math.sqrt(Math.pow((Xi-c1),2)+Math.pow((Yi-c2),2));
       if(dist <= (double)radius)return true;
       return false;
    }
}