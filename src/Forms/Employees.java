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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JComboBox;

import EmployeeManagementSystem.DependencyInjector;
import java.awt.Color;
import javax.swing.table.JTableHeader;

/**
 *
 * @author josep
 */
public final class Employees extends JInternalFrame {

  private final DependencyInjector di = DependencyInjector.getInstance();
  private ArrayList<Data.Objects.Employees> employeesList = di.employeesFacade().getEmployeesList();
  private ArrayList<Data.Objects.Departments> departmentsList = di.departmentsFacade().getDepartmentsList();
  private ArrayList<Data.Objects.Positions> positionsList = di.positionsFacade().getPositionsList();
  private boolean inEditMode = false;
  private Data.Objects.Employees employeeToEdit;
  
  /**
   * Creates new form Positions
   */
  public Employees() {
    initComponents();
    refreshTableContents();
    
    jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
      jTable1ValueChanged(evt);
    });
    
    birthdayPicker.getJCalendar().setWeekOfYearVisible(false);
    birthdayPicker.setFont(new Font("Tahoma", Font.BOLD, 12));
    
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new JScrollPane();
    jTable1 = new JTable();
    jLabel1 = new JLabel();
    txtEmployeeID = new JTextField();
    btnAddOrEdit = new JButton();
    btnSave = new JButton();
    btnExit = new JButton();
    btnDelete = new JButton();
    btnCancel = new JButton();
    lblCount = new JLabel();
    birthdayPicker = new JDateChooser();
    jLabel2 = new JLabel();
    jLabel3 = new JLabel();
    txtLastName = new JTextField();
    jLabel4 = new JLabel();
    txtFirstName = new JTextField();
    jLabel5 = new JLabel();
    txtContactNumber = new JTextField();
    jLabel6 = new JLabel();
    cboDepartment = new JComboBox<>();
    jLabel7 = new JLabel();
    cboPosition = new JComboBox<>();

    setClosable(true);
    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    setIconifiable(true);
    setTitle("Employees");
    setVisible(true);
    addInternalFrameListener(new InternalFrameListener() {
      public void internalFrameActivated(InternalFrameEvent evt) {
      }
      public void internalFrameClosed(InternalFrameEvent evt) {
      }
      public void internalFrameClosing(InternalFrameEvent evt) {
        formInternalFrameClosing(evt);
      }
      public void internalFrameDeactivated(InternalFrameEvent evt) {
      }
      public void internalFrameDeiconified(InternalFrameEvent evt) {
        formInternalFrameDeiconified(evt);
      }
      public void internalFrameIconified(InternalFrameEvent evt) {
      }
      public void internalFrameOpened(InternalFrameEvent evt) {
      }
    });

    jTable1.setModel(new DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "ID", "Employee ID", "Last Name", "First Name", "Birthday", "Contact Number", "Department", "Position"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(jTable1);

    jLabel1.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel1.setText("Employee ID:");

    txtEmployeeID.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    txtEmployeeID.setEnabled(false);

    btnAddOrEdit.setIcon(new ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
    btnAddOrEdit.setText("  Add");
    btnAddOrEdit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnAddOrEditActionPerformed(evt);
      }
    });

    btnSave.setIcon(new ImageIcon(getClass().getResource("/Resources/diskette.png"))); // NOI18N
    btnSave.setText("  Save");
    btnSave.setEnabled(false);
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnSaveActionPerformed(evt);
      }
    });

    btnExit.setIcon(new ImageIcon(getClass().getResource("/Resources/exit.png"))); // NOI18N
    btnExit.setText("  Exit");
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnExitActionPerformed(evt);
      }
    });

    btnDelete.setIcon(new ImageIcon(getClass().getResource("/Resources/delete.png"))); // NOI18N
    btnDelete.setText("  Delete");
    btnDelete.setEnabled(false);
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnDeleteActionPerformed(evt);
      }
    });

    btnCancel.setIcon(new ImageIcon(getClass().getResource("/Resources/close.png"))); // NOI18N
    btnCancel.setText("  Cancel");
    btnCancel.setEnabled(false);
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    lblCount.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    lblCount.setText("Records Found: 0");

    birthdayPicker.setDateFormatString("MMMM dd, yyyy");
    birthdayPicker.setEnabled(false);
    birthdayPicker.setName("Birthday"); // NOI18N

    jLabel2.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel2.setText("Birthday:");

    jLabel3.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel3.setText("Last Name:");

    txtLastName.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    txtLastName.setEnabled(false);

    jLabel4.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel4.setText("First Name:");

    txtFirstName.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    txtFirstName.setEnabled(false);

    jLabel5.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel5.setText("Contact No.:");

    txtContactNumber.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    txtContactNumber.setEnabled(false);

    jLabel6.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel6.setText("Department:");

    cboDepartment.setEnabled(false);

    jLabel7.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
    jLabel7.setText("Position:");

    cboPosition.setEnabled(false);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lblCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(256, 256, 256))
          .addGroup(layout.createSequentialGroup()
            .addComponent(btnAddOrEdit)
            .addGap(18, 18, 18)
            .addComponent(btnSave)
            .addGap(18, 18, 18)
            .addComponent(btnDelete)
            .addGap(18, 18, 18)
            .addComponent(btnCancel)
            .addGap(18, 18, 18)
            .addComponent(btnExit)
            .addGap(0, 589, Short.MAX_VALUE))
          .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
              .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
              .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                  .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(txtFirstName)
                  .addComponent(txtLastName, GroupLayout.Alignment.TRAILING)
                  .addComponent(txtEmployeeID)
                  .addComponent(txtContactNumber)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(birthdayPicker, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(cboPosition, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                  .addComponent(cboDepartment, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE))))
            .addGap(21, 21, 21))))
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(txtEmployeeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1)
          .addComponent(jLabel6)
          .addComponent(cboDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3)
          .addComponent(cboPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(13, 13, 13)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(birthdayPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(txtContactNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(btnAddOrEdit)
          .addComponent(btnSave)
          .addComponent(btnDelete)
          .addComponent(btnCancel)
          .addComponent(btnExit))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
        .addComponent(lblCount)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        .addGap(21, 21, 21))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
    
    Dimension desktopSize = this.getParent().getSize();
    Dimension internalFrameSize = this.getSize();

    this.setLocation(
      (desktopSize.width - internalFrameSize.width) / 2,
      (desktopSize.height - internalFrameSize.height) / 2
    );
  }//GEN-LAST:event_formInternalFrameDeiconified

  private void btnAddOrEditActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddOrEditActionPerformed
    if (btnAddOrEdit.getText().trim().equalsIgnoreCase("add")) {
      txtEmployeeID.setEnabled(true);
      txtLastName.setEnabled(true);
      txtFirstName.setEnabled(true);
      birthdayPicker.setEnabled(true);
      txtContactNumber.setEnabled(true);
      cboDepartment.setEnabled(true);
      cboPosition.setEnabled(true);
      
      btnAddOrEdit.setEnabled(false);
      btnSave.setEnabled(true);
      btnDelete.setEnabled(false);
      btnCancel.setEnabled(true);
      jTable1.setEnabled(false);
    } else {
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
      int selectedId = (int) model.getValueAt(jTable1.getSelectedRow(), 0);
      Data.Objects.Employees i = null;

      for (Data.Objects.Employees p : this.employeesList) {
        if (p.getId() == selectedId) {
          i = p;
          break;
        }
      }

      employeeToEdit = i;

      if (employeeToEdit != null) {
        inEditMode = true;
        
        txtEmployeeID.setText(employeeToEdit.getEmployeeId());
        txtEmployeeID.setEnabled(true);
        txtLastName.setText(employeeToEdit.getLastName());
        txtLastName.setEnabled(true);
        txtFirstName.setText(employeeToEdit.getFirstName());
        txtFirstName.setEnabled(true);
        
        Date convertedToDateBirthday = convertToDate(employeeToEdit.getDateOfBirth());
        birthdayPicker.setDate(convertedToDateBirthday);
        birthdayPicker.setEnabled(true);
        
        txtContactNumber.setText(employeeToEdit.getContactNumber());
        txtContactNumber.setEnabled(true);
        
        for (int a = 0; a < cboDepartment.getItemCount(); a++) {
          Item currentItem = cboDepartment.getItemAt(a);
          
          if (currentItem.getId() == employeeToEdit.getDepartmentId()) {
            cboDepartment.setSelectedItem(currentItem);
            cboDepartment.setEnabled(true);
            break;
          }
        }
        
        for (int a = 0; a < cboPosition.getItemCount(); a++) {
          Item currentItem = cboPosition.getItemAt(a);
          
          if (currentItem.getId() == employeeToEdit.getPositionId()) {
            cboPosition.setSelectedItem(currentItem);
            cboPosition.setEnabled(true);
            break;
          }
        }
        
        btnAddOrEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(true);
        jTable1.setEnabled(false);
      }
    }
  }//GEN-LAST:event_btnAddOrEditActionPerformed

  private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    resetTheForm();
    refreshTableContents();
  }//GEN-LAST:event_btnCancelActionPerformed

  private void btnExitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    resetTheForm();
    refreshTableContents();
    setVisible(false);
  }//GEN-LAST:event_btnExitActionPerformed

  private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    // Validation check
    
    String employeeId = txtEmployeeID.getText();
    String lastName = txtLastName.getText();
    String firstName = txtFirstName.getText();
    String contactNumber = txtContactNumber.getText();
    
    Item selectedDepartment = (Item)cboDepartment.getSelectedItem();
    int departmentId = selectedDepartment.getId();
    
    Item selectedPosition = (Item)cboPosition.getSelectedItem();
    int positionId = selectedPosition.getId();
        
    ArrayList<String> errors = new ArrayList();
    
    if (employeeId.isBlank()) errors.add("Employee ID is missing.");
    if (lastName.isBlank()) errors.add("Last Name is missing.");
    if (firstName.isBlank()) errors.add("First Name is missing.");
    if (contactNumber.isBlank()) errors.add("Contact Number is missing.");

    if (birthdayPicker.getDate() == null) errors.add("Birthday is missing.");
    
    if (cboDepartment.getSelectedIndex() == 0) errors.add("Department is missing.");
    if (cboPosition.getSelectedIndex() == 0) errors.add("Position is missing.");
    
    if (!errors.isEmpty()) {
    
      String errorString = "<html>The following errors occurred:<br>";
      
      for (int i = 0; i < errors.size(); i++) {
        errorString += errors.get(i);
        if (i + 1 < errors.size()) errorString += "<br>";
      }
      
      JOptionPane.showMessageDialog(this, errorString, (inEditMode) ? "Edit" : "Add", JOptionPane.ERROR_MESSAGE);
    
    } else {
      
      LocalDate birthday = convertToLocalDate(birthdayPicker.getDate());
      
      if (inEditMode) {
        employeeToEdit.setEmployeeId(employeeId);
        employeeToEdit.setLastName(lastName);
        employeeToEdit.setFirstName(firstName);
        employeeToEdit.setDateOfBirth(birthday);
        employeeToEdit.setContactNumber(contactNumber);
        employeeToEdit.setDepartmentId(departmentId);
        employeeToEdit.setPositionId(positionId);
        
        for (Data.Objects.Employees p : this.employeesList) {
          if (p.getId() == employeeToEdit.getId()) {
            p.setEmployeeId(employeeToEdit.getEmployeeId());
            p.setLastName(employeeToEdit.getLastName());
            p.setFirstName(employeeToEdit.getFirstName());
            p.setDateOfBirth(employeeToEdit.getDateOfBirth());
            p.setContactNumber(employeeToEdit.getContactNumber());
            p.setDepartmentId(employeeToEdit.getDepartmentId());
            p.setPositionId(employeeToEdit.getPositionId());
            break;
          }
        }
        
        di.employeesFacade().save(employeeToEdit, false);
        
      } else {
        Data.Objects.Employees newEmployee = new Data.Objects.Employees(
          employeesList.size() + 1,
          employeeId,
          lastName,
          firstName,
          birthday,
          departmentId,
          positionId,
          contactNumber
        );

        employeesList.add(newEmployee);
        
        di.employeesFacade().save(newEmployee, true);
      }
      
      resetTheForm();
      refreshTableContents();
      
      JOptionPane.showMessageDialog(this, inEditMode ? "Employee edited successfully." : "Employee added successfully.", inEditMode ? "Edit" : "Add", JOptionPane.INFORMATION_MESSAGE);
    }
  }//GEN-LAST:event_btnSaveActionPerformed

  private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    
    if (choice == JOptionPane.YES_OPTION) {
      DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
      int selectedId = (int) model.getValueAt(jTable1.getSelectedRow(), 0);
      Data.Objects.Employees employeeToDelete = null;
      
      for (Data.Objects.Employees p : this.employeesList) {
        if (p.getId() == selectedId) {
          employeeToDelete = p;
          break;
        }
      }
        
      di.employeesFacade().delete(employeeToDelete);

      resetTheForm();
      refreshTableContents();
      
      JOptionPane.showMessageDialog(this, "Employee Deleted Successfully.", "Delete", JOptionPane.INFORMATION_MESSAGE);
    }
  }//GEN-LAST:event_btnDeleteActionPerformed

  private void formInternalFrameClosing(InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
    resetTheForm();
    refreshTableContents();
  }//GEN-LAST:event_formInternalFrameClosing


  // Variables declaration - do not modify//GEN-BEGIN:variables
  JDateChooser birthdayPicker;
  JButton btnAddOrEdit;
  JButton btnCancel;
  JButton btnDelete;
  JButton btnExit;
  JButton btnSave;
  JComboBox<Item> cboDepartment;
  JComboBox<Item> cboPosition;
  JLabel jLabel1;
  JLabel jLabel2;
  JLabel jLabel3;
  JLabel jLabel4;
  JLabel jLabel5;
  JLabel jLabel6;
  JLabel jLabel7;
  JScrollPane jScrollPane1;
  JTable jTable1;
  JLabel lblCount;
  JTextField txtContactNumber;
  JTextField txtEmployeeID;
  JTextField txtFirstName;
  JTextField txtLastName;
  // End of variables declaration//GEN-END:variables

  private void refreshData() {
    departmentsList = di.departmentsFacade().getDepartmentsList();
    positionsList = di.positionsFacade().getPositionsList();
    employeesList = di.employeesFacade().getEmployeesList();
    
    cboDepartment.removeAllItems();
    cboDepartment.addItem(new Item(0, "---Select Department---"));
    for (Data.Objects.Departments p : this.departmentsList) {
      Item itemFromDb = new Item(p.getId(), p.getDepartmentName());
      cboDepartment.addItem(itemFromDb);
    }
    
    cboPosition.removeAllItems();
    cboPosition.addItem(new Item(0, "---Select Position---"));
    for (Data.Objects.Positions p : this.positionsList) {
      Item itemFromDb = new Item(p.getId(), p.getPositionName());
      cboPosition.addItem(itemFromDb);
    }
  }
    
  private void refreshTableContents() {
    refreshData();
    
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    
    model.setRowCount(0);
    
    int count = 0;
    
    for (Data.Objects.Employees p : this.employeesList) {
      String department = null, position = null;
      
      for (int i = 0; i < departmentsList.size(); i++) {
        Data.Objects.Departments currentDepartment = departmentsList.get(i);
        
        if (p.getDepartmentId() == currentDepartment.getId()) department = currentDepartment.getDepartmentName();
      }
      
      for (int i = 0; i < positionsList.size(); i++) {
        Data.Objects.Positions currentPosition = positionsList.get(i);
        
        if (p.getPositionId() == currentPosition.getId()) position = currentPosition.getPositionName();
      }
      
      model.addRow(
        new Object[] {
          p.getId(),
          p.getEmployeeId(),
          p.getLastName(),
          p.getFirstName(),
          p.getDateOfBirth().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")),
          p.getContactNumber(),
          department,
          position
        }
      );
      ++count;
    }
    
    lblCount.setText("Records Found: " + count);
    
    adjustColumnWidths();
  }
  
  private void jTable1ValueChanged(ListSelectionEvent evt) {
    if (jTable1.getSelectionModel().isSelectionEmpty()) {
      btnAddOrEdit.setIcon(new ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
      btnAddOrEdit.setText("  Add");
      btnAddOrEdit.setEnabled(true);
      btnCancel.setText("  Cancel");
      btnCancel.setEnabled(false);
      btnDelete.setEnabled(false);
    }
    else {
      btnAddOrEdit.setIcon(new ImageIcon(getClass().getResource("/Resources/edit.png"))); // NOI18N
      btnAddOrEdit.setText("  Edit");
      btnAddOrEdit.setEnabled(true);
      btnCancel.setText("  Unselect");
      btnCancel.setEnabled(true);
      btnDelete.setEnabled(true);
    }
  }
  
  private void resetTheForm() {
    txtEmployeeID.setText("");
    txtEmployeeID.setEnabled(false);
    txtLastName.setText("");
    txtLastName.setEnabled(false);
    txtFirstName.setText("");
    txtFirstName.setEnabled(false);
    birthdayPicker.setDate(null);
    birthdayPicker.setEnabled(false);
    txtContactNumber.setText("");
    txtContactNumber.setEnabled(false);
    cboDepartment.setSelectedIndex(0);
    cboDepartment.setEnabled(false);
    cboPosition.setSelectedIndex(0);
    cboPosition.setEnabled(false);
    btnAddOrEdit.setIcon(new ImageIcon(getClass().getResource("/Resources/add.png"))); // NOI18N
    btnAddOrEdit.setText("  Add");
    btnAddOrEdit.setEnabled(true);
    btnSave.setEnabled(false);
    btnDelete.setEnabled(false);
    btnCancel.setText("  Cancel");
    btnCancel.setEnabled(false);
    jTable1.setEnabled(true);
  }
  
  private void adjustColumnWidths() {
    JTableHeader headers = jTable1.getTableHeader();
    headers.setForeground(Color.BLUE);
    
    TableColumn idColumn = jTable1.getColumnModel().getColumn(0);
    idColumn.setPreferredWidth(50);
    
    TableColumn employeeIdColumn = jTable1.getColumnModel().getColumn(1);
    employeeIdColumn.setPreferredWidth(150);
    
    TableColumn lastNameColumn = jTable1.getColumnModel().getColumn(2);
    lastNameColumn.setPreferredWidth(150);
    
    TableColumn firstNameColumn = jTable1.getColumnModel().getColumn(3);
    firstNameColumn.setPreferredWidth(150);
    
    TableColumn birthdayColumn = jTable1.getColumnModel().getColumn(4);
    birthdayColumn.setPreferredWidth(100);
    
    TableColumn contactNumberColumn = jTable1.getColumnModel().getColumn(5);
    contactNumberColumn.setPreferredWidth(100);
    
    TableColumn departmentColumn = jTable1.getColumnModel().getColumn(6);
    departmentColumn.setPreferredWidth(300);
    
    TableColumn positionColumn = jTable1.getColumnModel().getColumn(7);
    positionColumn.setPreferredWidth(100);
    
  }

  private LocalDate convertToLocalDate(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
  
  private Date convertToDate(LocalDate dateToConvert) {
    return Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }
}

class Item {
  private int id;
  private String name;
  
  Item(int _id, String _name) {
    id = _id;
    name = _name;
  }

  public int getId() {
    return id;
  }

  public String toString() {
    return name;
  }
  
}
