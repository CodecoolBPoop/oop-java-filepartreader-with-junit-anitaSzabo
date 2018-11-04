package com.codecool;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader reader = new FilePartReader();


    @Test
    public void testIfFromLineIs0andToLineis0ThrowsIllegalArgumentException() throws FileNotFoundException {
        reader.setup("sample.txt", 0, 0);
        assertThrows(IllegalArgumentException.class, ()-> {
            reader.setup("sample.txt", 0, 0);
        });
    }

    @Test
    public void testIfToLineBelowFromLineThrowsException() {
        assertThrows(FileNotFoundException.class, ()-> {
            reader.setup("sample.txt", 2, 1);
        });
    }

    @Test
    public void testIfFromLineBelow1ThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            reader.setup("sample.txt", -1, 1);
        });
    }

    @Test
    public void testIfFileNotFoundThrowsException() throws FileNotFoundException {
        assertThrows(IllegalArgumentException.class, ()-> {
            reader.setup("notfound.txt", 1, 1);
        });
    }

    @Test
    public void testIfFileNotPresentMethodThrowsException() {
        assertThrows(FileNotFoundException.class, ()-> {
            reader.read();
        });
    }

    @Test
    public void testIfGivesBackBetweenFromLineAndToLine() throws FileNotFoundException {
        reader.setup("sample.txt", 1,1);
        assertEquals("Az alap Lorem Ipsum bekezdést az 1500-as évek óta használják", reader.read());
    }

}