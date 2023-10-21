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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author josep
 */
abstract class Model {
  protected final Database database;
  protected final String tableName;
  
  public Model( String _tableName, Database _database ) {
  
    database = _database;
    tableName = _tableName;
  }
  
  protected ResultSet getAll() {
    
    String sql = "SELECT * FROM " + tableName;
    ResultSet rs = null;
    
    try {
      Connection dbcon = database.connect();
      PreparedStatement ps = dbcon.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = ps.executeQuery();
      
      System.out.println(sql);

    } catch ( Exception e ) {
      System.out.println( e.getMessage() );
    }
    
    return rs;
  }

  protected ResultSet getEntry( String[][] criteria ) {
    
    String sql = "SELECT * FROM " + tableName + " WHERE ";
    
    for (String[] criterion : criteria) {
      sql += criterion[0] + criterion[1];
    }
    
    ResultSet rs = null;
    
    try {
      Connection dbcon = database.connect();
      PreparedStatement ps = dbcon.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = ps.executeQuery();
      
      System.out.println(sql);

    } catch ( Exception e ) {
      System.out.println( e.getMessage() );
    }
    return rs;
  }
  
  protected void insertEntry( Object[][] fields_and_values ) {
    String sql = "INSERT INTO " + tableName;
    String fields = "(", values = "(";
    
    for ( int i = 0; i < fields_and_values.length; i++ ) {
      fields += fields_and_values[i][0];
      values += "?";
      if (fields_and_values.length > 1 && i + 1 < fields_and_values.length) {
        fields += ", ";
        values += ", ";
      }
    }
    fields += ")";
    values += ")";
    
    sql += " " + fields + " VALUES " + values;
    
    try {
      Connection dbcon = database.connect();
      PreparedStatement ps = dbcon.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      for ( int i = 0; i < fields_and_values.length; i++ ) {
        switch ((String)fields_and_values[i][2]) {
          case "string" -> ps.setString(i + 1, (String)fields_and_values[i][1]);
          case "float" -> ps.setFloat(i + 1, (float)fields_and_values[i][1]);
          case "double" -> ps.setDouble(i + 1, (double)fields_and_values[i][1]);
          case "int" -> ps.setInt(i + 1, (int)fields_and_values[i][1]);
        }
      }
      
      ps.executeUpdate();
      
      System.out.println(sql);
      dbcon.close();
    } catch ( Exception e ) {
      System.out.println( e.getMessage() );
    }
  }
  
  protected void updateEntry( int id, Object[][] fields_and_values ) {
    String sql = "UPDATE " + tableName + " SET ";
    String field_value_pairs = "";
    
    for ( int i = 0; i < fields_and_values.length; i++ ) {
      field_value_pairs += fields_and_values[i][0] + " = ?";
      
      if (fields_and_values.length > 1 && i + 1 < fields_and_values.length) {
        field_value_pairs += ", ";
      }
    }
    field_value_pairs += " WHERE id = ?";
    
    sql += field_value_pairs;
    
    try {
      Connection dbcon = database.connect();
      PreparedStatement ps = dbcon.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      for ( int i = 0; i < fields_and_values.length; i++ ) {
        switch ((String)fields_and_values[i][2]) {
          case "string" -> ps.setString(i + 1, (String)fields_and_values[i][1]);
          case "float" -> ps.setFloat(i + 1, (float)fields_and_values[i][1]);
          case "double" -> ps.setDouble(i + 1, (double)fields_and_values[i][1]);
          case "int" -> ps.setInt(i + 1, (int)fields_and_values[i][1]);
        }
      }
      
      ps.setInt(fields_and_values.length + 1, id);
      
      ps.executeUpdate();
      
      System.out.println(sql);
      dbcon.close();
    } catch ( Exception e ) {
      System.out.println( e.getMessage() );
    }
  }
  
  protected void deleteEntry( int id ) {
    String sql = "DELETE FROM " + tableName + " WHERE id = ?";
    
    try {
      Connection dbcon = database.connect();
      PreparedStatement ps = dbcon.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      
      ps.setInt(1, id);
      
      ps.executeUpdate();
      
      System.out.println(sql);
      dbcon.close();
    } catch ( Exception e ) {
      System.out.println( e.getMessage() );
    }
  }
}
