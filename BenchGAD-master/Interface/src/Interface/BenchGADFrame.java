package Interface;

import Data.Alldata;
import Data.Alldata;
import Interface.BenchPopup;
import Interface.BenchPopup;
import Function.CSVExporter;
import Function.CSVExporter;
import Function.REST;
import Function.REST;
import Interface.WelcomeFrame;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.util.TimerTask;

public class BenchGADFrame extends JFrame {
    
    /* Constant of size */
    public final int PROGRESS_HEIGHT = 36;

    /* status value */
    private boolean firstExecute = true;
    private boolean isFolded = true;
    private boolean onNotification = true;
    private boolean isBenchPanel = true;
    private boolean isOptionSide = false;

    private WelcomeFrame welcomeF = new WelcomeFrame();
    private BenchPopup notificationPopup;

    public BenchGADFrame() {
        initComponents();
        setVisible(true);
        
        if (firstExecute) { // if program is executed in first time, show welcome window
            welcomeF.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        collecter = new javax.swing.JPanel();
        exportBtn = new javax.swing.JButton();
        environmentSettingBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        benchBtn = new javax.swing.JButton();
        settingBtn = new javax.swing.JButton();
        accountBtn = new javax.swing.JButton();
        expensionPanel = new javax.swing.JPanel();
        optionPanel1 = new Interface.OptionPanel();
        cardPanel = new javax.swing.JPanel();
        benchPanel1 = new Interface.BenchPanel();
        environmentPanel1 = new Interface.EnvironmentPanel();
        progressPanel = new javax.swing.JPanel();
        notificationBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(50, 0, 1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 722));
        setSize(new java.awt.Dimension(1200, 700));

        backPanel.setBackground(new java.awt.Color(255, 255, 255));
        backPanel.setMinimumSize(new java.awt.Dimension(1200, 700));
        backPanel.setSize(new java.awt.Dimension(1200, 700));

        sidePanel.setBackground(new java.awt.Color(0, 18, 50));
        sidePanel.setPreferredSize(new java.awt.Dimension(50, 656));
        sidePanel.setSize(new java.awt.Dimension(50, 656));

        collecter.setBackground(new java.awt.Color(0, 18, 50));
        collecter.setBounds(new java.awt.Rectangle(0, 0, 50, 656));
        collecter.setPreferredSize(new java.awt.Dimension(50, 656));

        exportBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exportDefault.png"))); // NOI18N
        exportBtn.setBorderPainted(false);
        exportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportBtnMouseEntered(evt);
            }
        });

        environmentSettingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/toolDefault.png"))); // NOI18N
        environmentSettingBtn.setBorderPainted(false);
        environmentSettingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                environmentSettingBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                environmentSettingBtnMouseEntered(evt);
            }
        });

        menuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menuDefault.png"))); // NOI18N
        menuBtn.setToolTipText("Unfording menu slide");
        menuBtn.setBorderPainted(false);
        menuBtn.setPreferredSize(new java.awt.Dimension(38, 38));
        menuBtn.setSize(new java.awt.Dimension(38, 38));
        menuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuBtnMouseEntered(evt);
            }
        });

        benchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/benchOn.png"))); // NOI18N
        benchBtn.setBorderPainted(false);
        benchBtn.setPreferredSize(new java.awt.Dimension(38, 38));
        benchBtn.setSize(new java.awt.Dimension(38, 38));
        benchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                benchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                benchBtnMouseEntered(evt);
            }
        });

        settingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settingDefault.png"))); // NOI18N
        settingBtn.setBorderPainted(false);
        settingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingBtnMouseEntered(evt);
            }
        });

        accountBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accountDefault.png"))); // NOI18N
        accountBtn.setBorderPainted(false);

        javax.swing.GroupLayout collecterLayout = new javax.swing.GroupLayout(collecter);
        collecter.setLayout(collecterLayout);
        collecterLayout.setHorizontalGroup(
            collecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, collecterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(collecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(environmentSettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(benchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(collecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(exportBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(accountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(262, 262, 262))
        );
        collecterLayout.setVerticalGroup(
            collecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(collecterLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(benchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(environmentSettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        benchBtn.getAccessibleContext().setAccessibleName("benchBtn");

        expensionPanel.setBackground(new java.awt.Color(0, 18, 50));
        expensionPanel.setForeground(new java.awt.Color(0, 0, 102));
        expensionPanel.setPreferredSize(new java.awt.Dimension(250, 664));
        expensionPanel.setSize(new java.awt.Dimension(250, 664));
        expensionPanel.setLayout(new java.awt.CardLayout());
        expensionPanel.add(optionPanel1, "card2");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(collecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(expensionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(expensionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(collecter, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );

        cardPanel.setPreferredSize(new java.awt.Dimension(1150, 664));
        cardPanel.setSize(new java.awt.Dimension(1150, 664));
        cardPanel.setLayout(new java.awt.CardLayout());

        benchPanel1.setPreferredSize(new java.awt.Dimension(1150, 656));
        cardPanel.add(benchPanel1, "benchCard");

        javax.swing.GroupLayout environmentPanel1Layout = new javax.swing.GroupLayout(environmentPanel1);
        environmentPanel1.setLayout(environmentPanel1Layout);
        environmentPanel1Layout.setHorizontalGroup(
            environmentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        environmentPanel1Layout.setVerticalGroup(
            environmentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        cardPanel.add(environmentPanel1, "environmentCard");

        progressPanel.setBackground(new java.awt.Color(0, 0, 0));
        progressPanel.setForeground(new java.awt.Color(255, 204, 0));
        progressPanel.setBounds(0, 0, 1200, PROGRESS_HEIGHT);
        progressPanel.setPreferredSize(new java.awt.Dimension(1200, 44));
        progressPanel.setSize(new java.awt.Dimension(1200, 44));

        notificationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alramOn.png"))); // NOI18N
        notificationBtn.setBorderPainted(false);
        notificationBtn.setMinimumSize(new java.awt.Dimension(32, 32));
        notificationBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        notificationBtn.setSize(new java.awt.Dimension(32, 32));
        notificationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationBtnMouseEntered(evt);
            }
        });

        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playOn.png"))); // NOI18N
        playBtn.setBorderPainted(false);
        playBtn.setPreferredSize(new java.awt.Dimension(32, 32));
        playBtn.setSize(new java.awt.Dimension(32, 32));
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playBtnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(notificationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372))
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notificationBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(playBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(progressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addGroup(backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 656, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
     * Purpose : If menu btn is clicked, side panel is folded or unfolded
     */
    private void menuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseClicked
//        Rectangle windowR = getBounds();
//        int height = windowR.height - 22 - PROGRESS_HEIGHT; // 22 is frame's border
//        
//        if (isFolded) {
//            menuBtn.setIcon(new ImageIcon(getClass().getResource("/images/menuOn.png")));
//            sidePanel.setPreferredSize(new Dimension(300, height));
//            sidePanel.setSize(new Dimension(300, height));
//        } else {
//            menuBtn.setIcon(new ImageIcon(getClass().getResource("/images/menuDefault.png")));
//            sidePanel.setPreferredSize(new Dimension(50, height));
//            sidePanel.setSize(new Dimension(50, height));
//        }
//        isFolded = !isFolded;
    }//GEN-LAST:event_menuBtnMouseClicked

    /*
     * Purpose : Cursor animation
     */
    private void menuBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBtnMouseEntered
//        menuBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuBtnMouseEntered
    
    
    /*
     * Purpose : Announce to user turning on notification function
    */
    private void notificationBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseClicked
        if (onNotification) {
            notificationBtn.setIcon(new ImageIcon(getClass().getResource("/images/alramDefault.png")));
        } else {
            notificationBtn.setIcon(new ImageIcon(getClass().getResource("/images/alramOn.png")));
            notificationPopup = new BenchPopup("Notification is turned on");
            notificationPopup.setVisible(true);
        
            /* close popup window after 2 seconds */
            java.util.Timer m_timer = new java.util.Timer();
            TimerTask m_task = new TimerTask() {
                public void run() {
                    notificationPopup.dispose();
                }
            };
            m_timer.schedule(m_task, 2000);
        }
        
        onNotification = !onNotification;
    }//GEN-LAST:event_notificationBtnMouseClicked

    /*
     * Purpose : Export output to file(csv or pdf)
    */
    private void exportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBtnMouseClicked
        List<String> list = new ArrayList<String>();
        list.add("hi");
        list.add("bye");
        list.add("hello?");
        new CSVExporter("/Users/knuprime061/Documents", "test", list);   // testing file path
    }//GEN-LAST:event_exportBtnMouseClicked

    /*
     * Purpose : notificationBtn's cursor event
    */
    private void notificationBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseEntered
        notificationBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_notificationBtnMouseEntered

    /*
     * Purpose : settingBtn's cursor event
    */
    private void settingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnMouseEntered
        settingBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_settingBtnMouseEntered

    /*
     * Purpose : Show side panel which can set bench option
    */
    private void settingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingBtnMouseClicked
        Rectangle windowR = getBounds();
        int height = windowR.height - 22 - PROGRESS_HEIGHT; // 22 is frame's border
        
        if (isBenchPanel) {
            if (!isOptionSide) {
               settingBtn.setIcon(new ImageIcon(getClass().getResource("/images/settingOn.png")));
               sidePanel.setPreferredSize(new Dimension(300, height));
               sidePanel.setSize(new Dimension(300, height));

           } else {
               settingBtn.setIcon(new ImageIcon(getClass().getResource("/images/settingDefault.png")));
               sidePanel.setPreferredSize(new Dimension(50, height));
               sidePanel.setSize(new Dimension(50, height));
           }
           isOptionSide = !isOptionSide;
        }
    }//GEN-LAST:event_settingBtnMouseClicked

    /*
     * Purpose : exportBtn's cursor event
    */
    private void exportBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportBtnMouseEntered
        exportBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_exportBtnMouseEntered

    /*
     * Purpose : environmentSettingBtn's cursor event
    */
    private void environmentSettingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_environmentSettingBtnMouseEntered
        environmentSettingBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_environmentSettingBtnMouseEntered

    /*
     * Purpose : change cardPanel to show environment setting panel
    */
    private void environmentSettingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_environmentSettingBtnMouseClicked
        isBenchPanel = false;
        
        Rectangle windowR = getBounds();
        int height = windowR.height - 22 - PROGRESS_HEIGHT; // 22 is frame's border
        
        benchBtn.setIcon(new ImageIcon(getClass().getResource("/images/benchDefault.png")));
        environmentSettingBtn.setIcon(new ImageIcon(getClass().getResource("/images/toolOn.png")));
        
        /* Unfolding option side */
        settingBtn.setIcon(new ImageIcon(getClass().getResource("/images/settingDefault.png")));
        sidePanel.setPreferredSize(new Dimension(50, height));
        sidePanel.setSize(new Dimension(50, height));
        
        /* change cardPanel */
        CardLayout card = (CardLayout)(cardPanel.getLayout());
        card.show(cardPanel, "environmentCard");
    }//GEN-LAST:event_environmentSettingBtnMouseClicked

    /*
     * Purpose : benchBtn's cursor event
    */
    private void benchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_benchBtnMouseEntered
        benchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_benchBtnMouseEntered

    /*
     * Purpose : change cardPanel to show bench panel
    */
    private void benchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_benchBtnMouseClicked
        isBenchPanel = true;
        
        benchBtn.setIcon(new ImageIcon(getClass().getResource("/images/benchOn.png")));
        environmentSettingBtn.setIcon(new ImageIcon(getClass().getResource("/images/toolDefault.png")));
        
        CardLayout card = (CardLayout)(cardPanel.getLayout());
        card.show(cardPanel, "benchCard");
    }//GEN-LAST:event_benchBtnMouseClicked

    /*
     * Purpose : playBtn's cursor event
    */
    private void playBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMouseEntered
        playBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_playBtnMouseEntered

    /*
     * Purpose : Send allData to server 
    */
    private void playBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playBtnMouseClicked
        int count;
        //collect file
        REST Posting = new REST();
        Alldata topost = new Alldata();
        topost.setProject_name(optionPanel1.getProjectName());
        topost.setScale_factor(optionPanel1.getScaleFactor());
        topost.setTransaction_refresh_rate(optionPanel1.getRefreshRate());
        topost.setGPU_use(optionPanel1.getGpuUse());
        topost.setCPU_count(optionPanel1.getCpuCount());
        topost.settext(benchPanel1.getInput());
        
        int dbCount = benchPanel1.checkedList.getModel().getSize();
        String[] dbList = new String[dbCount];
        
        for (int i = 0; i < dbCount; i++) {
            dbList[i] = String.valueOf(benchPanel1.checkedList.getModel().getElementAt(i));
        }
        topost.setDblist(dbList, dbCount);
        
        Posting.postInfo(topost);
    }//GEN-LAST:event_playBtnMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BenchGADFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenchGADFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenchGADFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenchGADFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BenchGADFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountBtn;
    private javax.swing.JPanel backPanel;
    private javax.swing.JButton benchBtn;
    private Interface.BenchPanel benchPanel1;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel collecter;
    private Interface.EnvironmentPanel environmentPanel1;
    private javax.swing.JButton environmentSettingBtn;
    private javax.swing.JPanel expensionPanel;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton menuBtn;
    private javax.swing.JButton notificationBtn;
    private Interface.OptionPanel optionPanel1;
    private javax.swing.JButton playBtn;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JButton settingBtn;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
