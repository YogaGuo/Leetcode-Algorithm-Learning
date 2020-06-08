package cn.yogaguo.Array;
/**
 * 有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数，请设计出一个名为 MedianHolder 的结构，
 *  MedianHolder 可以随时取出之前吐出的所有数据的中位数。
 *  要求：任意时刻将一个新数加入到 MedianHolder 的过程，时间复杂度为O(logN)，取得中位数的时间复杂度O(1).
 *  。
 *  。
 *  注意：本题解法不完美，题中要求 "有足够的空间来",但是优先队列都使用的是固定数组。。
 */
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MadianQuick {
    public static class MedianHolder{
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinComparator());
    	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxComparator());
    	public void modifyHeapSize() {
    		if(this.maxHeap.size() == this.minHeap.size()+2) {
                  minHeap.add(maxHeap.poll());
    		}
    		if(this.minHeap.size() == this.maxHeap.size()+2) {
    			maxHeap.add(minHeap.poll());
    		}
    	}
    	public void addNumber(int num) {
    		if(this.maxHeap.isEmpty()) {
    			maxHeap.add(num);
    			return;
    		}if(this.maxHeap.peek() >= num) {
				maxHeap.add(num);
			}else {
				if(minHeap.isEmpty()) {
					minHeap.add(num);
					return;
				}
				if(this.minHeap.peek() >= num) {
					maxHeap.add(num);
				}else {
					minHeap.add(num);
				}
			}
    		modifyHeapSize();
    	}
    	public  Integer getMedian() {
    		int minSize = this.minHeap.size();
    		int maxSize = this.maxHeap.size();
    		if(minSize + maxSize == 0) {
    			return null;
    		}
    		Integer minHeap = this.minHeap.peek();
    		Integer maxHeap = this.maxHeap.peek();
    		if(((minSize + maxSize) & 1) == 0) {
    			return ((minHeap + maxHeap) /2);
    		}else {
    			return minSize > maxSize ? minHeap : maxHeap;
    		}
    	}
    }
    public static class  MinComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			   if(o1 < o2) {
				   return -1;
			   }else {
				   return 1;
			   }
		}
    }
    public static class MaxComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			 if(o1 > o2) {
				 return -1;
			 }else {
				 return 1;
			 }
		}
    	
    }
    public static void main(String[] args) {
		int[] a = {2,4,1,7,9,3,5,0};
		MedianHolder holder = new MedianHolder();
		for(int i =0;i < a.length;i++) {
			 holder.addNumber(i);
		}
		int res=holder.getMedian();
		System.out.println(res);
	}
}
