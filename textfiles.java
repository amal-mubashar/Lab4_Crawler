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

public class textfiles {
        //Starting directory for parsing

    public String readFile(String filename)
{
    String content = null;
    File file = new File(filename); //for ex foo.txt
    FileReader reader = null;
    try {
        reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        content = new String(chars);
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(reader !=null){}
    }
    return content;
}

 public static void directoryCrawler(File aStartingDir){
    

     File[] filesAndDirs = aStartingDir.listFiles();
     List<File> dir = new ArrayList<File>();
     

    System.out.println(aStartingDir.toString());

    //List all files in directory
    
    String name;
    String title_part = aStartingDir.toString();
    int i;
    
    for(File file:filesAndDirs){
          
       for( i=title_part.length()-1 ; i>=0 && title_part.charAt(i)!='.' ; i--){
       name = title_part.substring(i,title_part.length());
       // System.out.println(title_part);
       
       if ((file.isFile()) ){
           if ( (name == ".txt") ) {
    //Display file names
   
    System.out.println(file.getPath());
    

    }
        
    else {
    //Add first level directory to a list
    dir.add(file);
    }
    }  
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
        
public static void main(String [] args){
        
         
    //Starting directory for parsing
    File aStartingDir = new File("C:/Program Files");
    directoryCrawler(aStartingDir);
   // readFile(name);
    System.out.println("Crawling complete");
    }

}