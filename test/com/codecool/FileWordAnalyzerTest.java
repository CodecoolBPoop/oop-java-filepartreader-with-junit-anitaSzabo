package com.codecool;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FilePartReader reader = new FilePartReader();
    FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

    @Test
    public void testIfReturnsTheWordsAlphabeticallyOrdered() throws FileNotFoundException {
        List<String> text = asList("1", "1500-as", "3", "5", ":", ":", ":", "ad", "adipiscing", "alap", "aliqua.", "aliquip", "amet,", "anim", "aute",
                "Az", "az", "bekezdést", "cillum", "commodo", "consectetur", "consequat.", "culpa", "cupidatat", "deserunt", "do", "dolor",
                "dolor", "dolore", "dolore", "Duis", "ea", "eiusmod", "elit,", "enim", "esse", "est", "et", "eu", "ex", "Excepteur", "exercitation",
                "fugiat", "görög", "használjákline", "id", "in", "in", "in", "incididunt", "indulagörögaludni", "Ipsum", "ipsum", "irure",
                "labore", "laboris", "laborum.line", "line", "Lorem", "Lorem", "magna", "minim", "mollit", "nisi", "non", "nostrud", "nulla",
                "occaecat", "officia", "pariatur.", "proident,", "qui", "quis", "reprehenderit", "sed", "sint", "sit", "sunt", "tempor",
                "ullamco", "ut", "Ut", "ut", "velit", "veniam,", "voluptate", "évek", "óta");
        assertEquals(analyzer.wordsByABC(), text);
    }

    @Test
    public void testIfReturnsTheWordsWithSubstring() throws FileNotFoundException {
        List<String> text = asList("Ipsum", "ipsum");
        assertEquals(text, analyzer.wordsContainingSubString("sum"));
    }

    @Test
    public void testIfReturnsTheWordsWithSubstringEmptyString() throws FileNotFoundException {
        List<String> text = asList("");
        assertEquals(text, analyzer.wordsContainingSubString(""));
    }

    @Test
    public void testIfReturnsPalindromes() throws FileNotFoundException {
        List<String> text = asList("minim", "görög", "esse", "non", "indulagörögaludni");
        assertEquals(text, analyzer.wordsArePalindrome());
    }

}