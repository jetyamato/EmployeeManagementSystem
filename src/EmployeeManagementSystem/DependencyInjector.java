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
package EmployeeManagementSystem;

import Data.Objects.*;
import Data.Source.*;
import Data.Models.*;
import Facades.*;

/**
 *
 * @author josep
 */
public final class DependencyInjector {
  private final LoginFacade loginFacade;
  private final PositionsFacade positionsFacade;
  private final DepartmentsFacade departmentsFacade;
  private final EmployeesFacade employeesFacade;
  
  private DependencyInjector() {
    loginFacade = new LoginFacade(new LoginModel("users", database()));
    positionsFacade = new PositionsFacade(new PositionsModel("positions", database()));
    departmentsFacade = new DepartmentsFacade(new DepartmentsModel("departments", database()));
    employeesFacade = new EmployeesFacade(new EmployeesModel("employees", database()));
  }
  
  private static class DependencyInjectorSingleton {
    private static final DependencyInjector INSTANCE = new DependencyInjector();
  }
  
  public static DependencyInjector getInstance() {
    return DependencyInjectorSingleton.INSTANCE;
  }

  public LoginFacade loginFacade() {
    return loginFacade;
  }

  public PositionsFacade positionsFacade() {
    return positionsFacade;
  }

  public DepartmentsFacade departmentsFacade() {
    return departmentsFacade;
  }
  
  public EmployeesFacade employeesFacade() {
    return employeesFacade;
  }
  
  public Database database() {
    return new Database(
      new MySQLDatabaseConnector(
        "jdbc:mysql://127.0.0.1:3308/employee_management_system",
  "employee_management_system",
  "!%IKe%S+nJP}UfQ"
      )
    );
  }
  
  public Database test_database() {
    return new Database(
      new MySQLDatabaseConnector(
        "jdbc:mysql://127.0.0.1:3308/employee_management_system",
  "root",
  "@dministrator001"
      )
    );
  }
}
