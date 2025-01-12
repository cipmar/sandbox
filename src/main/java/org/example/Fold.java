package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class Fold {

    public static <A, B> B fold(List<A> list, B startValue, BiFunction<A, B, B> func) {

        B sum = startValue;

        for (A a : list) {
            sum = func.apply(a, sum);
        }

        return sum;
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Integer fold = fold(list, 0, Integer::sum);
        System.out.println(fold);

        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(3);
        linkedList.addFirst(5);
        linkedList.addLast(5);

        System.out.println(linkedList);
    }
}
