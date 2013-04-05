package org.clannadyue.chat.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.clannadyue.chat.core.ChatServer;
import org.clannadyue.chat.core.ConfigureManager;
import org.clannadyue.chat.core.Globle;
import org.clannadyue.chat.core.User;
import org.clannadyue.chat.core.UserManager;
import org.clannadyue.unity.Screen;

/**
 * 代表程序的入口窗口
 */
public class InputUserFrame extends javax.swing.JFrame {

    public InputUserFrame() {
        initComponents();

//        ImageIcon bg = new ImageIcon("userHeadImage.jpg");
//        JLabel label = new JLabel(bg);
//        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
//        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//        JPanel panel = (JPanel)this.getContentPane();
//        panel.setOpaque(false);


        new Thread(ChatServer.getInstance()).start();
        Screen.suitLocation(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameTextField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        defaultConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("聊天登陆");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImages(null);

        userNameLabel.setText("用户名：");

        confirmButton.setText("确定");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        defaultConfirmButton.setText("默认登陆");
        defaultConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultConfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(defaultConfirmButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(defaultConfirmButton))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        initSys(this.userNameTextField.getText());
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void defaultConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultConfirmButtonActionPerformed

        initSys(null);
    }//GEN-LAST:event_defaultConfirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InputUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputUserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InputUserFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton defaultConfirmButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables

    private void initSys(String name) {
        this.hide();
        ConfigureManager.getInstance().setUserName(name);
        UserManager.getInstance().initListener();
        final User user = (User) ConfigureManager.getInstance().getConfigs().get(Globle.USER);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShowUserFrame(user.getName(), user.getLoginIp().toString()).setVisible(true);
            }
        });
    }
}
