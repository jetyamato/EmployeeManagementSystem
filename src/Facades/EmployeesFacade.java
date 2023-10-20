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
package Facades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Models.EmployeesModel;
import Data.Objects.Employees;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author josep
 */
public class EmployeesFacade {
  
  private final EmployeesModel employeesModel;

  public EmployeesFacade(EmployeesModel _employeesModel) {
    this.employeesModel = _employeesModel;
  }
  
  public ArrayList<Employees> getEmployeesList() {
    ArrayList<Employees> employeesList = new ArrayList();
    
    try (ResultSet rs = employeesModel.getAll()) {
      int size = 0;
      
      if (rs != null) {
        rs.last();
        size = rs.getRow();
        rs.beforeFirst();
      }
      
      if (size > 0) {
        while (rs.next()) {
          employeesList.add(
            new Employees(
              rs.getInt(1),
              rs.getString(2),
              rs.getString(3),
              rs.getString(4),
              rs.getDate(5).toLocalDate(),
              rs.getInt(6),
              rs.getInt(7),
              rs.getString(8)
            )
          );
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    
    return employeesList;
  }
  
  public void save(Employees _employee, boolean toCreate) {
    Object[][] fields_and_values = {
      {"employee_id", _employee.getEmployeeId(), "string"},
      {"lastname", _employee.getLastName(), "string"},
      {"firstname", _employee.getFirstName(), "string"},
      {"date_of_birth", _employee.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), "string"},
      {"department_id", _employee.getDepartmentId(), "int"},
      {"position_id", _employee.getPositionId(), "int"},
      {"contact_number", _employee.getContactNumber(), "string"}
    };
    
    if (toCreate) employeesModel.insertEntry(fields_and_values);
    else employeesModel.updateEntry(_employee.getId(), fields_and_values);
  }
  
  public void delete(Employees _employee) {
    
    employeesModel.deleteEntry(_employee.getId());
  }
  
}
