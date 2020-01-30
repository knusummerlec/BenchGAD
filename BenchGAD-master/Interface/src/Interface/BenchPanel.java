package Interface;

import Data.IconList;
import Data.IconList;
import Data.IconListRenderer;
import Data.IconListRenderer;
import Data.IconNode;
import Data.IconNode;
import Data.IconNodeRenderer;
import Data.IconNodeRenderer;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.TreePath;

public class BenchPanel extends JPanel {

    /* Data-Intensive System's value */
    public String[] dbms = {"Data-Intensive Systems", // 0
        "RDBMS", // 1
        "MySQL",
        "MSSQL Server",
        "Oracle",
        "GPU-Based Data System", // 5
        "MapD",
        "PostgreSQL"
    };
    public IconNode[] nodes = new IconNode[dbms.length];
    private int TREE_HEIGHT = 3;

    /* Selected System's value */
    DefaultListModel checkedModel = new DefaultListModel();

    public BenchPanel() {
        nodeSetting();

        initComponents();
    }

    /*
     * Purpose : node's icon setting
     */
    public void nodeSetting() {
        for (int i = 0; i < dbms.length; i++) {
            nodes[i] = new IconNode(dbms[i]);
        }
        nodes[0].add(nodes[1]);
        for (int i = 2; i <= 5; i++) {
            nodes[1].add(nodes[i]);
        }
        nodes[0].add(nodes[5]);
        for (int i = 6; i <= 7; i++) {
            nodes[5].add(nodes[i]);
        }

        nodes[0].setIcon(new ImageIcon(getClass().getResource("/images/dbmsNode.png")));
        nodes[0].setIconName("Data-Intensive Systems");
        nodes[2].setIcon(new ImageIcon(getClass().getResource("/images/MySQLNode.png")));
        nodes[2].setIconName("MySQL");
        nodes[3].setIcon(new ImageIcon(getClass().getResource("/images/MSSQLServerNode.png")));
        nodes[3].setIconName("MSSQL Server");
        nodes[4].setIcon(new ImageIcon(getClass().getResource("/images/oracleNode.png")));
        nodes[4].setIconName("Oracle");
        nodes[6].setIcon(new ImageIcon(getClass().getResource("/images/MapDNode.png")));
        nodes[6].setIconName("MapD");
        nodes[7].setIcon(new ImageIcon(getClass().getResource("/images/postgreNode.png")));
        nodes[7].setIconName("PostgreSQL");
    }

    public Icon findIcon(String name) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getIconName() == null) {
                continue;
            } else if (nodes[i].getIconName().equals(name)) {
                return nodes[i].getIcon();
            }
        }

        return null;
    }
    
    public boolean nodeIsNotIn(String name) {
        for (int i = 0; i < checkedModel.getSize(); i++) {
            if (checkedModel.getElementAt(i).toString().equals(name) == true) {
                return false;
            }
        }
        
        return true;
    }

    private Hashtable makeIcons() {
        Hashtable icons = new Hashtable();
        icons.put("Data-Intensive Systems", getClass().getResource("/images/dbmsNode.png"));
        return icons;
    }

    public Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }

    public String getInput() {
        return inputArea.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DBTree = new javax.swing.JTree(nodes[0]);
        jScrollPane2 = new javax.swing.JScrollPane();
        checkedList = new javax.swing.JList<>();
        step1Label = new javax.swing.JLabel();
        step1DescriptLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        step2Label = new javax.swing.JLabel();
        step2DescriptionLabel = new javax.swing.JLabel();
        lodeFileBtn = new RoundButton();

        setBackground(new java.awt.Color(32, 47, 90));
        setPreferredSize(new java.awt.Dimension(1150, 664));
        setSize(new java.awt.Dimension(1150, 664));

        DBTree.putClientProperty("JTree.icons", makeIcons());

        DBTree.setCellRenderer(new IconNodeRenderer());
        DBTree.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        DBTree.setFocusable(false);
        DBTree.setPreferredSize(new java.awt.Dimension(250, 300));
        DBTree.setSize(new java.awt.Dimension(250, 300));
        DBTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DBTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DBTree);

        checkedList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        checkedList.setModel(checkedModel);
        checkedList.setCellRenderer(new IconListRenderer());
        checkedList.setFocusable(false);
        checkedList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkedListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(checkedList);

        step1Label.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        step1Label.setForeground(new java.awt.Color(255, 204, 0));
        step1Label.setText("Step1");

        step1DescriptLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        step1DescriptLabel.setForeground(new java.awt.Color(255, 204, 0));
        step1DescriptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        step1DescriptLabel.setText("Choose your database system");

        inputArea.setColumns(20);
        inputArea.setRows(5);
        jScrollPane3.setViewportView(inputArea);

        step2Label.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        step2Label.setForeground(new java.awt.Color(255, 204, 0));
        step2Label.setText("Step2");

        step2DescriptionLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        step2DescriptionLabel.setForeground(new java.awt.Color(255, 204, 0));
        step2DescriptionLabel.setText("Provide input directly or by .txt file");

        lodeFileBtn.setBackground(new java.awt.Color(153, 255, 0));
        lodeFileBtn.setText("Load");
        lodeFileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lodeFileBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lodeFileBtnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(step1DescriptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(246, 246, 246)
                                .addComponent(step2DescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(step1Label)
                                .addGap(450, 450, 450)
                                .addComponent(step2Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(261, 261, 261)
                        .addComponent(lodeFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(lodeFileBtn)
                        .addGap(491, 491, 491))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(step1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(step2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(step1DescriptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(step2DescriptionLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Purpose : If user dbms click twice, selected dbms send to checked list
     */
    private void DBTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DBTreeMouseClicked
        // Just do it in double-clicked
        if (evt.getClickCount() == 2) {
            TreePath tp = DBTree.getPathForLocation(evt.getX(), evt.getY());

            if (tp != null && tp.getPathCount() == TREE_HEIGHT) {
                String name = tp.getLastPathComponent().toString();
                
                if (nodeIsNotIn(name)) {
                    checkedModel.addElement(new IconList(name, new ImageIcon(iconToImage(findIcon(name)))));
                }
            }
        }
    }//GEN-LAST:event_DBTreeMouseClicked

    /*
     * Purpose : If user checkedList click twice, selected list deletes that cell
    */
    private void checkedListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkedListMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedIndex = checkedList.getSelectedIndex();
            
            if (selectedIndex != -1) {
                checkedModel.remove(selectedIndex);
            }
            
            
        }
    }//GEN-LAST:event_checkedListMouseClicked

    /*
     * Purpose : lodeFileBtn's cursor animation
    */
    private void lodeFileBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lodeFileBtnMouseEntered
        lodeFileBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lodeFileBtnMouseEntered

    /*
     * Purpose : Show file lode frame
    */
    private void lodeFileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lodeFileBtnMouseClicked
       JFrame loadFileFrame = new JFrame("Text File Chooser");
       JFileChooser textFileChooser = new JFileChooser("Select Text File");
       FileNameExtensionFilter filter = new FileNameExtensionFilter("txt , text", "txt", "text");
       textFileChooser.setFileFilter(filter);
       
       int returnVal = textFileChooser.showOpenDialog(loadFileFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = textFileChooser.getSelectedFile();
            try {
                inputArea.read(new FileReader(file.getAbsolutePath()),null);
            } catch (IOException ex) {
                System.out.println("problem accessing file"+file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
       loadFileFrame.dispose();
    }//GEN-LAST:event_lodeFileBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree DBTree;
    public javax.swing.JList<String> checkedList;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton lodeFileBtn;
    private javax.swing.JLabel step1DescriptLabel;
    private javax.swing.JLabel step1Label;
    private javax.swing.JLabel step2DescriptionLabel;
    private javax.swing.JLabel step2Label;
    // End of variables declaration//GEN-END:variables
}
