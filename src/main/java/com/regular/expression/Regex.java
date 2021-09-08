package com.regular.expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        // The regex pattern
        final String REGEX_PATTERN = "fooa*bar";
        //file should be placed inside folder resource
        final String regexFileName = "regFile1.txt";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        // Read the input file line by line
        try {
            // using InputStreamReader to read data from a file
            System.out.println("regexFileName >>> " + regexFileName);

            InputStream inputStream= Regex.class.getClassLoader().getResourceAsStream(regexFileName);
            System.out.println("input stream is >>> " + inputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            //BufferedReader is a Java class to reads the text from Input stream (like a file)
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine() ) {
                // Now create matcher object.
                Matcher matcher = pattern.matcher(line);

                // Apply the regex pattern to each line. If pattern matches, output the current line.
                if (matcher.find()) {
                    System.out.println(line);
                }

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
