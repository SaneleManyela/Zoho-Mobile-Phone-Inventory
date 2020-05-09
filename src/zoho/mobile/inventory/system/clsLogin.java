/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoho.mobile.inventory.system;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sanele
 */
public class clsLogin {
    String strUsername, strPassword;
    
    private boolean mCheckIfFileExists(JTextField txtUsername)
    {
        File flUserFile = new File(txtUsername.getText().toUpperCase()+".txt");
        return flUserFile.exists();
    }

    private StringBuilder mReadFile(JTextField txtUsername)
    {
        FileReader reader; //Declaration of a FileReader variable to be used to read a file
        int intChar; //Declaration of an integer variable to hold read information
        StringBuilder strCredentials = new StringBuilder(); //Declaration of a DtringBuilder object to hold file contents
        try{
            reader = new FileReader(txtUsername.getText().toUpperCase()+".txt"); //reader being instantiated as an object of FileReader
            while((intChar = reader.read()) != -1){ //A while loop block that loops while the variable intChar is not equal -1
                strCredentials.append(String.valueOf((char)intChar)); //This opperation appends to strCredentials one read value at a time
            }
            reader.close(); //This line closes the reader object and releases resources of the program
        }catch(FileNotFoundException ex){ 
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return strCredentials;
    }
    
    public void mLogin(JTextField txtUsername, JPasswordField txtPassword, JFrame frmLogin)
    {
        if(txtUsername.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please provide a username");
            txtUsername.requestFocusInWindow();
        }
        else if(txtPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please provide a password");
            txtPassword.requestFocusInWindow();
        }
        else{
            strUsername = txtUsername.getText();
            strPassword = txtPassword.getText();
            
            if(txtUsername.getText().toUpperCase().equals("OSCAR")
                    && txtPassword.getText().equals("8_118819488"))
            {
                frmMain frmMn = new frmMain();
                frmMn.mSetLoggedInUserValue("storeman"); //Assigns value to a variable declared inside frmMain
                frmMn.mUserAccessControl();//Invoke a method that assign user rights
                frmMn.setTitle("Zoho Mobile Phone Inventory System");
                frmMn.setExtendedState(MAXIMIZED_BOTH);
                frmMn.show();
                frmLogin.hide();
            }
            else if(mCheckIfFileExists(txtUsername))
            {
                strUsername = mReadFile(txtUsername).substring(0, mReadFile(txtUsername).indexOf(" "));
                strPassword = mReadFile(txtUsername).substring(mReadFile(txtUsername).indexOf(" "), mReadFile(txtUsername).length());
                
                if(strUsername.toLowerCase().equals(txtUsername.getText().toLowerCase())
                        && strPassword.trim().toLowerCase().equals(txtPassword.getText().toLowerCase())){
                    //An if statement that evaluates if a given user password starts with 'admin'
                    if(txtPassword.getText().toLowerCase().startsWith("admin")){
                        frmMain frmMn = new frmMain();
                        frmMn.mSetLoggedInUserValue("admin"); //Assigns value to a variable declared inside frmMain
                        frmMn.mUserAccessControl();//Invoke a method that assign user rights
                        frmMn.setTitle("Zoho Mobile Phone Inventory System");
                        frmMn.setExtendedState(MAXIMIZED_BOTH);
                        frmMn.show();
                        frmLogin.hide();
                    }
                    else if(txtPassword.getText().toLowerCase().startsWith("str")){ //An else..if that evaluates if a given user
                                                                                    //password starts with 'str'
                        frmMain frmMn = new frmMain();
                        frmMn.mSetLoggedInUserValue("storeman"); //Assigns value to a variable declared inside frmMain
                        frmMn.mUserAccessControl();//Invoke a method that assign user rights
                        frmMn.setTitle("Zoho Mobile Phone Inventory System");
                        frmMn.setExtendedState(MAXIMIZED_BOTH);
                        frmMn.show();
                        frmLogin.hide();
                    }
                }else{ //A message box that pops up if given credentials are not the same as those read from a user file
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "This account does not exist.");
            }
        }
    }
}
