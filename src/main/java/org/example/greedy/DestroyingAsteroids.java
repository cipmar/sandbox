package org.example.greedy;

import java.util.PriorityQueue;

/**
 * You are given an integer array asteroids and an integer mass representing the mass of a planet.
 * The planet will collide with the asteroids one by one - you can choose the order.
 * If the mass of the planet is less than the mass of an asteroid, the planet is destroyed.
 * Otherwise, the planet gains the mass of the asteroid. Can you destroy all the asteroids?
 */
public class DestroyingAsteroids {

    public static boolean asteroidsDestroyed(int[] asteroids, int planetMass) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (var asteroid : asteroids) {
            minHeap.add(asteroid);
        }

        while (!minHeap.isEmpty()) {
            Integer asteroid = minHeap.remove();

            if (asteroid > planetMass) {
                return false;
            }

            planetMass += asteroid;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] asteroids = {1, 5, 5, 5};
        int planetMass = 4;
        var result = asteroidsDestroyed(asteroids, planetMass);
        System.out.println(result);
    }
}
