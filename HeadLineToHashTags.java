package com.myLearning.startAgain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HeadLineToHashTags {

    public static void main(String[] args) {
        String headLine1 = "How the Avocado Became the Fruit of the Global Trade";
        String headLine2 = "Why You Will Probably Pay More for Your Christmas Tree This Year";
        String headLine3 = "Hey Parents, Surprise, Fruit Juice Is Not Fruit";
        String headLine4 = "Visualizing Science";
        System.out.println("=====================================");
        System.out.println(getHashTags(headLine1));
        System.out.println("=====================================");
        System.out.println(getHashTags(headLine2));
        System.out.println("=====================================");
        System.out.println(getHashTags(headLine3));
        System.out.println("=====================================");
        System.out.println(getHashTags(headLine4));
        System.out.println("=====================================");
    }

    private static List<String> getHashTags(String headLine) {
        List<String> headLineWords = Arrays.asList(headLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" "));
        return headLineWords.stream()
                .sorted((e1, e2) -> e2.length() - e1.length())
                .limit(3)
                .map(words -> "#".concat(words))
                .collect(Collectors.toList());
    }
}
