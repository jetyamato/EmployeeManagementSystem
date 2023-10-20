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

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import EmployeeManagementSystem.App;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

/**
 *
 * @author josep
 */
public class Main extends javax.swing.JFrame {

  private Positions positionsFrame;
  private Departments departmentsFrame;
  private Employees employeesFrame;
  private About aboutFrame;
  private List listFrame;
  private final Timer timer;
  
  /**
   * Creates new form Main
   */
  public Main() {
    initComponents();
    setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    lblCurrentUser.setFont(new Font("JetBrains Mono", Font.PLAIN, 48));
    lblCurrentUser.setForeground(Color.white);
    lblClock.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
    lblClock.setForeground(Color.white);
    lblDate.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
    lblDate.setForeground(Color.white);
    jDesktopPane1.setDesktopManager(new DefaultDesktopManager() {
      
      @Override
      public void dragFrame(JComponent f, int x, int y) {
        if (f instanceof JInternalFrame) {
          JInternalFrame frame = (JInternalFrame) f;
          JDesktopPane desk = frame.getDesktopPane();
          Dimension d = desk.getSize();

          if (x < 0) {
            x = 0;
          } else {
            if (x + frame.getWidth() > d.width) {
              x = d.width - frame.getWidth();
            }
          }
          if (y < 0) {
            y = 0;
          } else {
            if (y + frame.getHeight() > d.height) {
              y = d.height - frame.getHeight();
            }
          }
        }

        super.dragFrame(f, x, y);
      }
    });
    
    int delay = 100;
    
    timer = new Timer(delay, (ActionEvent evt) -> {
      LocalDateTime dateTime = LocalDateTime.now();
      lblClock.setText(dateTime.format(DateTimeFormatter.ofPattern("h:mm:ss a")));
      lblDate.setText(dateTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
    });
    
    timer.start();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jDesktopPane1 = new javax.swing.JDesktopPane();
    lblCurrentUser = new javax.swing.JLabel();
    lblClock = new javax.swing.JLabel();
    lblDate = new javax.swing.JLabel();
    mainMenuBar = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    employeesListMenuItem = new javax.swing.JMenuItem();
    departmentsMenuItem = new javax.swing.JMenuItem();
    positionsMenuItem = new javax.swing.JMenuItem();
    employeesMenuItem = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    exitMenuItem = new javax.swing.JMenuItem();
    helpMenu = new javax.swing.JMenu();
    aboutMenuItem = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setTitle("Employee Management System");
    setUndecorated(true);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
      public void windowOpened(java.awt.event.WindowEvent evt) {
        formWindowOpened(evt);
      }
    });

    jDesktopPane1.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);

    lblCurrentUser.setText("Welcome, User");

    lblClock.setText("System Time:");

    lblDate.setText("System Date:");

    jDesktopPane1.setLayer(lblCurrentUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(lblClock, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(lblDate, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
      jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jDesktopPane1Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jDesktopPane1Layout.createSequentialGroup()
            .addComponent(lblCurrentUser)
            .addContainerGap(819, Short.MAX_VALUE))
          .addGroup(jDesktopPane1Layout.createSequentialGroup()
            .addComponent(lblClock)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDate)
            .addGap(23, 23, 23))))
    );
    jDesktopPane1Layout.setVerticalGroup(
      jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jDesktopPane1Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(lblCurrentUser)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lblClock)
          .addComponent(lblDate))
        .addGap(44, 44, 44))
    );

    getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

    fileMenu.setText("File");

    employeesListMenuItem.setText("List of Employees");
    employeesListMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        employeesListMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(employeesListMenuItem);

    departmentsMenuItem.setText("Departments");
    departmentsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        departmentsMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(departmentsMenuItem);

    positionsMenuItem.setText("Positions");
    positionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        positionsMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(positionsMenuItem);

    employeesMenuItem.setText("Employees");
    employeesMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        employeesMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(employeesMenuItem);
    fileMenu.add(jSeparator1);

    exitMenuItem.setText("Exit");
    exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(exitMenuItem);

    mainMenuBar.add(fileMenu);

    helpMenu.setText("Help");

    aboutMenuItem.setText("About");
    aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        aboutMenuItemActionPerformed(evt);
      }
    });
    helpMenu.add(aboutMenuItem);

    mainMenuBar.add(helpMenu);

    setJMenuBar(mainMenuBar);

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void employeesListMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_employeesListMenuItemActionPerformed
    if (listFrame == null) {
      listFrame = new List();

      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = listFrame.getSize();

      listFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      listFrame.toFront();
      listFrame.repaint();
      
      jDesktopPane1.add(listFrame);
    }
    else {
      if (listFrame.isIcon()) {
        try {
          
          Dimension desktopSize = jDesktopPane1.getSize();
          Dimension internalFrameSize = listFrame.getSize();

          listFrame.setLocation(
            (desktopSize.width - internalFrameSize.width) / 2,
            (desktopSize.height - internalFrameSize.height) / 2
          );
          
          listFrame.toFront();
          listFrame.repaint();
          
          listFrame.setIcon(false);
        } catch (PropertyVetoException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else if (!listFrame.isVisible()) {
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension internalFrameSize = listFrame.getSize();

        listFrame.setLocation(
          (desktopSize.width - internalFrameSize.width) / 2,
          (desktopSize.height - internalFrameSize.height) / 2
        );
        
        listFrame.toFront();
        listFrame.repaint();
        
        listFrame.setVisible(true);
      }
    }
  }//GEN-LAST:event_employeesListMenuItemActionPerformed

  private void positionsMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_positionsMenuItemActionPerformed
    
    if (positionsFrame == null) {
      positionsFrame = new Positions();

      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = positionsFrame.getSize();

      positionsFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      positionsFrame.toFront();
      positionsFrame.repaint();
      
      jDesktopPane1.add(positionsFrame);
    }
    else {
      if (positionsFrame.isIcon()) {
        try {
          
          Dimension desktopSize = jDesktopPane1.getSize();
          Dimension internalFrameSize = positionsFrame.getSize();

          positionsFrame.setLocation(
            (desktopSize.width - internalFrameSize.width) / 2,
            (desktopSize.height - internalFrameSize.height) / 2
          );
          
          positionsFrame.toFront();
          positionsFrame.repaint();
          
          positionsFrame.setIcon(false);
        } catch (PropertyVetoException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else if (!positionsFrame.isVisible()) {
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension internalFrameSize = positionsFrame.getSize();

        positionsFrame.setLocation(
          (desktopSize.width - internalFrameSize.width) / 2,
          (desktopSize.height - internalFrameSize.height) / 2
        );
        
        positionsFrame.toFront();
        positionsFrame.repaint();
        
        positionsFrame.setVisible(true);
      }
    }
  }//GEN-LAST:event_positionsMenuItemActionPerformed

  private void exitMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    confirmClose();
  }//GEN-LAST:event_exitMenuItemActionPerformed

  private void departmentsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentsMenuItemActionPerformed
    
    if (departmentsFrame == null) {
      departmentsFrame = new Departments();

      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = departmentsFrame.getSize();

      departmentsFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      departmentsFrame.toFront();
      departmentsFrame.repaint();
      
      jDesktopPane1.add(departmentsFrame);
    }
    else {
      if (departmentsFrame.isIcon()) {
        try {
          
          Dimension desktopSize = jDesktopPane1.getSize();
          Dimension internalFrameSize = departmentsFrame.getSize();

          departmentsFrame.setLocation(
            (desktopSize.width - internalFrameSize.width) / 2,
            (desktopSize.height - internalFrameSize.height) / 2
          );
          
          departmentsFrame.toFront();
          departmentsFrame.repaint();
          
          departmentsFrame.setIcon(false);
        } catch (PropertyVetoException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else if (!departmentsFrame.isVisible()) {
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension internalFrameSize = departmentsFrame.getSize();

        departmentsFrame.setLocation(
          (desktopSize.width - internalFrameSize.width) / 2,
          (desktopSize.height - internalFrameSize.height) / 2
        );
        
        departmentsFrame.toFront();
        departmentsFrame.repaint();
        
        departmentsFrame.setVisible(true);
      }
    }
  }//GEN-LAST:event_departmentsMenuItemActionPerformed

  private void employeesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesMenuItemActionPerformed
    
    if (employeesFrame == null) {
      employeesFrame = new Employees();

      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = employeesFrame.getSize();

      employeesFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      employeesFrame.toFront();
      employeesFrame.repaint();
      
      jDesktopPane1.add(employeesFrame);
    }
    else {
      if (employeesFrame.isIcon()) {
        try {
          
          Dimension desktopSize = jDesktopPane1.getSize();
          Dimension internalFrameSize = employeesFrame.getSize();

          employeesFrame.setLocation(
            (desktopSize.width - internalFrameSize.width) / 2,
            (desktopSize.height - internalFrameSize.height) / 2
          );
          
          employeesFrame.toFront();
          employeesFrame.repaint();
          
          employeesFrame.setIcon(false);
        } catch (PropertyVetoException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else if (!employeesFrame.isVisible()) {
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension internalFrameSize = employeesFrame.getSize();

        employeesFrame.setLocation(
          (desktopSize.width - internalFrameSize.width) / 2,
          (desktopSize.height - internalFrameSize.height) / 2
        );
        
        employeesFrame.toFront();
        employeesFrame.repaint();
        
        employeesFrame.setVisible(true);
      }
    }
  }//GEN-LAST:event_employeesMenuItemActionPerformed

  private void aboutMenuItemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
    
    if (aboutFrame == null) {
      aboutFrame = new About();

      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = aboutFrame.getSize();

      aboutFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      aboutFrame.toFront();
      aboutFrame.repaint();
      
      jDesktopPane1.add(aboutFrame);
    }
    else if (!aboutFrame.isVisible()) {
      Dimension desktopSize = jDesktopPane1.getSize();
      Dimension internalFrameSize = aboutFrame.getSize();

      aboutFrame.setLocation(
        (desktopSize.width - internalFrameSize.width) / 2,
        (desktopSize.height - internalFrameSize.height) / 2
      );

      aboutFrame.toFront();
      aboutFrame.repaint();

      aboutFrame.setVisible(true);
    }
  }//GEN-LAST:event_aboutMenuItemActionPerformed

  private void formWindowClosing(WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    confirmClose();
  }//GEN-LAST:event_formWindowClosing

  private void formWindowOpened(WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    lblCurrentUser.setText("Welcome, " + App.getCurrentUser());
    
    if (App.getCurrentRole().equalsIgnoreCase("user")) {
      departmentsMenuItem.setEnabled(false);
      positionsMenuItem.setEnabled(false);
    }
  }//GEN-LAST:event_formWindowOpened

  private void confirmClose() {
    int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    
    if (choice == JOptionPane.YES_OPTION) {
      timer.stop();
      dispose();
    }
  }
  
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
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  javax.swing.JMenuItem aboutMenuItem;
  javax.swing.JMenuItem departmentsMenuItem;
  javax.swing.JMenuItem employeesListMenuItem;
  javax.swing.JMenuItem employeesMenuItem;
  javax.swing.JMenuItem exitMenuItem;
  javax.swing.JMenu fileMenu;
  javax.swing.JMenu helpMenu;
  javax.swing.JDesktopPane jDesktopPane1;
  javax.swing.JPopupMenu.Separator jSeparator1;
  javax.swing.JLabel lblClock;
  javax.swing.JLabel lblCurrentUser;
  javax.swing.JLabel lblDate;
  javax.swing.JMenuBar mainMenuBar;
  javax.swing.JMenuItem positionsMenuItem;
  // End of variables declaration//GEN-END:variables
}
