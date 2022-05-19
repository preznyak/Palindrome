package com.interview.palindrome.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindromeFinder {

    PalindromeFinder palindromeFinder = new PalindromeFinder();

    @Test
    public void testPalindromeFinder_MinimumLength () {
        Assertions.assertEquals(1, palindromeFinder.findLongestPalindrome("dsa"));
    }

    @Test
    public void testPalindromeFinder_OddCase () {
        Assertions.assertEquals(3, palindromeFinder.findLongestPalindrome("abrakadabra"));
    }

    @Test
    public void testPalindromeFinder_EvenCase () {
        Assertions.assertEquals(4, palindromeFinder.findLongestPalindrome("abba"));
    }
}
