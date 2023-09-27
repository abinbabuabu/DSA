package Arrays;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/description/

public class RotateImage {
    public static void execute(){
      logic(inputs());
    }

    public static int[][] inputs(){
       return new int[][]{{1,2,3},
                          {4,5,6},
                          {7,8,9}};
    }

    public static void logic(int [][] matrix){
        transpose(matrix);
        reverse(matrix);
        printArray(matrix);
    }

    public static void printArray(int [][] matrix){
        for(int i = 0; i< matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void transpose(int [][] matrix){
        for(int i=0; i< matrix.length; i++){
            for(int j= i; j< matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;

            }
        }
    }

    public static void reverse(int[] [] matrix){
        for(int i = 0 ;i<matrix.length; i++){
            for(int j = 0; j <matrix.length/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length -1-j] = temp;
            }
        }
    }
}
