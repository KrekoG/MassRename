/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massrename;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Krekog
 */
public class TUI {
    
    String Path;
    boolean confimed = false;
    /**
     * Returns the selected path
     * @return 
     */
    public String getPath() {
        return Path;
    }
    /**
     * Returns whether the user confirmed to proceed 
     * @return 
     */
    public boolean canProceed() {
        return confimed;
    }
    
    /**
     * initialise a newly created user interface
     * TUI constructor
     * @param defaultPath The path to run at if the user does not provide an alternative
     */
    public TUI(String defaultPath) {
        this.Path = defaultPath;
    }
    
    /**
     * Communicates our intention to the user to run on the selected path
     * If the user confirms, sets confirmed to true.
     * @param givenPath The path to run on. If null, the method defaults
     * to the Path variable filled by the constructor.
     */
    public void AskForUserPermission(String givenPath)
    {
        //Abort if the user gives too many parameters.
        /*if (args.length > 2){
            System.out.println("Woa woa woa! Slow down bro! Chill out and try again.");
        }*/
        
        System.out.println("\nWelcome to the recursive MassRenamer!\n");
        try{
            if (givenPath != null){
                System.out.println("You are trying to recursively rename the content of:");
                // Testing if the the path is legit
                File file = new File(givenPath);
                System.out.println(givenPath);
                if (!file.exists() || !file.isDirectory())
                    throw new IOException("InvalidDirectory");
                this.Path = givenPath;
            }else{
                System.out.println("You are in the following directory:");
                System.out.println(Path);
            }
            System.out.println("I will attempt to rename all the files in this directory to the shortest name possible.");
            System.out.println("do you wish to proceed?(Y/whatever)");
            BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
            String answer = bR.readLine(); 
            if (!answer.equals("") && answer.substring(0, 1).equalsIgnoreCase("y")) {
                this.confimed = true;
            }else{
                String wittyResponse = "";
                switch (TUI.PickAnswer(7)){
                    case 1: wittyResponse="Maybe next time."; break;
                    case 2: wittyResponse="No surprise you never finish anything in your life..."; break;
                    case 3: wittyResponse="Too much commitment huh?"; break;
                    case 4: wittyResponse="The jokes on you I'm not even compatible with "+System.getProperty("os.name")+"!"; break;
                    case 5: wittyResponse="Your enjoy rejecting others aren't you..."; break;
                    case 6: wittyResponse="You don't deserve my attention!"; break;
                    case 7: wittyResponse="*khm* *khm* pussy *khm*"; break;
                }
                System.out.print(wittyResponse+" ");
            }
        } catch(IOException e) {
            if (e.getMessage().equals("InvalidDirectory")) {
                System.out.println("Wait a minute...");
                System.out.println("That's not even a valid directory!");
                System.out.println("Are you trying to deceive me?!");
            }else{
                System.out.println("An error stabbed me!");
                System.out.println("I honestly did not expect this, here is all I know :");
                e.getMessage();
            }
	}
    }
    
    /**
     * Checks if the provided string would qualify as a valid file name in the current OS.
     * Currently only supports windows.
     * Not used in the program at the moment. 
     * 
     * Stolen straight out of StackOverflow. Yes, I'm that lazy. source link:
     * http://stackoverflow.com/questions/6730009/validate-a-file-name-on-windows
     * 
     * @param text
     * @return 
     */
//    private static boolean isValidName(String text)
//    {
//        Pattern pattern = Pattern.compile(
//            "# Match a valid Windows filename (unspecified file system).          \n" +
//            "^                                # Anchor to start of string.        \n" +
//            "(?!                              # Assert filename is not: CON, PRN, \n" +
//            "  (?:                            # AUX, NUL, COM1, COM2, COM3, COM4, \n" +
//            "    CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,     \n" +
//            "    COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,     \n" +
//            "  )                              # LPT6, LPT7, LPT8, and LPT9...     \n" +
//            "  (?:\\.[^.]*)?                  # followed by optional extension    \n" +
//            "  $                              # and end of string                 \n" +
//            ")                                # End negative lookahead assertion. \n" +
//            "[^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.\n" +
//            "[^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.  \n" +
//            "$                                # Anchor to end of string.            ", 
//            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
//        Matcher matcher = pattern.matcher(text);
//        boolean isMatch = matcher.matches();
//        return isMatch;
//    }

    /**
     * Displays a farewell message
     */
    public void SayGoodBye() {
        System.out.println("Good bye!");
    }
    
    /**
     * Returns a numeric value in the range of 1 to numberOfOptions
     * @param numberOfOptions The number of options to pick from
     * @return 
     */
    private static int PickAnswer(int numberOfOptions){
        return ((int)(Math.floor(Math.random()*numberOfOptions+1)));
    }
}
