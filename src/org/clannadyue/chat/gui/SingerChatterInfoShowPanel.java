package org.clannadyue.chat.gui;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类代表一个显示用户信息的Panel
 */
public class SingerChatterInfoShowPanel extends javax.swing.JPanel {

    public static List<String> ips = new ArrayList<String>();
    private String chatterName;
    private String chatterIp;
    private boolean online;
    private boolean hasMessages;

    public SingerChatterInfoShowPanel(String chatterName, String chatterIp,
            boolean online, boolean hasMessages) {
        initComponents();

        this.chatterName = chatterName;
        this.chatterIp = chatterIp;
        this.online = online;
        this.hasMessages = hasMessages;
        this.userNameLabel.setText(chatterName);
        this.loginIpLabel.setText(chatterIp);
        this.onLineStateLable.setText(online ? "在线" : "不在线");
        this.hasMessLabel.setText(hasMessages ? "有新信息" : "没有新信息");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        loginIpLabel = new javax.swing.JLabel();
        onLineStateLable = new javax.swing.JLabel();
        hasMessLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(284, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        userNameLabel.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        userNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/clannadyue/chat/gui/chatterHeadImage.jpg"))); // NOI18N
        userNameLabel.setText("UserName");

        loginIpLabel.setText("10.1.3.105");

        onLineStateLable.setText("在线");

        hasMessLabel.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        hasMessLabel.setText("有信息");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onLineStateLable, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginIpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hasMessLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginIpLabel)
                            .addComponent(hasMessLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(onLineStateLable)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        boolean createNewWindow = true;
        for (String ip : ips) {
            if (this.chatterIp.equals(ip)) {
                createNewWindow = false;
            }
        }

        if (createNewWindow) {
            ips.add(chatterIp);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ChatFrame(chatterName,chatterIp).setVisible(true);
                }
            });
        }

    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hasMessLabel;
    private javax.swing.JLabel loginIpLabel;
    private javax.swing.JLabel onLineStateLable;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
