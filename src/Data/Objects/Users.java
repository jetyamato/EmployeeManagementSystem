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

/**
 *
 * @author josep
 */
public class Users {
  
  private int id;
  private String username;
  private String password;
  private int roleId;

  public Users(int _id, String _username, String _password, int _roleId) {
    this.id = _id;
    this.username = _username;
    this.password = _password;
    this.roleId = _roleId;
  }

  public int getId() {
    return id;
  }

  public void setId(int _id) {
    this.id = _id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String _username) {
    this.username = _username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String _password) {
    this.password = _password;
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int _roleId) {
    this.roleId = _roleId;
  }
  
  
}
