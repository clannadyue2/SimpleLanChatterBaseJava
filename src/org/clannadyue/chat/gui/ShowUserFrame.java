package org.clannadyue.chat.gui;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clannadyue.chat.core.ChatServer;
import org.clannadyue.chat.core.Message;
import org.clannadyue.chat.core.User;
import org.clannadyue.chat.core.UserManager;
import org.clannadyue.unity.Screen;

/**
 * 程序运行时的主窗口
 */
public class ShowUserFrame extends javax.swing.JFrame {

    private UserManager userManager;
    private ChatServer chatServer;
    private boolean mouseEntered;

    public ShowUserFrame(String userName, String ip) {
        initComponents();
        initDate(userName, ip);
        freshChatters();
        suitLocation();

//        Timer locationTimer = new Timer(100, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (ShowUserFrame.this.getLocation().y <= 10 && !ShowUserFrame.this.mouseEntered) {
//                    int dincrease = 5;
//                    int y = ShowUserFrame.this.getLocation().y;
//                    while (ShowUserFrame.this.getLocation().y + ShowUserFrame.this.getHeight() >= 20) {
//                        y -= dincrease;
//                        ShowUserFrame.this.setLocation(ShowUserFrame.this.getLocation().x, y);
//                        try {
//                            Thread.sleep(2);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(ShowUserFrame.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        });
//        //locationTimer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        showUserInfoPanel = new javax.swing.JPanel();
        headImageLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        showChatterInfoScrollPanel = new javax.swing.JScrollPane();
        showChattersPanel = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        operationMenu = new javax.swing.JMenu();
        lookChatHistoryMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        littletoolsMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("聊天");
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        showUserInfoPanel.setBackground(new java.awt.Color(153, 153, 255));

        headImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/clannadyue/chat/gui/userHeadImage.jpg"))); // NOI18N

        nameLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        nameLabel.setText("UserName");

        ipLabel.setText("239.123.124.124");

        javax.swing.GroupLayout showUserInfoPanelLayout = new javax.swing.GroupLayout(showUserInfoPanel);
        showUserInfoPanel.setLayout(showUserInfoPanelLayout);
        showUserInfoPanelLayout.setHorizontalGroup(
            showUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showUserInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(showUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showUserInfoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(showUserInfoPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        showUserInfoPanelLayout.setVerticalGroup(
            showUserInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showUserInfoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipLabel)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(showUserInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        showChattersPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showChattersPanelMouseEntered(evt);
            }
        });
        showChattersPanel.setLayout(new java.awt.GridLayout(100, 1));
        showChatterInfoScrollPanel.setViewportView(showChattersPanel);

        operationMenu.setText("操作");

        lookChatHistoryMenuItem.setText("查看聊天历史");
        operationMenu.add(lookChatHistoryMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        operationMenu.add(exitMenuItem);

        MenuBar.add(operationMenu);

        littletoolsMenu.setText("小工具");

        jMenuItem1.setText("关于");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        littletoolsMenu.add(jMenuItem1);

        MenuBar.add(littletoolsMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showUserInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showChatterInfoScrollPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(showUserInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showChatterInfoScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
    }//GEN-LAST:event_formMouseMoved

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        //       this.mouseEntered = false;
    }//GEN-LAST:event_formMouseExited

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
//         this.mouseEntered = true;
//        if (ShowUserFrame.this.getLocation().y + ShowUserFrame.this.getHeight() <= 5) {
//            int increase = 5;
//            int y = ShowUserFrame.this.getLocation().y;
//            while (ShowUserFrame.this.getLocation().y <= 0) {
//                y += increase;
//                ShowUserFrame.this.setLocation(ShowUserFrame.this.getLocation().x, y);
//                try {
//                    Thread.sleep(2);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ShowUserFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }//GEN-LAST:event_formMouseWheelMoved

    private void showChattersPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showChattersPanelMouseEntered
        //this.mouseEntered = true;
    }//GEN-LAST:event_showChattersPanelMouseEntered

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new About().setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel headImageLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu littletoolsMenu;
    private javax.swing.JMenuItem lookChatHistoryMenuItem;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenu operationMenu;
    private javax.swing.JScrollPane showChatterInfoScrollPanel;
    private javax.swing.JPanel showChattersPanel;
    private javax.swing.JPanel showUserInfoPanel;
    // End of variables declaration//GEN-END:variables

    private void freshChatters() {
        //        this.mouseEntered = false;
        //        System.out.println("showUserFrame");
        //        Timer timer = new Timer(10000, new ActionListener() {
        //            @Override
        //            public void actionPerformed(ActionEvent e) {
        //                System.out.println("showUserFrameTimer");
        //                showChatters.removeAll();
        //                boolean red = true;
        //                for (User user : userManager.getUserInfo()) {
        //                    SingerChatterInfoShowPanel sinChatShowPanel =
        //                            new SingerChatterInfoShowPanel(
        //                            user.getName(), user.getLoginIp().toString(),
        //                            user.isOnline(), hasMessage(user));
        //                    if (red) {
        //                        sinChatShowPanel.
        //                                setBackground(new java.awt.Color(255, 204, 255));
        //                        red = false;
        //                    } else {
        //                        sinChatShowPanel.
        //                                setBackground(new java.awt.Color(153, 153, 255));
        //                        red = true;
        //                    }
        //                    showChatters.add(sinChatShowPanel);
        //                }
        //            }
        //
        //            private boolean hasMessage(User user) {
        //                Queue<Message> messes =
        //                        chatServer.getMessagesByUserName(user.getName());
        //                return messes != null && messes.size() != 0;
        //            }
        //        });
        // timer.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    //  System.out.println("showUserFrameTimer");
                    showChattersPanel.removeAll();
                    boolean red = true;
                    for (User user : userManager.getUserInfo()) {
                        // System.out.println("======================UsersTime" + user.getLastOnlineTime().toLocaleString());
                        SingerChatterInfoShowPanel sinChatShowPanel =
                                new SingerChatterInfoShowPanel(
                                user.getName(), user.getLoginIp().toString(),
                                user.isOnline(), hasMessage(user));
                        setBackGroud(red, sinChatShowPanel);
                        showChattersPanel.add(sinChatShowPanel);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ShowUserFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            private boolean hasMessage(User user) {
                Queue<Message> messes =
                        chatServer.getMessagesByUserName(user.getName());
                return messes != null && messes.size() != 0;
            }

            private void setBackGroud(boolean red, SingerChatterInfoShowPanel sinChatShowPanel) {
                if (red) {
                    sinChatShowPanel.
                            setBackground(new java.awt.Color(255, 204, 255));
                    red = false;
                } else {
                    sinChatShowPanel.
                            setBackground(new java.awt.Color(153, 153, 255));
                    red = true;
                }
            }
        }).start();
    }

    private void initDate(String userName, String ip) {
        userManager = UserManager.getInstance();
        chatServer = ChatServer.getInstance();
        this.nameLabel.setText(userName);
        this.ipLabel.setText(ip);
    }

    private void suitLocation() {
        int screenWidth = Screen.getScreenWidth();
        this.setLocation(screenWidth - this.getWidth(), 0);
    }
}
