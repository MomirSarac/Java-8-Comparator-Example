/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.comparator.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Java 8 comparator example, for Java 7 comparator example, please refer to
 * Project Java7 Comparator example
 *
 * @author Momir Sarac
 */
public class Java8ComparatorExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create a list of items
        List<Item> listOfItems = new ArrayList<Item>();
        listOfItems.add(new Item("Iphone 6s", 849.99, 85));
        listOfItems.add(new Item("Iphone 5s", 549.99, 36));
        listOfItems.add(new Item("Iphone 7", 1299.99, 174));
        listOfItems.add(new Item("Iphone 6", 649.99, 75));

        // print unsorted list in Java 1.8
        listOfItems.forEach(System.out::println);

        // sorting a list by a value in Java 1.8
        // note that interface Comparator has only one method compare() that's not static or default, method equals() is inherited from the class Object
        // therefore Comparator is functional interface and can be used as a lambda ...
        // TypeInference works too, therefore we could use something like down below in comments without any issue
        // Collections.sort(listOfItems,(i1, i2)-> (int) (i1.getPriceOfTheItem() - i2.getPriceOfTheItem()));
        Collections.sort(listOfItems, (Item i1, Item i2) -> (int) (i1.getPriceOfTheItem() - i2.getPriceOfTheItem()));

        // even shorter for the code above
        listOfItems.sort((i1, i2) -> (int) (i1.getPriceOfTheItem() - i2.getPriceOfTheItem()));

        // prints all the items by it's value - ascending order
        // remember, it's a sorted list now, check code above...
        listOfItems.forEach(System.out::println);

        // prints all the items using condition for 
        // acqusition of all the items which price value is greater than or equals 750
        printItemsUsingCondition(listOfItems, (i) -> i.getPriceOfTheItem() >= 750);
        // even shorter in Java 1.8 without a need to use printItemsUsingCondition method
        listOfItems.stream().filter(i -> i.getPriceOfTheItem() >= 750).forEach(System.out::println);

        // prints all the items using condition for 
        // acqusition of all the items which contain 6s in an item name.
        printItemsUsingCondition(listOfItems, (i) -> i.getNameOfTheItem().contains("6s"));
        // even shorter in Java 1.8 without a need to use printItemsUsingCondition method
        listOfItems.stream().filter(i -> i.getNameOfTheItem().contains("6s")).forEach(System.out::println);

    }

    /**
     * Prints all condition binded items from a list
     *
     * @param listOfItems
     * @param condition
     */
    private static void printItemsUsingCondition(List<Item> listOfItems, Condition condition) {
        for (Item i : listOfItems) {
            if (condition.testCondition(i)) {
                System.out.println(i.toString());
            }
        }
    }
}
