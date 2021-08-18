package com.lz.chess;

public class SparseArray {

    public static void main(String[] args) {
//            0: 无棋子；1：黑子；2：白子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
//        输出原始二维数组
        for (int[] row : chessArr) {
            for (int ele : row) {
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }
        int sum = 0;

//        将二维数组转稀疏数组思路：
//        1、先遍历二维数组得到非0的元素个数；2、
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j]!=0) {
                    sum ++;
                }
            }
        }
        System.out.println(sum);
//        2、创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
//        3、为稀疏数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[chessArr.length-1].length;
        sparseArr[0][2] = sum;
//        遍历二维数组，将非0元素存至sparseArr
        int count = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                    count ++;
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%s:%d\t %s:%d\t %s:%d\t", "row",sparseArr[i][0], "col", sparseArr[i][1], "val", sparseArr[i][2]);
            System.out.println("");
        }

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("复盘结果如下：");
        for (int[] row : chessArr2) {
            for (int ele : row) {
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }
    }
}
