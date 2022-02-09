package com.company.methods;

import java.awt.print.Book;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class utility {
    public static String getInput(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        return input.nextLine();
    }

    public static ArrayList<Book> writeLibraryToArray(File bookList) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        try {
            Scanner reader = new Scanner(bookList);
            while (reader.hasNextLine()) {
                String[] bookData = reader.nextLine().split("&");
                //Book book = new Book(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4]);
                //bookArrayList.add(book);
            }
            return bookArrayList;
        } catch (Exception e) {
            System.out.println("There was an error" + e);
            return bookArrayList;
        }
    }

    public static void writeArrayToLibrary(ArrayList<Book> bookListArray, File bookListFile) {
        try {
            FileWriter writer = new FileWriter(bookListFile.getName(), false);
            for (int i = 0; i < bookListArray.size(); i++) {
                Book bookToAdd = bookListArray.get(i);
                String bookData = bookToAdd.toString() + "\n";
                writer.write(bookData);
            }
        } catch (Exception e) {
            System.out.println("There was an error" + e);
        }
    }
}

