/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.oopProj.form;

/**
 *
 * @author LENOVO
 */
import com.oopProj.form.EducVids_SubWindows.AllLessons;
import com.oopProj.form.EducVids_SubWindows.FEE;
import com.oopProj.form.EducVids_SubWindows.ECE;

public class EducVideos extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public EducVideos() {
        initComponents();

        AllLessonsButton.addActionListener(e -> openAllLessons());
        FEEButton.addActionListener(e -> openFEE());
        ECEButton.addActionListener(e -> openECE());
    }

    /**
     * This method is called from within  the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PageTitle = new javax.swing.JLabel();
        AllLessonsButton = new javax.swing.JButton();
        FEEButton = new javax.swing.JButton();
        ECEButton = new javax.swing.JButton();
        PageTitle1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(245, 245, 245));

        PageTitle.setFont(new java.awt.Font("Istok Web", 0, 18)); // NOI18N
        PageTitle.setForeground(new java.awt.Color(100, 100, 100));
        PageTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PageTitle.setText("Welcome to Tutorial Videos! Pick a topic you would like to explore.");
        PageTitle.setToolTipText("");

        AllLessonsButton.setBackground(new java.awt.Color(245, 245, 245));
        AllLessonsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/All Lessons (1) (1).png"))); // NOI18N
        AllLessonsButton.setBorder(null);
        AllLessonsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllLessonsButtonActionPerformed(evt);
            }
        });

        FEEButton.setBackground(new java.awt.Color(245, 245, 245));
        FEEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FEE button.png"))); // NOI18N
        FEEButton.setBorder(null);

        ECEButton.setBackground(new java.awt.Color(245, 245, 245));
        ECEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ECE button.png"))); // NOI18N
        ECEButton.setBorder(null);

        PageTitle1.setFont(new java.awt.Font("Istok Web", 1, 28)); // NOI18N
        PageTitle1.setForeground(new java.awt.Color(100, 100, 100));
        PageTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PageTitle1.setText("Educational Videos/Tutorials");
        PageTitle1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AllLessonsButton)
                        .addGap(30, 30, 30)
                        .addComponent(FEEButton)
                        .addGap(30, 30, 30)
                        .addComponent(ECEButton))
                    .addComponent(PageTitle1)
                    .addComponent(PageTitle)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PageTitle1)
                .addGap(18, 18, 18)
                .addComponent(PageTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FEEButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ECEButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AllLessonsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AllLessonsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllLessonsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AllLessonsButtonActionPerformed

    private void openAllLessons() {
        jPanel1.removeAll();
        AllLessons allLessonsFrame = new AllLessons();
        jPanel1.add(allLessonsFrame.getContentPane());
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void openFEE() {
        jPanel1.removeAll();
        FEE feeFrame = new FEE();
        jPanel1.add(feeFrame.getContentPane());
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void openECE() {
        jPanel1.removeAll();
        ECE eceFrame = new ECE();
        jPanel1.add(eceFrame.getContentPane());
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllLessonsButton;
    private javax.swing.JButton ECEButton;
    private javax.swing.JButton FEEButton;
    private javax.swing.JLabel PageTitle;
    private javax.swing.JLabel PageTitle1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}

