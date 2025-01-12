package org.example.recursion;

public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.printNumbers(10, 0);
    }

    public void printNumbers(int n, int i) {
        if (i > n) {
            return;
        }
        printNumbers(n, i + 1);
        System.out.println(i);
    }
}
