package org.clannadyue.chat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Queue;
import javax.swing.Timer;
import org.clannadyue.chat.core.ChatServer;
import org.clannadyue.chat.core.Client;
import org.clannadyue.chat.core.Message;
import org.clannadyue.unity.Screen;

/**
 * 代表聊天窗口
 */
public class ChatFrame extends javax.swing.JFrame {
    
    private Client client;
    private String userName;
    private ChatServer chatServer;
    private String messages;
    private Timer timer;
    private String chatterIp;

    public ChatFrame(String userName,String chatterIp) {
        initComponents();
        initData(userName,chatterIp);
        suitFrame(userName);
        initShowMessageFreshTimer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showMessagesPane1 = new javax.swing.JScrollPane();
        showMessagesTextArea = new javax.swing.JTextArea();
        editMessagesPanel = new javax.swing.JScrollPane();
        editMessagesTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        canelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        showMessagesTextArea.setColumns(20);
        showMessagesTextArea.setRows(5);
        showMessagesPane1.setViewportView(showMessagesTextArea);

        editMessagesTextArea.setColumns(20);
        editMessagesTextArea.setRows(5);
        editMessagesPanel.setViewportView(editMessagesTextArea);

        submitButton.setText("Send");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        canelButton.setText("Canel");
        canelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canelButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(showMessagesPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                        .addComponent(editMessagesPanel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showMessagesPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editMessagesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(canelButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        try {
            if (!this.editMessagesTextArea.getText().equals("")) {
                String mess = "我" + "  " + new Date().toLocaleString() + "\n" + "       "
                        + this.editMessagesTextArea.getText() + "\n";
                messages += mess;
                client.sendMessage(userName, this.editMessagesTextArea.getText());
                this.editMessagesTextArea.setText("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void canelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canelButtonActionPerformed

        this.editMessagesTextArea.setText("");
    }//GEN-LAST:event_canelButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        SingerChatterInfoShowPanel.ips.remove(this.chatterIp);
        timer.stop();
    }//GEN-LAST:event_formWindowClosing

    private void freshReceiveMessageInfo() {
        if (chatServer.getMessagesByUserName(userName) != null) {
            Queue<Message> messes = chatServer.getMessagesByUserName(userName);
            Message message = null;
            while ((message = messes.poll()) != null) {
                String mess = userName + "  " + message.getReceiveTime().toLocaleString() + "\n" + "       "
                        + message.getContent() + "\n";
                messages += mess;
            }
//            for (Message message : chatServer.getMessagesByUserName(userName)) {
//                String mess = message.getReceiveTime().toLocaleString() + "\n" + "       "
//                        + message.getContent() + "\n";
//                messages += mess;
//            }
        }

    }
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatFrame("chenhan").setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canelButton;
    private javax.swing.JScrollPane editMessagesPanel;
    private javax.swing.JTextArea editMessagesTextArea;
    private javax.swing.JScrollPane showMessagesPane1;
    private javax.swing.JTextArea showMessagesTextArea;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    private void initData(String userName,String chatterIp) {
        messages = "";
        this.userName = userName;
        this.chatterIp = chatterIp;
        client = Client.getInstance();
        chatServer = ChatServer.getInstance();
    }

    private void initShowMessageFreshTimer() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freshReceiveMessageInfo();
                ChatFrame.this.showMessagesTextArea.setText(messages);
            }
        });
        timer.start();

    }

    private void suitFrame(String userName) {
        this.setTitle("当前正在聊天的用户：" + userName);
        this.editMessagesTextArea.grabFocus();
        this.showMessagesTextArea.setEditable(false);
        Screen.suitLocation(this);
    }
}
