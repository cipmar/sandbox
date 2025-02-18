package org.example.slidingwindow;

/**
 * There are N buckets arranged in a row. Each bucket either is empty or contains a ball.
 * The buckets are specified as a string buckets consisting of characters "." (empty bucket) and "B" (bucket with a ball).
 * For example, for buckets = "B.BB.B..B".
 * In one move you can take the ball out of any bucket and place it in another (empty) bucket.
 * Your goal is to arrange the balls to create an alternating sequence of full and empty buckets.
 * In other words, the distance between two consecutive balls should be equal to 2.
 */
public class BallsInBucket {

    int solution(String buckets) {
        char[] array = buckets.toCharArray();

        // count the balls
        int balls = ballsInWindow(array, 0, array.length - 1, 1);

        // we need no of balls + balls - 1 of empty spaces for the solution
        // we check each window of size 2 * balls - 1 on how many balls are in correct place
        // the no of balls which are not in the correct place is the no of moves we need to do to make that window a solution
        // we evaluate all the windows, and keep the minimum
        int window = 2 * balls - 1;

        if (window > array.length) {
            // no solution, too many balls
            return -1;
        }

        // to avoid counting the no of balls in the current window all the time, we calculate the no of balls in
        // the first windows and update the number as we progress through the array
        int correctBallsInWindow = ballsInWindow(array, 0, window - 1, 2);
        int totalBallsInWindow = ballsInWindow(array, 0, window - 1, 1);

        int left = 0;
        int right = left + window - 1;
        int min = Integer.MAX_VALUE;

        while (right < array.length) {

            int moves = balls - correctBallsInWindow;
            if (moves < min) {
                min = moves;
            }

            left++;
            right++;

            if (right < array.length) {

                // calculate new correctBallsInWindow and totalBallsInWindow
                // what were incorrect in the previous widows are correct in the new window
                correctBallsInWindow = totalBallsInWindow - correctBallsInWindow;

                // add one more correct if last in next window is correct
                if (array[right] == 'B') {
                    correctBallsInWindow++;
                    totalBallsInWindow++;
                }

                // if first from prev window is a ball, remove from total
                if (array[left - 1] == 'B') {
                    totalBallsInWindow--;
                }
            }
        }

        return min;
    }

    private int ballsInWindow(char[] array, int left, int right, int step) {
        int n = 0;

        for (int i = left; i <= right; i = i + step) {
            if (array[i] == 'B') {
                n++;
            }
        }

        return n;
    }
}
