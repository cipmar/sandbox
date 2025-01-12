package org.example.greedy;

import java.util.PriorityQueue;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;

/**
 * LeetCode would like to work on some projects to increase its capital before IPO. You are given n projects where the
 * ith project has a profit of profits[i] and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital. When you finish a project, the profit will be added to your total capital.
 * Return the max capital possible if you are allowed to do up to k projects.
 **/
public class Profits {

    public static int findMaxCapital(int k, int w, int[] profits, int[] capital) {

        // create a matrix, a row is the capital + project profit
        int[][] projects = new int[profits.length][2];

        for (int i = 0; i < profits.length; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        sort(projects, comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(reverseOrder());

        int j = 0;

        for (int i = 0; i < k; i++) {
            // add to heap the projects I afford
            while (j < profits.length && projects[j][0] <= w) {
                maxHeap.add(projects[j][1]);
                j++;
            }

            if (maxHeap.isEmpty()) {
                return w;
            }

            w += maxHeap.remove();
        }

        return w;
    }

    public static void main(String[] args) {

        int[] profits = {3, 1, 6, 12, 20};
        int[] capital = {0, 0, 2, 5, 7};
        int w = 1;
        int k = 3;

        int maxCapital = findMaxCapital(k, w, profits, capital);
        System.out.println(maxCapital);
    }
}
