/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package massrename;

/**
 *
 * @author Krekog
 */
public class MassRename {

    /**
     * A tool to rename the subfiles of a directory.
     * @param args[0] The path to the target directory.
     */
    public static void main(String[] args) {
        
        String givenPath = null;
        
        if (args.length > 0 && args[0] != null){
            givenPath = args[0];   
        }
        TUI tui = new TUI(FileHandler.getDefaultPath());
        tui.AskForUserPermission(givenPath);
        
        if (tui.canProceed()) {
            FileHandler.startMassRenaming(tui.getPath());
        }
        tui.SayGoodBye();
    } 
}
