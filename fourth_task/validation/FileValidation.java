package com.company.epam.fourth_task.validation;

import java.io.File;

public class FileValidation {

    private File file;

    public FileValidation(String path) {
        file = new File(path);
        System.out.println(file.toString());
    }

    public void showInfo() {
        if (file.exists()) {
            System.out.println("file exists\n");
            System.out.println("getName " + file.getName());
            System.out.println("getParent " + file.getParent());
            System.out.println("getPath " + file.getPath());
            System.out.println("isAbsolute " + file.isAbsolute());
            System.out.println("getAbsolutePath " + file.getAbsolutePath());
            System.out.println("canRead " + file.canRead());
            System.out.println("canWrite " + file.canWrite());
            System.out.println("isDirectory " + file.isDirectory());
            System.out.println("isFile " + file.isFile());
            System.out.println("lastModified " + file.lastModified());
            System.out.println("length " + file.length());
            System.out.println("toString " + file.toString());

        } else {
            System.out.println("file isnt exists");
        }
    }



    private boolean isText(String name){
        return name.substring(name.length()-3).equals("txt");
    }

}
