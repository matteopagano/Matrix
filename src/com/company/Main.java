package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3, 4},
                        {5, 6, 7, 8}};

        int[][] mat2 = {{1, 1, 1, 1},
                        {1, 1, 1, 1}};

        int[][] mat5 = {{-1, -1, 1, 0},
                        {2, 0, -1, 2},
                        {0, 0, 3, 3}};

        int[][] mat6 = {{0, -1},
                        {1, 0},
                        {1, 1},
                        {-2, 2}};

        int[][] mat7 = {{2, 0},
                        {0, 0}};

        for(int i = 0; i < 100; i++){

        }



        System.out.println(new Matrix(mat5).subMatrix(new int[]{1,2,3},new int[]{1,2,3}));

    }
}
