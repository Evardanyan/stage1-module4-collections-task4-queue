package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> integerQueue = Stream.iterate(1, i -> i + 1).limit(numberOfDishes).collect(toCollection(LinkedList::new));
        List<Integer> result = new ArrayList<>();
        while (!integerQueue.isEmpty()) {
            for (int i = 0; i < everyDishNumberToEat - 1; i++) {
                integerQueue.add(integerQueue.poll());
            }
            result.add(integerQueue.poll());
        }
        return result;
    }
}
