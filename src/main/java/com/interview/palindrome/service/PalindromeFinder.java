package com.interview.palindrome.service;

import org.springframework.stereotype.Component;

/**
 * <p>This class is used to find the longest palindrome
 * in a given string object.</p>
 */
@Component
public class PalindromeFinder {

    /**
     * <p>This method is used to find the longest palindrome in a string object.
     * The method starts the search for palindromes from the left part of the
     * string object increasing the size of the searchable substring with each
     * iteration.</p>
     * @param content the string object in which the method is searching for palindromes
     * @return the size of the longest palindrome
     */
    public int findLongestPalindrome(String content) {
        String longest = content.substring(0, 1);
        String palindrome;
        for (int i = 0; i < content.length() - 1; i++) {
            if (content.length() % 2 == 0) {
                palindrome = intermediatePalindrome(content, i, i + 1);
            } else {
                palindrome = intermediatePalindrome(content, i, i);
            }
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest.length();
    }

    /**
     * <p>In this method we are checking equality between the characters
     * in the content string, starting from the center moving one character left
     * and one character right with each iteration. If the checked characters
     * are not equal, the method returns the longest palindrome substring.</p>
     * @param content the string object in which we want to search palindrome
     * @param left the index of the character on the left part of the string
     * @param right the index of the character on the right part of the string
     * @return the longest palindrome substring in the input string
     */
    public String intermediatePalindrome(String content, int left, int right) {
        if (left > right) return null;
        while (left >= 0 && right < content.length()
                && content.charAt(left) == content.charAt(right)) {
            left--;
            right++;
        }
        return content.substring(left + 1, right);
    }

}
