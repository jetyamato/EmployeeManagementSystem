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
package Data.Objects;

import java.time.LocalDate;

/**
 *
 * @author josep
 */
public class Employees {
  
  private int id;
  private String employeeId;
  private String lastName;
  private String firstName;
  private LocalDate dateOfBirth;
  private int departmentId;
  private int positionId;
  private String contactNumber;
  private int userId;

  public Employees(
    int _id,
    String _employeeId,
    String _lastName,
    String _firstName,
    LocalDate _dateOfBirth,
    int _departmentId,
    int _positionId,
    String _contactNumber,
    int _userId
  ) {
    this.id = _id;
    this.employeeId = _employeeId;
    this.lastName = _lastName;
    this.firstName = _firstName;
    this.dateOfBirth = _dateOfBirth;
    this.departmentId = _departmentId;
    this.positionId = _positionId;
    this.contactNumber = _contactNumber;
    this.userId = _userId;
  }

  public int getId() {
    return id;
  }

  public void setId(int _id) {
    this.id = _id;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String _employeeId) {
    this.employeeId = _employeeId;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String _lastName) {
    this.lastName = _lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String _firstName) {
    this.firstName = _firstName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate _dateOfBirth) {
    this.dateOfBirth = _dateOfBirth;
  }

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int _departmentId) {
    this.departmentId = _departmentId;
  }

  public int getPositionId() {
    return positionId;
  }

  public void setPositionId(int _positionId) {
    this.positionId = _positionId;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String _contactNumber) {
    this.contactNumber = _contactNumber;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int _userId) {
    this.userId = _userId;
  }
  
  
}
