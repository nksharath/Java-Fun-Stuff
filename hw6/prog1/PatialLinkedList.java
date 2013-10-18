
/*
 * PatialLinkedList.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : An interface for PatialLinkedList
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/14/2012 10.45 AM
*
*/
import java.util.*;
public interface PatialLinkedList 
{
     /*
      * add         adds an object to the linked list
      * @param   e  Object 
      */
          boolean add(Object e);
     /*
     * add         adds an object to the linked list at a given index
     * @param   index  int
     * @param   Element Object
     */
          void add(int index, Object element);
      
      /*
     * addFirst         adds an object to the start of linked list
     * @param   Element  Object 
     */
          void addFirst(Object e);
     /*
     * addLast         adds an object to the end of linked list
     * @param   Element  Object 
     */
          void addLast(Object e);
          
      /*
     * descendingIterator       returns an Iterator in reverse direction
     * 
     */
          Iterator descendingIterator();
          
       /*
     * getFirst         returns first object from linked list
     * 
     */
          Object getFirst();
          
       /*
     * getlast         returns last object from linked list
     * 
     */
          Object getLast();
       
      /*
     * ListIterator       returns ListIterator for given index
     * @param   index  int 
     */
          ListIterator listIterator(int index);
          
      /*
     * remove         removes an object from the linked list
     * @param   o  Object 
     */
          boolean remove(Object o);
      /*
     * removeFirstOccurence         removes the First Occurence of an object
     * @param   o  Object 
     */
          boolean removeFirstOccurrence(Object o);
          
      /*
     * removeLastOccurence         removes the Last Occurence of an object
     * @param   o  Object 
     */
          boolean removeLastOccurrence(Object o);
          
     /*
     * toArray()         returns an array of objects 
     *  
     */
          Object[] toArray();    
}
