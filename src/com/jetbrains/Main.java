package com.jetbrains;

import java.io.*;
import java.nio.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        File myFile = new File("countries.txt");

        Scanner scnr = new Scanner(System.in);

        String fileOutput = readFile();
        int userChoice = 0;
        String input = "";

        System.out.println("Welcome to our Country Database!");
        System.out.println("1 - See the list of countries\n" +
                "2 - Add a country\n" + "3 - Exit");

        System.out.print("Enter menu number: ");
        userChoice = scnr.nextInt();
        scnr.nextLine();

        switch (userChoice) {

            case 1:
                System.out.println(fileOutput);
                break;
            case 2:
                System.out.println("Please enter a country to add: ");
                input = scnr.next();
                writeFile(input, myFile);
                break;
            case 3:
                System.out.println("Goodbye");
                break;
        }
    }

    private static void CountriesTextFile() {
        File myFile = new File("countries.txt");
    }

    private static void writeFile(String input, File myFile) {
        try {
            PrintWriter countryName = new PrintWriter(new FileOutputStream(myFile, true));

            countryName.println(input);
            countryName.close();

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, that file was not found.");
        }

    }

    private static String readFile() {
        File myFile = new File("countries.txt");
        String output = "";

        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader bufRead = new BufferedReader(reader);
            String line = bufRead.readLine();
            while (line != null) {
                output = output + line + "\n";
                line = bufRead.readLine();

            }
            bufRead.close();
        } catch (Exception e) {
            System.out.println("Sorry, that file was not found.");
        }

        return output;
    }

}


