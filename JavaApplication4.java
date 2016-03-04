/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author amubashar.bscs13seec
 */
public class JavaApplication4 {
    
    public static void main(String [] args){
    //Starting directory for parsing
    File aStartingDir = new File("C:/Program Files");
    directoryCrawler(aStartingDir);
    System.out.println("Crawling complete");
    }
    
    public static void directoryCrawler(File aStartingDir){
    

     File[] filesAndDirs = aStartingDir.listFiles();
     List<File> dir = new ArrayList<File>();

    //String title_part = "C:/Users/amubashar.bscs13seec/Documents/NetBeansProjects/JavaApplication5/test.txt";
    
    //for(int i=title_part.length()-1 ; i>=0 && title_part.charAt(i)!='.' ; i--);
    //title_part = title_part.substring(i,title_part.length());
    //System.out.println(title_part);
    //Current Directory being traversed
    
    System.out.println(aStartingDir.toString());

    //List all files in directory
    for(File file:filesAndDirs){
    if (file.isFile()) {
    //Display file names
    System.out.println(file.getPath());
    }
    else {
    //Add first level directory to a list
    dir.add(file);
    }
    }
    if(dir.isEmpty())
    return;
    else {
    /*Traverse directory structure recursively
    by calling directory crawler */
    for(File file:dir){
    directoryCrawler(file);
    }
    }
    }

    
}
