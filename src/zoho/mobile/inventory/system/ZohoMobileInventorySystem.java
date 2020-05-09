/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoho.mobile.inventory.system;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Sanele
 */
public class ZohoMobileInventorySystem {

    public void mDesignAndDisplayGUI()throws HeadlessException
    {
        JFrame frmLogin = new JFrame();
        frmLogin.setResizable(true);
        frmLogin.setTitle("Zoho Mobile Inventory System");
        frmLogin.setExtendedState(MAXIMIZED_BOTH);
        frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JDesktopPane dsktpLogin = new JDesktopPane(){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(1000, 580);
            }
        };
        dsktpLogin.setBackground(new java.awt.Color(51, 255, 204));
        frmLogin.setContentPane(dsktpLogin);
        frmLogin.pack();
        
        mCreateAndAddInternalFrame(dsktpLogin, mIFrmLoginDesign(frmLogin));
        frmLogin.setVisible(true);
    }
    
    JTextField txtUsername = new JTextField();
    JPasswordField txtPassword = new JPasswordField();
    
    
    private JInternalFrame mIFrmLoginDesign(JFrame frmLogin)
    {
        JInternalFrame ifrmLogin = new JInternalFrame();
        ifrmLogin.setLocation(400, 150);
        ifrmLogin.setSize(476, 450);
        ifrmLogin.setBackground(new java.awt.Color(51, 255, 204));
        
        
        JLabel lblUsername = new JLabel();
        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsername.setText("Username");

        JLabel lblPassword = new JLabel();
        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPassword.setText("Password");

        JButton btnLogin = new JButton();
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener((java.awt.event.ActionEvent evt) -> {
            clsLogin clsLogin = new clsLogin();
            clsLogin.mLogin(txtUsername, txtPassword, frmLogin);
        });
        
        JLabel lblHeading = new JLabel();
        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHeading.setText("Zoho Mobile Inventory Login");
                
        javax.swing.GroupLayout ifrmLoginLayout = new javax.swing.GroupLayout(ifrmLogin.getContentPane());
        ifrmLogin.getContentPane().setLayout(ifrmLoginLayout);
        ifrmLoginLayout.setHorizontalGroup(
            ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ifrmLoginLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ifrmLoginLayout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addGap(188, 188, 188)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(ifrmLoginLayout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(188, 188, 188)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ifrmLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ifrmLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ifrmLoginLayout.createSequentialGroup()
                        .addComponent(lblHeading)
                        .addGap(45, 45, 45))))
        );
        ifrmLoginLayout.setVerticalGroup(
            ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ifrmLoginLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblHeading)
                .addGap(45, 45, 45)
                .addGroup(ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addGroup(ifrmLoginLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(ifrmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnLogin)
                .addGap(45, 45, 45))
        );
        
        return ifrmLogin;
    }
    
    private void mCreateAndAddInternalFrame(JDesktopPane dsktp, JInternalFrame ifrmLogin)
    {
        //Remove title pane
        BasicInternalFrameTitlePane titlePane = 
                (BasicInternalFrameTitlePane)((BasicInternalFrameUI) ifrmLogin.getUI()).getNorthPane();
        ifrmLogin.remove(titlePane);
        /**
        //Remove the listeners from UI which make the frame move
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI)
                ifrmLogin.getUI());
        for(MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()){
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }
        **/
        ifrmLogin.setVisible(true);
        dsktp.add(ifrmLogin);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZohoMobileInventorySystem zoho = new ZohoMobileInventorySystem();
        zoho.mDesignAndDisplayGUI();
    }
    
}
