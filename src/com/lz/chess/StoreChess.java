package com.lz.chess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreChess {


    public static void main(String[] args) {
        saveIntoFile();
    }

    public static int[][] generateChess() {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][2] = 2;
        for (int[] row : chessArr) {
            for (int ele : row){
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }
        return  chessArr;
    }

    public static void saveIntoFile(){
        int[][] chessArr = generateChess();

        StringBuffer content = new StringBuffer();
        for (int[] ints : chessArr) {
            for (int item : ints) {
                content.append(item+" ");
            }
            content.append("\n");
        }
        try {
            Files.write(Paths.get("D:/chessFile.txt"), content.toString().getBytes("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
