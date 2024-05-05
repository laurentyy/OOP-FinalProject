package com.oopProj.form.Assessment_questionSet1;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JOptionPane;

public class Assessments extends javax.swing.JFrame {

   Timer timer;
   int timeLeft = 60;
   int currentQuestionNo = 1;
   
    public Assessments() {
        initComponents();
        Connect();
        LoadQuestions();
    opt1.addActionListener(e -> enableNextButton());
    opt2.addActionListener(e -> enableNextButton());
    opt3.addActionListener(e -> enableNextButton());
    opt4.addActionListener(e -> enableNextButton());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        dateTxt.setText(sdf.format(now));
        
         timer = new Timer(1000, (e) -> {
            timeLeft--;
            // Update the display of minutes and seconds
            int minutesLeft = timeLeft / 60;
            int secondsLeft = timeLeft % 60;
            minutes.setText(String.format("%02d", minutesLeft));
            seconds.setText(String.format("%02d", secondsLeft));
            // If time is up, stop the timer and show a message
            if (timeLeft <= 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Time's up! Your score: " + txtmarks.getText() + " points.");
            }
        });
        timer.start(); // Start the timer
        
    }
    private void enableNextButton() {
    nextButton.setEnabled(opt1.isSelected() || opt2.isSelected() || opt3.isSelected() || opt4.isSelected());
}
    
    int answercheck = 0;
    int marks = 0;
    
    String cor = null;
    String answer = null;
    Statement stat;
    
    public boolean answerCheck(){
        
        String answerAnswer = "";
        if(opt1.isSelected()){
            answerAnswer = opt1.getText();
        }else if(opt2.isSelected()){
            answerAnswer = opt2.getText();
        }else if(opt3.isSelected()){
            answerAnswer = opt3.getText();
        }else if(opt4.isSelected()){
            answerAnswer = opt4.getText();
        }
        if(answerAnswer.equals(cor) && (answer == null || !answer.equals(cor))){
            marks++;
            answercheck++;
            txtmarks.setText(String.valueOf(marks));
        }
    
    // Update given answer in the database
    if (!answerAnswer.equals("")) {
        try {
            String query = "UPDATE question SET givenanswer = ? WHERE question = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, answerAnswer);
            pst.setString(2, questionstatement.getText());
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    return false;
}
    
    private void NullAllGivenAnswers(){
        try{
            String query = "UPDATE question SET givenanswer = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, null);
            pst.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
  
    private boolean AlreadyAnswered(){
        try{
            String query = "SELECT givenanswer FROM question WHERE question = '"+questionstatement.getText()+"'";
            stat = con.prepareStatement(query);
            
            ResultSet res = stat.executeQuery(query);
            
            while(res.next()){
                answer = res.getString("givenanswer");
                if(answer == null){
                    return false;
                }
                break;
            }
            if (opt1.getText().equals(answer)){
            opt1.setSelected(true);
            }else if (opt2.getText().equals(answer)){
            opt2.setSelected(true);
            }else if (opt3.getText().equals(answer)){
            opt3.setSelected(true);
            }else if (opt4.getText().equals(answer)){
            opt4.setSelected(true);
        }
    }catch (SQLException ex){
        System.out.println("Exception Caught");
        ex.printStackTrace();
    }
        return true;
    }
    
    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    
        public void Connect(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/circulate_user_database","root","");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(question.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex){
                Logger.getLogger(question.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    public void LoadQuestions()
    {
        String query = "select * from question";
        Statement stat = null;
        
        try {
            stat = con.createStatement();
            rs = stat.executeQuery(query);
            
            while(rs.next()){
                questionNo.setText(rs.getString(1));
                questionstatement.setText(rs.getString(2));
                opt1.setText(rs.getString(3));
                opt2.setText(rs.getString(4));
                opt3.setText(rs.getString(5));
                opt4.setText(rs.getString(6));
                cor = rs.getString(7);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Assessments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        questionNo = new javax.swing.JLabel();
        questionstatement = new javax.swing.JLabel();
        opt1 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        opt3 = new javax.swing.JRadioButton();
        opt4 = new javax.swing.JRadioButton();
        questionNoTxt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmarks = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        seconds = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(645, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(645, 500));
        jPanel1.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(215, 208, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(449, 332));

        jPanel2.setBackground(new java.awt.Color(153, 145, 203));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setDoubleBuffered(false);
        jPanel2.setFocusTraversalPolicyProvider(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(345, 225));

        questionNo.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        questionNo.setText("1");

        questionstatement.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        questionstatement.setText("Statement");

        opt1.setBackground(new java.awt.Color(153, 145, 203));
        buttonGroup1.add(opt1);
        opt1.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        opt1.setText("Option1");
        opt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ActionPerformed(evt);
            }
        });

        opt2.setBackground(new java.awt.Color(153, 145, 203));
        buttonGroup1.add(opt2);
        opt2.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        opt2.setText("Option2");

        opt3.setBackground(new java.awt.Color(153, 145, 203));
        buttonGroup1.add(opt3);
        opt3.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        opt3.setText("Option3");

        opt4.setBackground(new java.awt.Color(153, 145, 203));
        buttonGroup1.add(opt4);
        opt4.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        opt4.setText("Option4");

        questionNoTxt.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        questionNoTxt.setText("Question no.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt1)
                    .addComponent(opt2)
                    .addComponent(opt3)
                    .addComponent(opt4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(questionNoTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionNo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(questionstatement, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNo)
                    .addComponent(questionNoTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionstatement)
                .addGap(24, 24, 24)
                .addComponent(opt1)
                .addGap(18, 18, 18)
                .addComponent(opt2)
                .addGap(18, 18, 18)
                .addComponent(opt3)
                .addGap(18, 18, 18)
                .addComponent(opt4)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel8.setText("POINT/S: ");

        txtmarks.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        txtmarks.setText("0");

        nextButton.setBackground(new java.awt.Color(185, 177, 238));
        nextButton.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        nextButton.setForeground(new java.awt.Color(0, 0, 0));
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nextCircle.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel10.setText("| TOTAL QUESTION: 10");

        restartButton.setBackground(new java.awt.Color(185, 177, 238));
        restartButton.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        restartButton.setForeground(new java.awt.Color(0, 0, 0));
        restartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset1.png"))); // NOI18N
        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(39, 39, 39)
                .addComponent(restartButton)
                .addGap(3, 3, 3)
                .addComponent(nextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtmarks)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(restartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 145, 203));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Istok Web", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TIMER");

        minutes.setBackground(new java.awt.Color(215, 208, 255));
        minutes.setFont(new java.awt.Font("Istok Web", 1, 24)); // NOI18N
        minutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minutes.setText("00");
        minutes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minutes.setOpaque(true);

        seconds.setBackground(new java.awt.Color(215, 208, 255));
        seconds.setFont(new java.awt.Font("Istok Web", 1, 24)); // NOI18N
        seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seconds.setText("00");
        seconds.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seconds.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(215, 208, 255));
        jLabel4.setFont(new java.awt.Font("Istok Web", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(":");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        submitButton.setBackground(new java.awt.Color(185, 177, 238));
        submitButton.setFont(new java.awt.Font("Istok Web", 1, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(0, 0, 0));
        submitButton.setText("SUBMIT");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Istok Web", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL TIME:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Istok Web", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DATE:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Istok Web", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("1 MINUTE");

        dateTxt.setBackground(new java.awt.Color(255, 255, 255));
        dateTxt.setFont(new java.awt.Font("Istok Web", 1, 18)); // NOI18N
        dateTxt.setForeground(new java.awt.Color(255, 255, 255));
        dateTxt.setText("TOTAL TIME");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel5)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(dateTxt)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(64, 64, 64))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minutes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seconds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(submitButton))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt1ActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        timer.stop();
    
    int marks = Integer.parseInt(txtmarks.getText());
    String message;
    
    if (marks == 0) {
        message = "Oops! Your score is 0 point. Better luck next time!";
    } else if (marks >= 1 && marks <= 5) {
        message = "Not bad! Your score is " + marks + " point/s.";
    } else if (marks >= 6 && marks <= 7) {
        message = "Great job! Your score is " + marks + " points.";
    } else if (marks >= 8 && marks <= 10) {
        message = "Excellent! Your score is " + marks + " points.";
    } else {
        message = "Invalid score!";
    }
    
    JOptionPane.showMessageDialog(this, message);

    }//GEN-LAST:event_submitButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        if (!answerCheck()) {
        // Show a message asking the user to select an option
        JOptionPane.showMessageDialog(this, "Please select an option before proceeding to the next question.");
        return;
    }

    try {
        if (rs.next()) {
            ++currentQuestionNo; // Increment current question number
            questionNo.setText(Integer.toString(currentQuestionNo)); // Update question number label

            questionstatement.setText(rs.getString("question"));
            opt1.setText(rs.getString(3));
            opt2.setText(rs.getString(4));
            opt3.setText(rs.getString(5));
            opt4.setText(rs.getString(6));
            cor = rs.getString(7);

            // Clear radio button selection
            buttonGroup1.clearSelection();

        } else {
            submitButton.setEnabled(true);
            nextButton.setVisible(false);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
    // Reset currentQuestionNo to 1
    currentQuestionNo = 1;
    questionNo.setText(Integer.toString(currentQuestionNo)); // Update question number label

    // Reset marks to 0 and update the display
    marks = 0;
    txtmarks.setText("0");

    // Reload the first question
    LoadQuestions();

    // Reset timer
    timeLeft = 60;
    timer.restart();
    
    nextButton.setVisible(true);
    }//GEN-LAST:event_restartButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Assessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assessments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assessments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel minutes;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton opt1;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt3;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JLabel questionNo;
    private javax.swing.JLabel questionNoTxt;
    private javax.swing.JLabel questionstatement;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel seconds;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel txtmarks;
    // End of variables declaration//GEN-END:variables
}
