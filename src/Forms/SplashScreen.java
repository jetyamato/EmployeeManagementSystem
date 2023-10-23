/*
 * The MIT License
 *
 * Copyright 2023 JOSEPH EMMANUEL F. TAMAYO.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Forms;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import java.sql.Connection;
import java.sql.SQLException;

import EmployeeManagementSystem.DependencyInjector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author josep
 */
public class SplashScreen extends javax.swing.JFrame {

  /**
   * Creates new form SplashScreen
   */
  public SplashScreen() {
    initComponents();
    jLabel1.setForeground(Color.white);
    lblProgress.setForeground(Color.white);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jProgressBar1 = new JProgressBar();
    jLabel1 = new JLabel();
    lblProgress = new JLabel();
    jLabel2 = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setUndecorated(true);
    addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent evt) {
        formWindowOpened(evt);
      }
    });
    getContentPane().setLayout(new AbsoluteLayout());

    jProgressBar1.setFont(new Font("Arial", 0, 18)); // NOI18N
    jProgressBar1.setStringPainted(true);
    getContentPane().add(jProgressBar1, new AbsoluteConstraints(10, 250, 470, -1));

    jLabel1.setFont(new Font("Arial", 0, 24)); // NOI18N
    jLabel1.setText("Employee Management System");
    getContentPane().add(jLabel1, new AbsoluteConstraints(140, 210, -1, -1));

    lblProgress.setText("Loading...");
    getContentPane().add(lblProgress, new AbsoluteConstraints(6, 278, -1, -1));

    jLabel2.setIcon(new ImageIcon(getClass().getResource("/Resources/blue-1634110_1280.png"))); // NOI18N
    getContentPane().add(jLabel2, new AbsoluteConstraints(0, 0, 490, 300));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
    new Thread(new Runnable() {
      
      public void run() {

        // check if database exists = 20%
        // check if users table exists = 40%
        // check if departments table exists = 60%
        // check if positions table exists = 80%
        // check if employees table exists = 100%
        
        DependencyInjector di = DependencyInjector.getInstance();
        
        int countUp = 0;
          
        Data.Objects.Database test_database = di.test_database();
        Connection dbcon = null;
        
        lblProgress.setText("Checking if database is found...");
        try { dbcon = test_database.connect(); } catch (Exception ex) {
          if (ex instanceof SQLException s && s.getSQLState().equalsIgnoreCase("08s01")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Database not found.\nCheck your database setup and settings.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        countUp += 20;
        jProgressBar1.setValue(countUp);
        try { Thread.sleep(500); } catch (InterruptedException ex) {}

        lblProgress.setText("Checking if Users Table is found...");
        try (
          PreparedStatement ps = dbcon.prepareStatement(
            "SELECT * FROM users",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY
          );
        ) {
          if (ps.execute()) {
            countUp += 20;
            jProgressBar1.setValue(countUp);
            try { Thread.sleep(500); } catch (InterruptedException ex) {}
          }
        } catch (Exception ex) {
          if (ex instanceof SQLException s && s.getSQLState().equalsIgnoreCase("42s02")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Users Table not found.\nCheck your database setup and settings.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }
          
        lblProgress.setText("Checking if Departments Table is found...");
        try (
          PreparedStatement ps = dbcon.prepareStatement(
            "SELECT * FROM departments",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY
          );
        ) {
          if (ps.execute()) {
            countUp += 20;
            jProgressBar1.setValue(countUp);
            try { Thread.sleep(500); } catch (InterruptedException ex) {}
          }
        } catch (Exception ex) {
          if (ex instanceof SQLException s && s.getSQLState().equalsIgnoreCase("42s02")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Departments Table not found.\nCheck your database setup and settings.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        lblProgress.setText("Checking if Positions Table is found...");
        try (
          PreparedStatement ps = dbcon.prepareStatement(
            "SELECT * FROM positions",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY
          );
        ) {
          if (ps.execute()) {
            countUp += 20;
            jProgressBar1.setValue(countUp);
            try { Thread.sleep(500); } catch (InterruptedException ex) {}
          }
        } catch (Exception ex) {
          if (ex instanceof SQLException s && s.getSQLState().equalsIgnoreCase("42s02")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Positions Table not found.\nCheck your database setup and settings.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }
          
        lblProgress.setText("Checking if Employees Table is found...");
        try (
          PreparedStatement ps = dbcon.prepareStatement(
            "SELECT * FROM employees",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY
          );
        ) {
          if (ps.execute()) {
            countUp += 20;
            jProgressBar1.setValue(countUp);
            try { Thread.sleep(500); } catch (InterruptedException ex) {}
          }
        } catch (Exception ex) {
          if (ex instanceof SQLException s && s.getSQLState().equalsIgnoreCase("42s02")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Employees Table not found.\nCheck your database setup and settings.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        dispose();
        EventQueue.invokeLater(new Runnable() {
          public void run() {
            new Login().setVisible(true);
          }
        });
      }
    }).start();
  }//GEN-LAST:event_formWindowOpened

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
      java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    
    /* Create and display the form */
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new SplashScreen().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public JLabel jLabel1;
  public JLabel jLabel2;
  public JProgressBar jProgressBar1;
  public JLabel lblProgress;
  // End of variables declaration//GEN-END:variables
}