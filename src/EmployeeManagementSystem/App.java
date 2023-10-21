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

import java.awt.EventQueue;
import Forms.SplashScreen;

/**
 *
 * @author josep
 */
public class App {
  
  static void run() {
   /**
    * Show the login form and ask the user to login.
    * When the login succeeds, get the role of the user.
    *
    * MAIN FORM:
    * Show the main form with configurations according to the user's role.
    * There should be a menu bar above with the menus File and Help.
    * A label below the menu bar displays a greeting with the current user's username.
    * Two labels below the main form display the current date and the current time.
    *
    * The File menu contains the items that correspond to the List Form,
    * the Department Form, the Position Form and the Employee Form.
    *
    * The Help menu contains the item that corresponds to the About Form.
    *
    * Every form that will be accessed from the main form must be CHILDREN of the main form.
    * They are confined within the boundaries of the main form.
    *
    * Configuration per role:
    * Users with the admin role CAN access everything in the File menu.
    * Users with the user role CANNOT access the Department Form and the Position Form.
    *
    * LIST FORM:
    * Show the list form with the list of employees.
    * When the user types a search term, the list should be updated
    * with the employees that fulfill the search term.
    *
    * DEPARTMENT FORM:
    * Show the department form with the list of departments and the number of departments.
    * The form must be able to CREATE, READ, UPDATE and DELETE departments.
    *
    * POSITION FORM:
    * Show the position form with the list of positions and the number of positions.
    * The form must be able to CREATE, READ, UPDATE and DELETE positions.
    *
    * EMPLOYEE FORM:
    * Show the employee form with the list of employees and the number of employees.
    * The form must be able to CREATE, READ, UPDATE and DELETE employees.
    *
    * ABOUT FORM:
    * Show the about form with the information about the software.
    *
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

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new SplashScreen().setVisible(true);
      }
    });
    
  }
}
