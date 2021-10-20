import java.util.*;
import java.lang. *;

public class Task1{
    public static void main(String[] args){
        int[] array = {3, 4, 2, 3};

        //System.out.println(func(array));
        //System.out.println(maxNum(array));
        diag();
    }
    //первое задание
    static int func(int[] arr){
        int p = 0;

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(j != i){
                    for(int k = j + 1; k < i; k++){
                        if(k != i){
                            if(arr[i] < arr[k] + arr[j] && arr[j] < arr[k] + arr[i] && arr[k] < arr[i] + arr[j] && arr[i] + arr[k] + arr[j] > p){
                                p = arr[i] + arr[k] + arr[j];
                            }
                        }
                    }
                }

            }
        }

        return p;
    }
    //второе задание
    static String maxNum(int[] array){
        String result = "";
        selection1(array);

        for(int i = 0; i < array.length; i++)
            result += array[i];
        return result;
    }
    static int[] selection1(int matrix[]){

        for(int j = 0; j < matrix.length; j++){
            int n = j;

            for(int k = j + 1; k < matrix.length; k++){
                if(func(matrix[k], matrix[n])){
                    n = k;
                }
            }
            matrix[n] = swap(matrix[j], matrix[j] = matrix[n]);

        }
        return matrix;
    }

    static boolean func(int a, int b){
        String a1 = "" + a;
        String b1 = "" + b;
        String c = a1 + b1;
        a1 = b1 + a1;
        if(Integer.parseInt(c) > Integer.parseInt(a1))
            return true;
        else
            return false;
    }

    static int swap(int b, int a){
        return b;
    }

    //третье задание
    static void diag(){
        int[][] arr = new int[5][5];
        Random rand = new Random();

        //генерируем матрицу
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = rand.nextInt(10);
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for(int i = 1; i < arr.length; i++){
            arr = selection2(arr, i, 0);
        }
        for(int i = 1; i < arr[0].length; i++){
            arr = selection2(arr, 0, i);
        }
        arr = selection2(arr, 0, 0);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
    static int[][] selection2(int matrix[][], int x, int y){

        for(int i = x, j = y; i < matrix.length && j < matrix[0].length; j++, i++){

            for(int k = i + 1, l = j + 1; k < matrix.length && l < matrix[0].length; k++, l++){
                if(matrix[k][l] < matrix[i][j]){
                    matrix[i][j] = swap(matrix[k][l], matrix[k][l] = matrix[i][j]);
                }
            }

        }
        return matrix;
    }

}
