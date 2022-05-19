package com.interview.palindrome.service;

import org.springframework.stereotype.Component;

@Component
public class PalindromeFinder {

    public int findLongestPalindrome(String content) {
        String longest = content.substring(0, 1);
        for (int i = 0; i < content.length() - 1; i++) {
            //odd cases like 121
            String palindrome = intermediatePalindrome(content, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            //even cases like 1221
            palindrome = intermediatePalindrome(content, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest.length();
    }

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
