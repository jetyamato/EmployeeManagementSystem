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
package Data.Mock;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author josep
 */
class Employees {
  
  static ArrayList<Data.Objects.Employees> generate() {
    ArrayList<Data.Objects.Employees> employeesList = new ArrayList();
    
    employeesList.add(
      new Data.Objects.Employees(
          1,
    "TCSDI-2023-00001",
      "Tamayo",
     "Joseph",
    LocalDate.of(1995, Month.MAY, 12),
   1,
    1,
  "09171234567"
      )
    );
    
    employeesList.add(
      new Data.Objects.Employees(
          2,
    "TCSDI-2023-00002",
      "Salazar",
     "Alfred",
    LocalDate.of(1985, Month.JUNE, 12),
   2,
    1,
  "09951234567"
      )
    );
    
    employeesList.add(
      new Data.Objects.Employees(
          3,
    "TCSDI-2023-00003",
      "Miranda",
     "Miles",
    LocalDate.of(1992, Month.JULY, 12),
   3,
    1,
  "09681234567"
      )
    );
    
    employeesList.add(
      new Data.Objects.Employees(
          4,
    "TCSDI-2023-00004",
      "Fernandez",
     "Rene",
    LocalDate.of(1989, Month.APRIL, 12),
   1,
    4,
  "09651234567"
      )
    );
    
    return employeesList;
  }
}
