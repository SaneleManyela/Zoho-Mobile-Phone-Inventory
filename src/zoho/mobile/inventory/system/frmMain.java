/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoho.mobile.inventory.system;

/**
 *
 * @author Sanele
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
    }
    
    private String strLoggedInUser;
    
    public void mSetLoggedInUserValue(String strValue)
    {
        this.strLoggedInUser = strValue;
    }
    
    public void mUserAccessControl()
    {
        switch(strLoggedInUser)
        {
            case "admin":
                mnuFile.setEnabled(true);
                mnuAdministrativeOptions.setEnabled(true);
                mnuStoremanOptions.setVisible(false);
                break;
            case "storeman":
                mnuFile.setEnabled(true);
                mnuAdministrativeOptions.setVisible(false);
                mnuStoremanOptions.setEnabled(true);
                break;
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

        dsktpMain = new javax.swing.JDesktopPane();
        mbZohoMobileMenuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuItemLogout = new javax.swing.JMenuItem();
        mnuItemExit = new javax.swing.JMenuItem();
        mnuAdministrativeOptions = new javax.swing.JMenu();
        mnuItemAddAccountant = new javax.swing.JMenuItem();
        mnuItemViewAccountants = new javax.swing.JMenuItem();
        mnuStoremanOptions = new javax.swing.JMenu();
        mnuItemStoreman = new javax.swing.JMenuItem();
        mnuItemViewStoreman = new javax.swing.JMenuItem();
        mnuItemProductManagement = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dsktpMain.setBackground(new java.awt.Color(51, 255, 204));

        javax.swing.GroupLayout dsktpMainLayout = new javax.swing.GroupLayout(dsktpMain);
        dsktpMain.setLayout(dsktpMainLayout);
        dsktpMainLayout.setHorizontalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dsktpMainLayout.setVerticalGroup(
            dsktpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        mnuItemLogout.setText("Logout");
        mnuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemLogoutActionPerformed(evt);
            }
        });
        mnuFile.add(mnuItemLogout);

        mnuItemExit.setText("Exit");
        mnuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuItemExit);

        mbZohoMobileMenuBar.add(mnuFile);

        mnuAdministrativeOptions.setText("Administrative Options");

        mnuItemAddAccountant.setText("Add Accountant");
        mnuItemAddAccountant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemAddAccountantActionPerformed(evt);
            }
        });
        mnuAdministrativeOptions.add(mnuItemAddAccountant);

        mnuItemViewAccountants.setText("View Accountants");
        mnuItemViewAccountants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemViewAccountantsActionPerformed(evt);
            }
        });
        mnuAdministrativeOptions.add(mnuItemViewAccountants);

        mbZohoMobileMenuBar.add(mnuAdministrativeOptions);

        mnuStoremanOptions.setText("Storeman Options");

        mnuItemStoreman.setText("Add Storeman");
        mnuItemStoreman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemStoremanActionPerformed(evt);
            }
        });
        mnuStoremanOptions.add(mnuItemStoreman);

        mnuItemViewStoreman.setText("View Storeman");
        mnuItemViewStoreman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemViewStoremanActionPerformed(evt);
            }
        });
        mnuStoremanOptions.add(mnuItemViewStoreman);

        mnuItemProductManagement.setText("Product Management");
        mnuItemProductManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemProductManagementActionPerformed(evt);
            }
        });
        mnuStoremanOptions.add(mnuItemProductManagement);

        mbZohoMobileMenuBar.add(mnuStoremanOptions);

        setJMenuBar(mbZohoMobileMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsktpMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsktpMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemLogoutActionPerformed
        ZohoMobileInventorySystem zoho = new ZohoMobileInventorySystem();
        zoho.mDesignAndDisplayGUI();
        this.hide();
    }//GEN-LAST:event_mnuItemLogoutActionPerformed

    private void mnuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemExitActionPerformed
        System.exit(0); //This line of code terminates the run of the program
    }//GEN-LAST:event_mnuItemExitActionPerformed

    private void mnuItemAddAccountantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemAddAccountantActionPerformed
        frmAddAccounts frmAddAcc = new frmAddAccounts();
        frmAddAcc.mSetRegisterFor("accountant");
        frmAddAcc.setTitle("Add Accountant");
        frmAddAcc.setLocation(500, 150);
        dsktpMain.add(frmAddAcc);
        frmAddAcc.show();
    }//GEN-LAST:event_mnuItemAddAccountantActionPerformed

    private void mnuItemViewAccountantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemViewAccountantsActionPerformed
        //The constructor of this frmViewAccounts accepts an argument of type string
        frmViewAccounts frmViewAccountantDetails = new frmViewAccounts("accountant");
        frmViewAccountantDetails.setTitle("View Accountant Account Details");
        frmViewAccountantDetails.setLocation(500, 150);
        frmViewAccountantDetails.setClosable(true);
        dsktpMain.add(frmViewAccountantDetails);
        frmViewAccountantDetails.show();
    }//GEN-LAST:event_mnuItemViewAccountantsActionPerformed

    private void mnuItemStoremanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemStoremanActionPerformed
        frmAddAccounts frmAddStrmn = new frmAddAccounts();
        frmAddStrmn.mSetRegisterFor("storeman");
        frmAddStrmn.setTitle("Add Storeman");
        frmAddStrmn.setLocation(500, 150);
        dsktpMain.add(frmAddStrmn);
        frmAddStrmn.show();
    }//GEN-LAST:event_mnuItemStoremanActionPerformed

    private void mnuItemViewStoremanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemViewStoremanActionPerformed
        frmViewAccounts frmViewStoremanDetails = new frmViewAccounts("storeman");
        frmViewStoremanDetails.setTitle("View Storeman Account Details");
        frmViewStoremanDetails.setLocation(500, 150);
        frmViewStoremanDetails.setClosable(true);
        dsktpMain.add(frmViewStoremanDetails);
        frmViewStoremanDetails.show();
    }//GEN-LAST:event_mnuItemViewStoremanActionPerformed

    private void mnuItemProductManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemProductManagementActionPerformed
        frmProductManagement frmProductMgmt = new frmProductManagement();
        frmProductMgmt.setTitle("Add Product");
        frmProductMgmt.setLocation(500, 150);
        dsktpMain.add(frmProductMgmt);
        frmProductMgmt.show();
    }//GEN-LAST:event_mnuItemProductManagementActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dsktpMain;
    private javax.swing.JMenuBar mbZohoMobileMenuBar;
    private javax.swing.JMenu mnuAdministrativeOptions;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuItemAddAccountant;
    private javax.swing.JMenuItem mnuItemExit;
    private javax.swing.JMenuItem mnuItemLogout;
    private javax.swing.JMenuItem mnuItemProductManagement;
    private javax.swing.JMenuItem mnuItemStoreman;
    private javax.swing.JMenuItem mnuItemViewAccountants;
    private javax.swing.JMenuItem mnuItemViewStoreman;
    private javax.swing.JMenu mnuStoremanOptions;
    // End of variables declaration//GEN-END:variables
}
