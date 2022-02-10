package com.hologramsciences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorithms {
    /**
     *
     *  Compute the cartesian product of a list of lists of any type T
     *  the result is a list of lists of type T, where each element comes
     *  each successive element of the each list.
     *
     *  https://en.wikipedia.org/wiki/Cartesian_product
     *
     *  For this problem order matters.
     *
     *  Example:
     *
     *   listOfLists = Arrays.asList(
     *                         Arrays.asList("A", "B"),
     *                         Arrays.asList("K", "L")
     *                 )
     *
     *   returns:
     *
     *   Arrays.asList(
     *         Arrays.asList("A", "K"),
     *         Arrays.asList("A", "L"),
     *         Arrays.asList("B", "K"),
     *         Arrays.asList("B", "L")
     *   )
     *
     *
     *
     */
    public static final <T> List<List<T>> cartesianProductForLists(final List<List<T>> listOfLists) {
        // TODO Implement me

        if(listOfLists.size()<1) return Collections.emptyList();

        // Solution: cartesian product given by A * B = {{a, b} : a E A, b E B}
        List<List<T>> result = new ArrayList<>();

        // Assuming only two lists are given
        // iterating through the first list
        for (T a : listOfLists.get(0)) {

            // iterating through the second list
            for (T b : listOfLists.get(1)) {
                // determining {a, b}
                result.add(Arrays.asList(a, b));
            }
        }

        // returning the result of the cartesian product of a list of lists of any type T
        return result;
    }

    /**
     *
     *  In the United States there are six coins:
     *  1¢ 5¢ 10¢ 25¢ 50¢ 100¢
     *  Assuming you have an unlimited supply of each coin,
     *  implement a method which returns the number of distinct ways to make totalCents
     */
    public static final long countNumWaysMakeChange(final int totalCents) {
        // TODO Implement me

        // list of United States coins
        List<Integer> coins = Arrays.asList(1, 5, 10, 25, 50, 100);

        // Array of possible combinations (distinct ways)
        int [] combinations = new int[totalCents+1];

        combinations[0] = 1;

        // Iterating through each coin to determine all possible combinations
        for(int coin : coins){
            for(int i=1; i < combinations.length; i++){
                if(i>=coin){
                    combinations[i] += combinations[i-coin];
                }
            }
        }

        // returning the number of combinations (distinct ways) to make totalCents ${totalCents}
        return combinations[totalCents];
    }
}
