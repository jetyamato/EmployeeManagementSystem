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
package Data.Models;

import Data.Objects.Database;
import java.sql.ResultSet;

/**
 *
 * @author josep
 */
public class DepartmentsModel extends Model {

  public DepartmentsModel(String _tableName, Database _database) {
    super(_tableName, _database);
  }

  @Override
  public void deleteEntry(int _id) {
    super.deleteEntry(_id);
  }

  @Override
  public void updateEntry(int id, Object[][] _fields_and_values) {
    super.updateEntry(id, _fields_and_values);
  }

  @Override
  public void insertEntry(Object[][] _fields_and_values) {
    super.insertEntry(_fields_and_values);
  }

  @Override
  public ResultSet getEntry(String[][] _criteria) {
    return super.getEntry(_criteria);
  }

  @Override
  public ResultSet getAll() {
    return super.getAll();
  }
  
  
}
