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

        // Solution: cartesian product given by A * B = {{a, b} : a E A, b E B}
        if(listOfLists.size()<1) return Collections.emptyList();
        List<List<T>> result = new ArrayList<>();

        // deriving the cartesian product of n lists
        deriveProduct(result, new ArrayList<>(), listOfLists);

        // returning the result of the cartesian product of a list of lists of any type T
        return result;
    }

    private static <T> void deriveProduct(List<List<T>> result, List<T> existingTupleToComplete, List<List<T>> inputData){

        // iterating through the current list
        for (T value : inputData.get(0)) {
            List<T> newExistingTuple = new ArrayList<>(existingTupleToComplete);
            newExistingTuple.add(value);

            // if only one tuple is left
            if(inputData.size() == 1){
                // create new list with the existing tuple for each value with the value added
                result.add(newExistingTuple);
            }else {
                // if there are several rows, recurse through each of them
                List<List<T>> newValues = new ArrayList<>();

                // create the next level of values
                for(int i=1; i<inputData.size(); i++){
                    newValues.add(inputData.get(i));
                }

                deriveProduct(result, newExistingTuple, newValues);
            }
        }
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
        long [] combinations = new long[totalCents+1];

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
