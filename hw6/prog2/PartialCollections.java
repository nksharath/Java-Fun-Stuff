
/*
 * PartialCollections.java
 * 
 * Version:
 *          $Id$
 * 
 * Revisions:
 *          $Log$
 * 
 */

/*
*@Problem       : A PartialCollection interface
*@Author        : Sharath Navalpakkam Krishnan : Batch : 4003-707
*@Author        : Pratik Dilip Mehta : Batch : 4003-707
*@Version       : 1.0.3
*@LastModified  : 10/13/2012 10.55 PM
*
*/
import java.util.*;

public interface PartialCollections {
    
    /*
     * sort           Performs sort on the given list
     * @param   list  List 
     */
          void sort(List list);
          
     /*
     * sort           Performs sort on the given list using a comparator
     * @param   list  List 
     * @param   c     Comparator
     */
          void sort(List list, Comparator c);
          
     /*
     * shuffle           Performs a shuffle on the given list
     * @param   list  List 
     */
          void shuffle(List list);
}