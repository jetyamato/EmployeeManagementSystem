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

import Data.Models.DepartmentsModel;
import Data.Objects.Departments;

/**
 *
 * @author josep
 */
public class DepartmentsFacade {
  
  private final DepartmentsModel departmentsModel;

  public DepartmentsFacade(DepartmentsModel _departmentsModel) {
    this.departmentsModel = _departmentsModel;
  }
  
  public ArrayList<Departments> getDepartmentsList() {
    ArrayList<Departments> departmentsList = new ArrayList();
    
    try (ResultSet rs = departmentsModel.getAll()) {
      int size = 0;
      
      if (rs != null) {
        rs.last();
        size = rs.getRow();
        rs.beforeFirst();
      }
      
      if (size > 0) {
        while (rs.next()) {
          departmentsList.add(
            new Departments(
              rs.getInt(1),
     rs.getString(2),
     rs.getString(3)
            )
          );
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    
    return departmentsList;
  }
  
  public void save(Departments _department, boolean toCreate) {
    Object[][] fields_and_values = {
      {"department_code", _department.getDepartmentCode(), "string"},
      {"department_name", _department.getDepartmentName(), "string"},
    };
    
    if (toCreate) departmentsModel.insertEntry(fields_and_values);
    else departmentsModel.updateEntry(_department.getId(), fields_and_values);
  }
  
  public void delete(Departments _department) {
    
    departmentsModel.deleteEntry(_department.getId());
  }
}
