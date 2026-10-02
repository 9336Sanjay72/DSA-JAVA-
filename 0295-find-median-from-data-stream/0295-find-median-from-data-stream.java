class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
         min=new PriorityQueue<>();
         max=new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(max.size()==0){
              max.add(num);
              return;
            }

        if(max.peek()>=num){// agar element chhota toh max heap mai add nahi toh min heap 
            max.add(num);
        }
        else min.add(num);

        if(max.size()>min.size()+1){
                min.add(max.poll());
          }
         else if(min.size()>max.size()){
                max.add(min.poll());
         }
        
    }
    
    public double findMedian() {
        if(min.size()==max.size())return( min.peek()+max.peek())/2.0;
        return max.peek()*1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */