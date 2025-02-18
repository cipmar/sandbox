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
        System.out.println(buckets);
        char[] array = buckets.toCharArray();

        // count the balls
        int balls = 0;
        for (char c : array) {
            if (c == 'B') {
                balls++;
            }
        }

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
        int correctBallsInWindow = -1;
        int totalBallsInWindow = -1;

        int left = 0;
        int right = left + window - 1;
        int min = Integer.MAX_VALUE;

        while (right < array.length) {

            if (correctBallsInWindow == -1) {
                // first window, so we calculate correctBallsInWindow and totalBallsInWindow

                correctBallsInWindow = 0;
                totalBallsInWindow = 0;

                for (int i = left; i <= right; i++) {
                    if (array[i] == 'B') {
                        totalBallsInWindow++;

                        if (i % 2 == 0) {
                            correctBallsInWindow++;
                        }
                    }
                }
            } else {
                // calculate correctBallsInWindow and totalBallsInWindow base on previous window

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

            int moves = balls - correctBallsInWindow;
            if (moves < min) {
                min = moves;
            }

            left++;
            right++;
        }

        return min;
    }
}
