package trainee;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class trainee {
//    static int layer = 0;
//    public static void matrixRotation(List<List<Integer>> matrix, int r) {
//        Rotate(matrix.size(),matrix.get(0).size(),matrix,r);
//        for (int i = 0; i< matrix.size();i++){
//            for (int j = 0 ; j<matrix.get(0).size();j++){
//                if (j==(matrix.size()-1)){
//                    System.out.println(matrix.get(i).get(j));
//                }
//                else {
//                    System.out.print(matrix.get(i).get(j) + " ");
//                }
//
//            }
//        }
//    }
//
//    public static void Rotate(int h, int w, List<List<Integer>> matrix, int r){  //width and height
//        // width height
//        Queue<Integer> temp = new LinkedList<Integer>();     //shifting and replacing back into real matrix
//
//        for(int i = layer; i < w-1-layer; i++){
//            temp.add(matrix.get(layer).get(i));
//        }
//
//        for(int i = layer; i < h-1-layer; i++){
//            temp.add(matrix.get(i).get(w - 1 - layer));
//        }
//
//        for(int i = w-1-layer; i > layer; i--){
//            temp.add(matrix.get(h - 1 - layer).get(i));
//        }
//
//        for(int i = h-1-layer; i > layer; i--){
//            temp.add(matrix.get(i).get(layer));
//        }
//
//        int numberRotate = r;
//
//        if((2*(h-layer*2) + 2*(w-layer*2) - 4) > 0){
//            numberRotate = r%(2*(h-layer*2) + 2*(w-layer*2) - 4);
//        }
//
//        //doing the shifting
//        int t;
//        for(int i = 0; i < numberRotate; i++){
//            t = temp.poll();
//            temp.add(t);
//        }
//
//        //putting black into matrix
//
//        for(int i = layer; i < w-1-layer; i++){                 //putting queue contents back into the matrix
//            matrix.get(layer).set(i, temp.poll());
//        }
//        for(int i = layer; i < h-1-layer; i++){
//            matrix.get(i).set(w - 1 - layer, temp.poll());
//        }
//        for(int i = w-1-layer; i > layer; i--){
//            matrix.get(h - 1 - layer).set(i, temp.poll());
//        }
//        for(int i = h-1-layer; i > layer; i--){
//            matrix.get(i).set(layer, temp.poll());
//        }
//
//        //inner layers
//
//        if(layer < w/2-1 && layer < h/2-1){  //if there are more layers to be rotated, recursive call
//            layer++;
//            Rotate(h,w, matrix, r);
//        }
//
//    }

    //    public static int cost(List<Integer> B) {
//        int result;
//        int low = 0;
//        int hight = 0;
//
//        for (int i = 1; i < B.size(); i++) {
//            int nextLow = Math.max(low, hight + B.get(i - 1) - 1);
//            int nextHigh = Math.max(low + B.get(i) - 1,
//                    hight + Math.abs(B.get(i) - B.get(i - 1)));
//            low = nextLow;
//            hight = nextHigh;
//        }
//        result = Math.max(hight,low);
//        return result;
//    }


    public static int maxMin(int k, List<Integer> arr) {
        int temp, min=0;
        Collections.sort(arr);
        for(int i=0;i<=arr.size()-k;i++)
        {
            temp = arr.get(i + k - 1) - arr.get(i);
            if(temp < min)
                min = temp;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> D = new ArrayList<>();
        D.add(1);
        D.add(6);
        D.add(9);


        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);

        List<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(5);

        List<Integer> C = new ArrayList<>();
        C.add(4);
        C.add(5);

        List<Integer> E = new ArrayList<>();
        C.add(5);
        C.add(6);

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(D);
        edges.add(A);
        edges.add(B);
        edges.add(C);
        edges.add(E);

        List<Integer> data = new ArrayList<>();
        data.add(100);
        data.add(200);
        data.add(100);
        data.add(500);
        data.add(100);
        data.add(600);

        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(1);
        arr.add(10);
        arr.add(1);
        arr.add(10);

        System.out.println(maxMin(12,D));
    }
}

