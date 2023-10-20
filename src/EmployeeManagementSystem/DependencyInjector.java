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

import Data.Objects.Departments;
import Data.Objects.Employees;
import Data.Objects.Positions;
import Facades.LoginFacade;
import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class DependencyInjector {
  private final ArrayList<Data.Objects.Departments> departmentsList;
  private final ArrayList<Data.Objects.Positions> positionsList;
  private final ArrayList<Data.Objects.Employees> employeesList;
  private final LoginFacade loginFacade;
  
  private DependencyInjector() {
    departmentsList = Data.Mock.Database.departments();
    positionsList = Data.Mock.Database.positions();
    employeesList = Data.Mock.Database.employees();
    loginFacade = LoginFacade.getInstance();
  }
  
  private static class DependencyInjectorSingleton {
    private static final DependencyInjector INSTANCE = new DependencyInjector();
  }
  
  public static DependencyInjector getInstance() {
    return DependencyInjectorSingleton.INSTANCE;
  }

  public ArrayList<Departments> getDepartmentsList() {
    return departmentsList;
  }

  public ArrayList<Positions> getPositionsList() {
    return positionsList;
  }

  public ArrayList<Employees> getEmployeesList() {
    return employeesList;
  }

  public LoginFacade loginFacade() {
    return loginFacade;
  }
  
}
