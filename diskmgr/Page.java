/* File Page.java */

package diskmgr;

import global.*;

 /**
  * class Page
  */

public class Page implements GlobalConst
{
  /**
   * protected field: An array of bytes (for the page). 
   * 
   */
  protected byte [] data;
  
  /**
   * default constructor
   */
  
  public Page()  
    {
      data = new byte[MAX_SPACE];
      
    }
  
  /**
   * Constructor of class Page
   */
  public Page(byte [] apage)
    {
      data = apage;
    }
  
  /**
   * return the data byte array
   * @return 	the byte array of the page
   */
  public byte [] getpage()
    {
      return data;
      
    }
  
  /**
   * read from given byte array at the specified position and convert it to a Vector100Dtype
   * @return 	the byte array of the page
   */
  public Vector100Dtype get100DVectorValue(int position, byte[] data)
  {
      Vector100Dtype vector = new Vector100Dtype();
      System.arraycopy(data, position, vector.getVector(), 0, Vector100Dtype.SIZE);
      return vector;
  }

  /**
   * update a Vector100Dtype in the given byte array at the specified position
   * @param 	position   where to set the vector
   * @param 	vector     the vector to be set
   * @param 	data       the byte array you want to update the vector with
   */
  public void set100DVectorValue(int position, Vector100Dtype vector, byte[] data)
  {
      System.arraycopy(vector.getVector(), 0, data, position, Vector100Dtype.SIZE);
  }

  /**
   * set the page with the given byte array
   * @param 	array   a byte array of page size
   */
  public void setpage(byte [] array)
    {
      data = array;
    }
  

  
}
