
/*
 * AnotherHashSet.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : An Interface with functions of a Hash Table
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author       : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/06/2012 2.55 PM
*
*/
public interface AnotherHashSet 
{
   /*
     * add         Adds an object to the hash table
     * @param   o  Object 
     */
   public boolean add(Object o);
   /*
     * clear         Clears Hash Table
     */
   public void clear();
   /*
     * add         Checks if object is present
     * @param   o  object
     */
   public boolean contains(Object o);
   /*
     * isEmpty        Checks if hash table is empty
     */
   public boolean isEmpty();
   /*
     * remove         removes an object to the hash table
     * @param   o     object 
     */
   public boolean remove(Object o);
   /*
     * size        Returns the size of the hash table
     * 
     */
   public int size();
}
    

