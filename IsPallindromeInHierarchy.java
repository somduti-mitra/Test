package com.myLearning.startAgain;

import java.util.stream.Stream;

public class IsPallindromeInHierarchy {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println(palindromedescendant("11211230"));
        System.out.println("=====================================");
        System.out.println(palindromedescendant("13001120"));
        System.out.println("=====================================");
        System.out.println(palindromedescendant("23336014"));
        System.out.println("=====================================");
        System.out.println(palindromedescendant("11"));
        System.out.println("=====================================");
        System.out.println(palindromedescendant("12341234"));
        System.out.println("=====================================");
        System.out.println(palindromedescendant("12345678"));
        System.out.println("=====================================");
    }

    private static boolean palindromedescendant(String inputString) {
        // System.out.println(inputString.length() + ":" + inputString.length() / 2);
        String firstHalf = inputString.substring(0, inputString.length() / 2);
        String secondHalfReverse = new StringBuilder(inputString.substring(inputString.length() / 2, inputString.length())).reverse().toString();
        if (firstHalf.equalsIgnoreCase(secondHalfReverse)) {
            return true;
        } else {
            StringBuilder sbDesc = new StringBuilder(inputString.length() / 2);
            char[] chars = inputString.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (i % 2 != 0)
                    continue;
                int newValue = Integer.valueOf(String.valueOf(chars[i])) + Integer.valueOf(String.valueOf(chars[i + 1]));
                if(inputString.length() % 2 != 0){
                    throw new RuntimeException("Invalid Input provided!!, the string is with odd digits. input/descendant String is: " + inputString);
                }
                sbDesc = sbDesc.append(Integer.toString(newValue));
            }
            if (sbDesc.toString().length() >= 2) {
                return palindromedescendant(sbDesc.toString());
            } else {
                return false;
            }
        }

    }
}
