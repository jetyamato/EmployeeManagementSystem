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

import Data.Models.PositionsModel;
import Data.Objects.Positions;

/**
 *
 * @author josep
 */
public class PositionsFacade {
  
  private final PositionsModel positionsModel;

  public PositionsFacade(PositionsModel _positionsModel) {
    this.positionsModel = _positionsModel;
  }
  
  public ArrayList<Positions> getPositionsList() {
    ArrayList<Positions> positionsList = new ArrayList();
    
    try (ResultSet rs = positionsModel.getAll()) {
      int size = 0;
      
      if (rs != null) {
        rs.last();
        size = rs.getRow();
        rs.beforeFirst();
      }
      
      if (size > 0) {
        while (rs.next()) {
          positionsList.add(
            new Positions(
          rs.getInt(1),
   rs.getString(2)
            )
          );
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    
    return positionsList;
  }
  
  public void save(Positions _position, boolean toCreate) {
    Object[][] fields_and_values = {
      {"position_name", _position.getPositionName(), "string"}
    };
    
    if (toCreate) positionsModel.insertEntry(fields_and_values);
    else positionsModel.updateEntry(_position.getId(), fields_and_values);
  }
  
  public void delete(Positions _position) {
    
    positionsModel.deleteEntry(_position.getId());
  }
}
