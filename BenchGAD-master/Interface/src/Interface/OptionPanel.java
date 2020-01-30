package Interface;

import Data.Alldata;
import Data.Alldata;
import java.awt.Color;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OptionPanel extends javax.swing.JPanel {
    
    /* option value */
    private String projectName = "My Project";
    private int scaleFactor = 1;
    private int refreshRate = 1;
    private boolean gpuUse = false;
    private int cpuCount = 1;

    public OptionPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeBox = new javax.swing.JComboBox<>();
        scaleFactorLabel = new javax.swing.JLabel();
        scaleFactorBox = new javax.swing.JComboBox<>();
        transactionLabel1 = new javax.swing.JLabel();
        transactionLabel2 = new javax.swing.JLabel();
        transactionField = new javax.swing.JTextField();
        gpuUseLabel = new javax.swing.JLabel();
        gpuBox = new javax.swing.JCheckBox();
        cpuLabel1 = new javax.swing.JLabel();
        cpuLabel2 = new javax.swing.JLabel();
        cpuCountBox = new javax.swing.JComboBox<>();
        titleBackPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        projectNameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        saveBtn = new RoundButton();
        saveComputerBtn = new RoundButton();
        loadSettingBtn = new RoundButton();
        warningField = new javax.swing.JTextField();
        buffer_pool_Label = new javax.swing.JLabel();
        size_Label = new javax.swing.JLabel();
        buffer_Box = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 18, 50));

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TPC-C", "TPC-H" }));
        typeBox.setSelectedIndex(1);
        typeBox.setToolTipText("");

        scaleFactorLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        scaleFactorLabel.setForeground(new java.awt.Color(255, 204, 0));
        scaleFactorLabel.setText("Scale Factor");

        scaleFactorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "10", "30", "100", "300", "1000" }));

        transactionLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        transactionLabel1.setForeground(new java.awt.Color(153, 153, 153));
        transactionLabel1.setText("Transaction");

        transactionLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        transactionLabel2.setForeground(new java.awt.Color(153, 153, 153));
        transactionLabel2.setText("Refresh Rate");

        transactionField.setEditable(false);
        transactionField.setBackground(new java.awt.Color(153, 153, 153));

        gpuUseLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        gpuUseLabel.setForeground(new java.awt.Color(255, 204, 0));
        gpuUseLabel.setText("GPU Use");

        cpuLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cpuLabel1.setForeground(new java.awt.Color(255, 204, 0));
        cpuLabel1.setText("The Number");

        cpuLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        cpuLabel2.setForeground(new java.awt.Color(255, 204, 0));
        cpuLabel2.setText("of GPU");

        cpuCountBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "4", "8" }));

        titleBackPanel.setBackground(new java.awt.Color(255, 204, 0));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Choose Your Bench Option");

        javax.swing.GroupLayout titleBackPanelLayout = new javax.swing.GroupLayout(titleBackPanel);
        titleBackPanel.setLayout(titleBackPanelLayout);
        titleBackPanelLayout.setHorizontalGroup(
            titleBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleBackPanelLayout.setVerticalGroup(
            titleBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        projectNameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        projectNameLabel.setForeground(new java.awt.Color(255, 204, 0));
        projectNameLabel.setText("Project Name");

        saveBtn.setBackground(new java.awt.Color(255, 204, 0));
        saveBtn.setText("Save");
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtnMouseEntered(evt);
            }
        });

        saveComputerBtn.setBackground(new java.awt.Color(255, 153, 0));
        saveComputerBtn.setText("Save to my Computer");
        saveComputerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveComputerBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveComputerBtnMouseEntered(evt);
            }
        });

        loadSettingBtn.setBackground(new java.awt.Color(153, 255, 0));
        loadSettingBtn.setText("Load setting");
        loadSettingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadSettingBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadSettingBtnMouseEntered(evt);
            }
        });

        warningField.setEditable(false);
        warningField.setBackground(new java.awt.Color(0, 18, 50));
        warningField.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        warningField.setForeground(new java.awt.Color(255, 0, 0));
        warningField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        warningField.setBorder(null);

        buffer_pool_Label.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        buffer_pool_Label.setForeground(new java.awt.Color(255, 204, 0));
        buffer_pool_Label.setText("Buffer Pool");

        size_Label.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        size_Label.setForeground(new java.awt.Color(255, 204, 0));
        size_Label.setText("Size(GB)");

        buffer_Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "4", "8", "16", "32", "64" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(loadSettingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveComputerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buffer_pool_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(size_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buffer_Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(warningField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scaleFactorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scaleFactorBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(projectNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gpuUseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpuLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpuCountBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gpuBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(transactionLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(transactionLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(transactionField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cpuLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleBackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scaleFactorLabel)
                    .addComponent(scaleFactorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(transactionLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gpuUseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpuLabel1)
                            .addComponent(cpuCountBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(cpuLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buffer_pool_Label)
                            .addComponent(buffer_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(size_Label)
                        .addGap(37, 37, 37)
                        .addComponent(warningField, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveComputerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(loadSettingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gpuBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Purpose : getter
    */
    public String getProjectName() {
        return projectName;
    }
    
    public int getScaleFactor() {
        return scaleFactor;
    }
    
    public int getRefreshRate() {
        return refreshRate;
    }
    
    public boolean getGpuUse() {
        return gpuUse;
    }
    
    public int getCpuCount() {
        return cpuCount;
    }
    
    public String getType() {
        return typeBox.getSelectedItem().toString();
    }
    
    /* 
     * Purpose : saveBtn's cursor event
    */
    private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
        saveBtn.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
    }//GEN-LAST:event_saveBtnMouseEntered

    /*
     * Purpose : Save option to project
    */
    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        warningField.setText("");
        
        if (nameField.getText() != null) {
            projectName = nameField.getText();
        }
        scaleFactor = Integer.parseInt(scaleFactorBox.getSelectedItem().toString());
        
        try {
            if (!typeBox.getSelectedItem().toString().equals("TPC-H")) {
                refreshRate = Integer.parseInt(transactionField.getText());
            }
        } catch (NumberFormatException e) {
            warningField.setForeground(new Color(255, 0, 0));
            warningField.setText("refreshRate must be Integer");
            return;
        }
        
        gpuUse = gpuBox.isSelected();
        cpuCount = Integer.parseInt(cpuCountBox.getSelectedItem().toString());
        
        warningField.setForeground(new Color(255,204,0));
        warningField.setText("Save Project Success");
    }//GEN-LAST:event_saveBtnMouseClicked

    /*
     * Purpose : saveComputerBtn's cursor event
    */
    private void saveComputerBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveComputerBtnMouseEntered
        saveComputerBtn.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
    }//GEN-LAST:event_saveComputerBtnMouseEntered

    /*
     * Purpose : Save current option in local computer
    */
    private void saveComputerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveComputerBtnMouseClicked
         //collect file
        Alldata tosave=new Alldata();
        tosave.setProject_name(this.projectName);
        tosave.setScale_factor(this.scaleFactor);
        tosave.setTransaction_refresh_rate(this.refreshRate);
        tosave.setGPU_use(this.gpuUse);
        tosave.setCPU_count(this.cpuCount);
        
        //save file in disk
        javax.swing.JFrame saveProject = new javax.swing.JFrame("saveProject");
        JFileChooser bFileChooser = new JFileChooser("Save a Project");
        int returnVal = bFileChooser.showSaveDialog(saveProject);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
               ObjectOutputStream spf=new ObjectOutputStream(new FileOutputStream(bFileChooser.getSelectedFile()+".pn"));
               spf.writeObject(tosave);
               spf.close();
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        
        warningField.setForeground(new Color(255,153,0));
        
       saveProject.dispose();
    }//GEN-LAST:event_saveComputerBtnMouseClicked

    /*
     * Purpose : loadSettingBtn's cursor event
    */
    private void loadSettingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadSettingBtnMouseEntered
        loadSettingBtn.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
    }//GEN-LAST:event_loadSettingBtnMouseEntered

    private void loadSettingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadSettingBtnMouseClicked
        JFrame loadProject = new JFrame("loadProject");
        JFileChooser B_FileChooser = new JFileChooser("Load a Project");
        B_FileChooser.setDialogTitle("Load a Project");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Project File", "pn");
        B_FileChooser.setFileFilter(filter);
       
       int returnVal = B_FileChooser.showOpenDialog(loadProject);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = B_FileChooser.getSelectedFile();
            try {
              //load data 
               ObjectInputStream lpf=new ObjectInputStream(new FileInputStream(B_FileChooser.getSelectedFile())); 
               Alldata toload=(Alldata)lpf.readObject();
               projectName = toload.getProject_name();
               scaleFactor = toload.getScale_factor();
               refreshRate = toload.getTransaction_refresh_rate();
               gpuUse = toload.isGPU_use();
               
               /* setting to GPU */
               cpuCount = toload.getCPU_count();
              
               lpf.close();
          
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }catch(ClassNotFoundException e) {
		System.err.println("Problem with file input.");
            }
            catch (IOException ex) {
                System.out.println("problem accessing file"+file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        
        nameField.setText(projectName);
        scaleFactorBox.setSelectedItem(Integer.toString(scaleFactor));
        transactionField.setText("" + refreshRate);
        gpuBox.setSelected(gpuUse);
        cpuCountBox.setSelectedItem(Integer.toString(cpuCount));
        
        warningField.setForeground(new Color(153,255,0));
        warningField.setText(" ");
        
        loadProject.dispose();
    }//GEN-LAST:event_loadSettingBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> buffer_Box;
    private javax.swing.JLabel buffer_pool_Label;
    private javax.swing.JComboBox<String> cpuCountBox;
    private javax.swing.JLabel cpuLabel1;
    private javax.swing.JLabel cpuLabel2;
    private javax.swing.JCheckBox gpuBox;
    private javax.swing.JLabel gpuUseLabel;
    private javax.swing.JButton loadSettingBtn;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton saveComputerBtn;
    private javax.swing.JComboBox<String> scaleFactorBox;
    private javax.swing.JLabel scaleFactorLabel;
    private javax.swing.JLabel size_Label;
    private javax.swing.JPanel titleBackPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField transactionField;
    private javax.swing.JLabel transactionLabel1;
    private javax.swing.JLabel transactionLabel2;
    private javax.swing.JComboBox<String> typeBox;
    private javax.swing.JTextField warningField;
    // End of variables declaration//GEN-END:variables
}
