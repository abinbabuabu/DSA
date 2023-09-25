package Arrays;



// LeetCode: Medium
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FindLastAndFirstPositionOfElementInSortedArray {


    public static void execute(){
        Input input = inputs();
        logic(input.num, input.target);
    }

    private static Input inputs(){
        Input input = new Input();
//        input.num = new int[]{5, 7, 7, 8, 8, 10}; // [3,4]
//        input.target = 8;

//        input.num = new int[]{5,7,7,8,8,10}; // [-1,-1]
//        input.target = 6;

         input.num = new int[]{}; // [-1,-1]
         input.target = 0;

        return input;
    }

    private static int[] logic(int[] num , int target){
        int startIndex = -1;
        int endIndex = -1;
        for(int i=0; i< num.length; i++){
            if(num[i]> target){
                break;
            }
            if(num[i] == target){
                if(startIndex == -1){
                    startIndex = i;
                    endIndex = i;
                } else {
                    endIndex = i;
                }
            }
        }
        System.out.printf("[ %d, %d ]",startIndex, endIndex);
        return new int[]{startIndex, endIndex};
    }


    record Input() {
        static int target;
        static int[] num;
    }

}
