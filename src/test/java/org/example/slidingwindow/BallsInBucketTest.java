package org.example.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallsInBucketTest {

    @ParameterizedTest
    @MethodSource("testCases")
    public void testMinNumberOfMoves(String buckets, int expectedAnswer) {

        BallsInBucket ballsInBucket = new BallsInBucket();
        int answer = ballsInBucket.solution(buckets);
        assertEquals(expectedAnswer, answer);
    }

    public static Stream<Arguments> testCases() {

        return Stream.of(
                Arguments.of("BB.B.BBB...", 4),
                Arguments.of("..B....B.BB", 2),
                Arguments.of(".BBB.B", -1),
                Arguments.of(".B", 0),
                Arguments.of("B.B.B.B", 0),
                Arguments.of("B.B.B..", 0),
                Arguments.of("B...B..", 1),
                Arguments.of("BBBB...", 2),
                Arguments.of("...B....", 0),
                Arguments.of("...B...B", 1),
                Arguments.of("...BBBB", 2),
                Arguments.of(".B.B.B", 0)
        );
    }
}
