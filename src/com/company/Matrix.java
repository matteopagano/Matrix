package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Matrix {

    private final int nCol;
    private final int nRow;
    private final int[][] matrix;


    public Matrix(int [][] a){
        this.nCol = a[0].length;
        this.nRow = a.length;
        matrix = a;
    }

    public Matrix sum(@NotNull Matrix b){
        int[][] ar = new int[this.nRow][this.nCol];
        Matrix c;
        if(this.nRow != b.nRow && this.nCol != b.nCol){
            c = null;
        }else{
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    ar[i][j] = this.matrix[i][j] + b.matrix[i][j];
                }
            }
            c = new Matrix(ar);
        }
        return c;
    }

    public Matrix product(@NotNull Matrix b){
        int[][] ar = new int[this.nRow][b.nCol];
        Matrix c;
        if(this.nCol != b.nRow){
            return null;
        }else{
            for(int i = 0; i < ar.length; i++){
                for(int j = 0; j < ar[i].length; j++){
                    int sum = 0;
                    for (int k = 0; k < this.nCol; k++){
                        sum += this.matrix[i][k] * b.matrix[k][j];
                    }
                    ar[i][j] = sum;
                }
            }
            c = new Matrix(ar);
        }
        return c;
    }

    public Matrix scalarProduct(int s){
        int[][] ar = new int[this.nRow][this.nCol];
        Matrix c;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                ar[i][j] = this.matrix[i][j] * s;
            }
        }
        c = new Matrix(ar);
        return c;
    }

    public ArrayList<Integer> diagonalElement(){
        ArrayList<Integer> a;
        if (this.isSquare()){
            a = new ArrayList<>();
            for(int i = 0; i < this.nCol; i++){
                a.add(matrix[i][i]);
            }
        }else{
            a = null;
        }
        return a;
    }

    public int trace(){
        int sum = 0;
        for(Integer e : this.diagonalElement()){
            sum += e;
        }
        return sum;
    }

    public Matrix subMatrix(int @NotNull [] r, int @NotNull [] c){
        int [][] a = new int[r.length][c.length];
        Matrix n;
        Iterator<Integer> itR = Arrays.stream(r).iterator();
        if(!(r.length == 0 && c.length == 0) && (max(r) <= nRow && max(c) <= nCol)){
            for(int i = 0; i < a.length; i++){
                int row = itR.next();
                Iterator<Integer> itC = Arrays.stream(c).iterator();
                for(int j = 0; j < a[i].length; j++){
                    int col = itC.next();
                    a[i][j] = this.matrix[row-1][col-1];
                }
            }
            n = new Matrix(a);
        }else{
            n = null;
        }
        return n;
    }

    public Matrix transpose(){
        int[][] t = new int[this.nCol][this.nRow];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < this.matrix.length; i++){
            for(int j = 0; j < this.matrix[i].length; j++){
                q.add(matrix[i][j]);
            }
        }
        System.out.println(q);
        for(int i = 0; i < this.matrix.length; i++){
            for(int j = 0; j < this.matrix[i].length; j++){
                t[j][i] = q.poll();
            }
        }
        return new Matrix(t);
    }

    public boolean isDiagonal(){
        boolean bool = true;
        if(isSquare()){
            for(int i = 0; i < this.matrix.length && bool; i++){
                for(int j = 0; j < this.matrix[i].length && bool; j++){
                    if(!(i == j)){
                        if(this.matrix[i][j] != 0){
                            bool = false;
                        }
                    }
                }
            }
        }else{
            bool = false;
        }
        return bool;
    }

    public boolean isSquare(){
        return nCol == nRow;
    }

    public boolean isSymmetrical(){
        boolean bool = true;
        if(!this.isSquare()){
            bool = false;
        }else{
            for(int i = 0; i < this.matrix.length && bool; i++){
                for(int j = 0; j < this.matrix[i].length && bool; j++){
                    if(this.matrix[i][j] !=this.matrix[j][i]){
                        bool = false;
                    }
                }
            }
        }

        return bool;
    }

    private int max(int @NotNull [] a){
        ArrayList<Integer> ar = new ArrayList<>();
        for(Integer i:a) {
            ar.add(i);
        }
        return Collections.max(ar);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
}
