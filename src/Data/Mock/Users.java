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

import java.util.ArrayList;

/**
 *
 * @author josep
 */
class Users {
  
  static ArrayList<Data.Objects.Users> generate() {
    ArrayList<Data.Objects.Users> usersList = new ArrayList();
    
    usersList.add(
      new Data.Objects.Users(
        1,
        "joseph",
        "3cd70d61fc479301125bbc87c04a2b5ff9b30e6224d27de2f6aa7864bb7564ad",
        2
      )
    );
    
    usersList.add(
      new Data.Objects.Users(
        2,
        "alfred",
        "d7c1554eba9f4e4dae19d409fe2164390cb60026459cc412efd0adb28df22ffb",
        2
      )
    );
    
    usersList.add(
      new Data.Objects.Users(
        3,
        "miles",
        "addeb261241a4edb15a9b428f32dd84d7ea0d6f8d656cc8be99325a2bdcb6631",
        2
      )
    );
    
    usersList.add(
      new Data.Objects.Users(
        4,
        "rene",
        "79aeb0de0d0bf5e094dd0612e48b78d8259e49e0cdae1dd96583bc0fa52d5dbe",
        1
      )
    );
    
    return usersList;
  }
}
