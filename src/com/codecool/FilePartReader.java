package com.codecool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;


    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if(toLine < fromLine || fromLine < 1) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws FileNotFoundException {
        Scanner in = new Scanner(new File(filePath));
        StringBuilder sb = new StringBuilder();
        while(in.hasNext()) {
            sb.append(in.nextLine());
            sb.append("\n");
        }
        in.close();
        return sb.toString();
    }


    public String readLines() throws FileNotFoundException {
        String file = read();
        Integer count = 1;
        String[] lines = file.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if(count >= fromLine && count <= toLine){
                sb.append("line " + count++ + " : " + line);
            }
            count++;
        }
        return sb.toString();
    }


    public static void main(String[] args) throws FileNotFoundException {
        FilePartReader file = new FilePartReader();
        file.setup("sample.txt", 1, 5);
        System.out.println(file.readLines());

        FileWordAnalyzer file2 = new FileWordAnalyzer(file);
        file2.wordsByABC();
        file2.wordsContainingSubString("sum");
        file2.wordsArePalindrome();
    }
}