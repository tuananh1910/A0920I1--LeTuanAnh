package problem2;

import java.util.Scanner;

public class pro2 {
    // có thể xoay 90 độ mà không cần dùng temp matrix
    // để xoay 90 độ ta đổi 4 vị trí trong matrix.  đổi từng cặp với nhau 1vs1
    // ta co ma tran [  d   a  ]   swap a <-> b ->[ d   b ] swap b<-> d ->[ b  d ] swap b <-> c ->[ c  d ]
    //               [  c   b  ]                  [ c   a ]               [ c  a ]                [ b  a ]
    public static void main(String[] args) {
        int[][] matrixImg;
        matrixImg = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        Scanner scanner = new Scanner(System.in);
        int chooseNumber=0;
        boolean notExit = true;
//        System.out.println(matrixImg[matrixImg.length-1][matrixImg.length-1]);
//        matrixImg = rotate90Right(matrixImg);

        do {
            System.out.println("1.Rotate Right, 2. Rotate Left, 3. exit ");
            chooseNumber = scanner.nextInt();
            switch (chooseNumber){
                case 1:
                    matrixImg = rotate90Right(matrixImg);
                    displayMatrix(matrixImg);
                    break;
                case 2:
                    matrixImg = rotate90Left(matrixImg);
                    displayMatrix(matrixImg);
                    break;
                default:
                    notExit = false;
                    break;
            }
        }while (notExit);

    }

    private static int[][] rotate90Left(int[][] matrixImg) {
        int[][] tempMatrix = new int[matrixImg.length][matrixImg.length];
        int count =0;
        for (int i = 0 ; i <matrixImg.length;i++){
            for (int j = 0 ; j <matrixImg.length;j++){
                if (i==count){
                    tempMatrix[matrixImg.length-1-j][i] = matrixImg[i][j];
                }
            } count ++;
        }
        return tempMatrix;

    }

    public static int[][] rotate90Right(int[][] matrixImg){
        int[][] tempMatrix = new int[matrixImg.length][matrixImg.length];
        int count =0;
        for (int i = 0 ; i <matrixImg.length;i++){
        for (int j = 0 ; j <matrixImg.length;j++){
            if (i==count){
                tempMatrix[j][matrixImg.length-1-i] = matrixImg[i][j];
            }
        } count ++;
        }
        return tempMatrix;
    }
    public static void displayMatrix(int[][] matrixImg){
        System.out.println("matrix: ");
        for (int i = 0; i < matrixImg.length;i++){
            for (int j = 0;j<matrixImg.length;j++){
                if (!(j+1==matrixImg.length)){
                    System.out.print(matrixImg[i][j]+" ");
                }else {
                    System.out.println(matrixImg[i][j]);
                }
            }
        }
    }
}
