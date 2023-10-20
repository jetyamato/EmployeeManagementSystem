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

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Data.Models.LoginModel;

/**
 *
 * @author josep
 */
public class LoginFacade {
  
  private final LoginModel loginModel;
  private String currentUser;
  private String currentRole;
  
  public LoginFacade(LoginModel _loginModel) {
    loginModel = _loginModel;
  }
  
  String getEncryptedPass(String _password) {
    String encryptedPass = "";
    
    try {

      MessageDigest md = MessageDigest.getInstance("SHA3-256");
      byte[] digest = md.digest(_password.getBytes(StandardCharsets.UTF_8));

      BigInteger number = new BigInteger(1, digest);
      StringBuilder hexString = new StringBuilder(number.toString(16));

      while (hexString.length() < 64) {
        hexString.insert(0, '0');
      }

      encryptedPass = hexString.toString();

    } catch (NoSuchAlgorithmException e) {   
      System.out.println(e.getMessage());
    }
    
    return encryptedPass;
  }
  
  public boolean verifyLogin(String _username, String _password) {
    _password = getEncryptedPass(_password);
    
    String usernameFromDatabase = "", passwordFromDatabase = "";
    boolean loginOK = false;
    
    try (ResultSet rs = loginModel.getEntry(new String[][] { {"username", " = \"" + _username + "\""} })) {
      int size = 0;
      
      if (rs != null) {
        rs.last();
        size = rs.getRow();
        rs.beforeFirst();
      }
      
      if (size > 0) {
        while (rs.next()) {
          if (_username.equals(rs.getString(4))) {
            usernameFromDatabase = rs.getString(4);
            passwordFromDatabase = rs.getString(5);
          }
          
          loginOK = _username.equals(usernameFromDatabase) && _password.equals(passwordFromDatabase);

          if (loginOK) {
            currentUser = rs.getString(4);
            currentRole = rs.getString(6);
          }
        }
      }
      
      System.out.println("Encrypted Pass: " + _password);
      System.out.println("Database Encrypted Pass: " + passwordFromDatabase);
      
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }

    return loginOK;
  }

  public String getCurrentUser() {
    return currentUser;
  }

  public String getCurrentRole() {
    return currentRole;
  }
  
}
