/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massrename;

import java.io.File;

/**
 *
 * @author Krekog
 */
public class FileHandler {
    
    private static final String defaultPath = System.getProperty("user.dir");
    private static final String separator = System.getProperty("file.separator");
    
    /**
     * Returns the default path to run on
     * @return 
     */
    public static String getDefaultPath(){
        return defaultPath;
    }
    
    
    /**
     * Renames all the subfiles of the given path to the shortest possible names.
     * @param path The path to the directory which holds the files in need to renaming
     */
    public static void startMassRenaming(String path){
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] fileArray = directory.listFiles();
            if (fileArray != null) {
                int i=0;
                for (File file : fileArray) {
                    if (!"MassRename.jar".equals(file.getName())) {
                        executeMassRenaming(file, getNextName(i));
                        i++;
                    }
                }    
            }
        }
    }
    
    /**
     * Renames the given file to the newName and attempts to rename all the sub files
     * if the provided file is a directory
     * @param file The file to be renamed
     * @param newName The name to rename the file to
     * @return 
     */
    private static boolean executeMassRenaming(File file, String newName){
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            if (fileArray != null) {
                int i = 0;
                for (File subfile : fileArray) {
                    executeMassRenaming(subfile, getNextName(i));
                    i++;
                }                            
            }
        }
        return RenameFile(file, newName);
    }
    
    /**
     * Renames the file to the newName
     * @param file The file to be renamed
     * @param newName The new name
     * @return true if and only if the renaming succeeded; false otherwise
     */
    private static boolean RenameFile(File file, String newName){
        return file.renameTo(new File(file.getParent() + separator + newName));
    }
    
    /** Returns as many spaces as i. Can be helpful when debugging.
     * @param i The number of spaces required
     * @return A String containing i lots of space.
     */
    private static String SpaceGiver(int i){
        String spaces = "";
        for (int j = 0; j < i; j++) {
            spaces += " ";
        }
        return spaces;
    }
    
    
    /**Generates the lowercase English alphabet equivalent of parameter n.
     * @param n 
     * @return The lowercase English alphabet equivalent of n.
     */
    public static String getNextName(int n)
    {
        int range = 26; // 26 number of valid  letters in the alphabet
        int startingPoint = 97; // 97 is theindex of the first valid letter
                
        String name = "";
        int j = n;
        while ( j / range > 0){
            j /= range;
            if (j / range > 0 )
                name += Character.toString((char)(j % range + startingPoint)); 
            else
                name += Character.toString((char)(j % range + startingPoint));
        }
        name = new StringBuilder(name).reverse().toString();
        name += Character.toString((char)(n % range + startingPoint));
        
        return name;
    }
}
