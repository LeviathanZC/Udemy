package com.company.epam.fourth_task.processing;

import com.company.epam.fourth_task.exceptions.NoFileException;
import com.company.epam.fourth_task.validation.FileValidation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessing {

    private FileWriter fw;
    private FileReader fr;
    private Scanner scan;
    private File file;
    private File dir;
    private FileValidation fv;
    private String absolutePath;

    public FileProcessing(String name) throws Exception {

        absolutePath = new File("").getAbsolutePath();

        fv = new FileValidation(absolutePath + name);
        fv.showInfo();

    }

    public List<String> readData(String filepath) throws NoFileException {

        BufferedReader reader = null;
        try {
            List<String> data = new ArrayList<String>();
            reader= new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            return data;
        }
        catch (IOException e) {
            throw new NoFileException(e.getMessage(),e);
        }
        finally{
            closeQuietly(reader);
        }

    }
    private void closeQuietly(BufferedReader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

    public boolean add(String filename) throws Exception {
        return true;
    }



}
