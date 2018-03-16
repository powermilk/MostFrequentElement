package com.powermilk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing MostFrequentElement class")
@SelectPackages("com.powermilk")
class MostFrequentElementTest {
    private static final Logger log = LoggerFactory.getLogger(MostFrequentElementTest.class);

    private MostFrequentElement mostFrequentElement;
    private List<String> actualMostFrequentElement;
    private List<String> expectedMostFrequentElement;

    @BeforeEach
    void init() {
        mostFrequentElement = new MostFrequentElement();
        actualMostFrequentElement = new ArrayList<>();
        expectedMostFrequentElement = new ArrayList<>();
        log.info("Test stated!");
    }

    @AfterEach
    void tearDown() {
        mostFrequentElement = null;
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Returns most popular elements (for more than one elements)")
    void shouldReturnTwoMostFrequentElements() {
        int[] array = {1, 2, 5, 5, 5, 6, 6, 6, 7, 7};
        String[] expected = {"5x3", "6x3"};
        actualMostFrequentElement = mostFrequentElement.getMostFrequentElement(array);
        expectedMostFrequentElement = Arrays.asList(expected);
        assertEquals(expectedMostFrequentElement, actualMostFrequentElement);
        log.info("Test passed!");
    }

    @Test
    @DisplayName("Returns most frequent elements (only one element)")
    void shouldReturnOneMostFrequentElements() {
        int[] array = {1, 2, 5, 5, 5, 6, 6, 6, 7, 7};
        String[] expected = {"5x3"};
        actualMostFrequentElement = mostFrequentElement.getMostFrequentElement(array);
        expectedMostFrequentElement = Arrays.asList(expected);
        assertNotEquals(expectedMostFrequentElement, actualMostFrequentElement);
        log.info("Test passed!");
    }
}