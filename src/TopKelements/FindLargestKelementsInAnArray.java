package TopKelements;

import java.util.*;

//https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/

public class FindLargestKelementsInAnArray {

    public static void execute(){
      logic(new int[]{3,2,1,5,6,4},2);
    }

    public static void logic(int [] array, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // Min Heap
        // If largest Element Use Min Heap
        // If Smallest Element use Max Heap
//         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        for(int v: array){
            if(queue.size() > k){
             queue.poll();
            }
            queue.add(v);
        }
        while(queue.size() > k){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
