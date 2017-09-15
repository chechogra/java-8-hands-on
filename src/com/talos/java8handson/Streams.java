package com.talos.java8handson;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Streams {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Abby", "Edward", "Alfred", "Nathan", "Vicky", "Tim", "", "Bruce", "Ben", "John", "Doe", "", "Jane", "Alex", "Anne", "Alfonse");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5, 1, 5, 5, 6, 7, 2, 9, 4, 8, 2, 4);
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19, 14, 12, 44, 66, 33, 64, 76, 85, 95, 87, 24, 65, 11, 34);
        Stream<Stream<Character>> letters = names.stream().map(w -> characterStream(w));
        Stream<Character> lettersCharacters = names.stream().flatMap(s -> characterStream(s));


        //count the number of empty strings in the names array.
        Long count = names.stream().filter(string -> string.isEmpty()).count();
        System.out.println("\nEmpty Strings: " + count);

        //count the number of strings with length 3 that contain 'b'.
        count = names.stream().filter(string -> string.length() == 3 && string.contains("b")).count();
        System.out.println("\nStrings of length 3 and contains 'b': " + count);

        //count the number of strings with length 3 that contain 'b' or are equal to 'Tim'.
        count = names.stream().filter(string -> (string.length() == 3 && string.contains("b")) || string.equals("Tim")).count();
        System.out.println("\nStrings of length 3 and contains b or is equal to Tim: " + count);

        //create a filtered list with the non-empty elements of the names array.
        List<String> filtered = names.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("\nFiltered List: " + filtered);

        //create a filtered list with the elements that start with 'a' of the names array.
        List<String> startsWithString = names.stream().filter(string -> string.startsWith("a")).collect(Collectors.toList());
        System.out.println("\nStrings starting with 'a': " + startsWithString);

        //create a merged string of the non-empty elements of the names array, separated by commas.
        String mergedString = names.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("\nMerged String: " + mergedString);

        //create a list of the different squared integers in the numbers array.
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("\nSquares List: " + squaresList);

        /*create summary statistics for the integers array, show the highest number, lowest number,
         the sum of all numbers, and the average of all numbers */
        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("\nHighest number in List : " + stats.getMax());
        System.out.println("\nLowest number in List : " + stats.getMin());
        System.out.println("\nSum of all numbers : " + stats.getSum());
        System.out.println("\nAverage of all numbers : " + stats.getAverage());

        /*create a stream of numbers generated dynamically order them and print them. you must limit the output
        or else the random numbers will exceed the stream capacity */
        System.out.println("\n\nRandom Numbers: \n");
        new Random().ints().filter(i -> i > 0).limit(5).sorted().forEach(System.out::println);

        //create a simple stream, find the first element if the element is not null print it.
        System.out.println("\n\nPrint first element: \n");
        Arrays.asList("First Element", "Second Element", "Third Element", "Fourth Element", "Fifth Element")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);


        //create a stream of ints, initialize it's range, transform the elements by adding the character a before, print them.
        System.out.println("\n\nMap to Object: \n");
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        //use the stream of streams 'letters' and collect the characters contained in it as a list, and print them.
        System.out.println("\n\nStream of Streams: \n");
        letters.collect(Collectors.toList()).forEach(s -> s.collect(Collectors.toList()).forEach(System.out::println));

        //just print the lettersCharacters stream, the result will be the same as before.
        System.out.println("\n\nStream strings: \n");
        lettersCharacters.forEach(System.out::println);

        //try to find an element starting with 'A' in the names array, the result is an optional.
        System.out.println("\n\nFind a string starting with 'A': \n");
        System.out.println(names.stream().filter(s -> s.startsWith("A")).findAny());

        //try to find and element starting with 'K' in the names array, the result is an optional.
        System.out.println("\n\nFind a string starting with K': \n");
        System.out.println(names.stream().filter(s -> s.startsWith("K")).findAny());

        //try to find and element that does not start with 'Q', the predicate is evaluated.
        System.out.println("\n\nIs there any string not starting with 'Q': \n");
        System.out.println(names.stream().noneMatch(s -> s.startsWith("Q")));

    }

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }

}
