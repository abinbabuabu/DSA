package Arrays;

/*
Q: Find the Second largest element in an array
    Assumptions : Arrays doesn't contain negative numbers
    Time Complexity: O(n)
    Space Complexity: ?
*/

public class SecondLargest {

    public static void execute(){
        int [] inputs = SecondLargest.inputs();
        SecondLargest.logic(inputs);
    }

    public static int[] inputs(){
        int[] a = {1,2,3,4,5,6};
//        int[] a = {1,7,7,7,7,7};
//        int[] a = {7};
//          int[] a  = new int[5];
        return a;
    }


    // this works only if the array has positive numbers
    public static void logic(int[] array){
        int largest = array[0];
        int secondLargest = -1;

        for(int i=1; i<array.length; i++){
            if(array[i]>largest){
                secondLargest = largest;
                largest = array[i];
            }
        }

        if(secondLargest != -1){
            System.out.printf("Second Largest Element of the Array is %d",secondLargest);
            return;
        }
      System.out.println("Second Largest Element not found");
    }
}
