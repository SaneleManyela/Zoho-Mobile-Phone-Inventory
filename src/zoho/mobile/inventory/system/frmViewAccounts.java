/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoho.mobile.inventory.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class frmViewAccounts extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmViewAccounts
     * @param str used to identify whose
     * account is being viewed
     */
    public frmViewAccounts(String str) {
        initComponents();
        mAccountFileChooser(str);
        lblHeading.setText(str+" Account");
        mDisplayAccountDetails(str);
    }
    
    //Creating an object of class StringBuilder used for 
    //holding contents of a read file.
    StringBuilder strAccountFileDetails = new StringBuilder();
        
    //A method that return a path to the location of created
    //text files
    private File mPath()
    {
        File flPath = new File("\\Zoho Mobile Phone Inventory");
        return flPath;
    }
    
    //A methods that creates an object of type JFileChooser, a
    //file chooser dialog that is used to select a file to be
    //read.
    private void mAccountFileChooser(String strSelectAccountOf)
    {
        final JFileChooser fc = new JFileChooser(".");
        fc.setCurrentDirectory(mPath());
        
        switch(strSelectAccountOf){
            case "accountant":
               fc.setDialogTitle("Select Accountant File");
               break;
            case "storeman":
                fc.setDialogTitle("Select Storeman File");
                break;
        }
        
        int intStatus = fc.showOpenDialog(null);
        if(intStatus == JFileChooser.APPROVE_OPTION)
        {
            mReadAccountFile(fc.getSelectedFile());
        }
        else if(intStatus == JFileChooser.CANCEL_OPTION)
        {
            fc.cancelSelection();
        }
    }
    
    //A method that reads a file passed as an argument to it
    //and stores the read details to a StringBuilder object
    private void mReadAccountFile(File flAccount)
    {
        FileReader reader;
        int intChar;
        
        try{
            reader = new FileReader(flAccount);
            while((intChar = reader.read()) != -1){
                strAccountFileDetails.append(String.valueOf((char)intChar));
            }
            reader.close();
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
    }
    
    //A method that confirm if a file is indeed that
    //of an accountant by counting spaces between
    //the values read from a file.
    private int mConfirmAccountIsForAccountant()
    {
        int intSpaceCount = 0;
        for(int i = 0; i < strAccountFileDetails.length(); i++)
        {
            if(strAccountFileDetails.charAt(i) == ' ')
            {
                intSpaceCount++;
            }          
        }
        return intSpaceCount;
    }
        
    //A method that displays to a text area values of a given file
    //stored in StringBuilder's object strAccountFileDetails depending
    //if the evaluation of a switch statement using a passed argument
    //result to the value accountant or storeman.
    private void mDisplayAccountDetails(String strViewAccountDetailsOf)
    {
        try
        {
            switch(strViewAccountDetailsOf)
            {
                case "accountant":
                    if((!strAccountFileDetails.substring(strAccountFileDetails.indexOf(" "), strAccountFileDetails.length())
                            .trim().startsWith("str") && !strAccountFileDetails.substring(strAccountFileDetails.indexOf(" "),
                                    strAccountFileDetails.length()).trim().startsWith("admin"))
                            && mConfirmAccountIsForAccountant() == 1)
                    {
                            txtViewAccountDetails.setText(strAccountFileDetails.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "The file you have chosen is not for an accountant.");
                    }
                    break;
                case "storeman":
                    if((strAccountFileDetails.substring(strAccountFileDetails.indexOf(" "), strAccountFileDetails.length())
                            .trim().startsWith("str") && !strAccountFileDetails.substring(strAccountFileDetails.indexOf(" "), 
                                    strAccountFileDetails.length()).trim().startsWith("admin")))
                    {
                        txtViewAccountDetails.setText(strAccountFileDetails.toString());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "The file you have chosen is not for a storeman.");
                    }
                    break;
            }
        }catch(IndexOutOfBoundsException e){
           JOptionPane.showMessageDialog(null, "You did not select a file.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspViewAccountDetails = new javax.swing.JScrollPane();
        txtViewAccountDetails = new javax.swing.JTextArea();
        lblHeading = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 255, 204));

        txtViewAccountDetails.setColumns(20);
        txtViewAccountDetails.setRows(5);
        jspViewAccountDetails.setViewportView(txtViewAccountDetails);

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeading.setText("Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspViewAccountDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lblHeading)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspViewAccountDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jspViewAccountDetails;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTextArea txtViewAccountDetails;
    // End of variables declaration//GEN-END:variables
}
