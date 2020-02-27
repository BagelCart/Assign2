package assign2;
/**
 * @author Joshua McNeil
 * classID 367, assignment 1
 * 
 * This file contains only the class SimpleList.
 */

/**
 * SimpleList creates and manages a list of up to 10 integer 
 * values. Users can add and remove values from the list as
 * well as display contents, display number of elements in
 * the list, and search for the location of a value.
 */
class SimpleList
{
	/**
	 * list contains 10 storage locations for the list
	 *  of integers.
	 */
	public int[] list;
	/**
	 * count contains the value of how many integers are
	 * currently in the list.
	 */
	public int count;
	
	/**
	 * SimpleList, also known as the constructor, creates
	 * an empty list with 10 storage locations.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Inserts another integer into the list at location 0.
	 * All other elements of the list will then be adjusted
	 * one location. 
	 * <p>
	 * In the event that the list is already full, add will
	 * push the last element off the end of the list and it
	 * will no longer be included.
	 * 
	 * @param element Integer value to be added to the list.
	 */
	public void add(int element)
	{
		int current = count;
		
		if (current == 10)
			current = 9;
		
		while (current > 0)
		{
			list[current] = list[current - 1];
			--current;
		}
		
		list[0] = element;
		
		if (count < 10)
			++count;
	}
	
	/**
	 * Removes all instances of the given integer in the 
	 * list. All elements after the removed integer(s) will 
	 * be shifted toward the front of the list to fill the
	 * gap left by the removed value. In the event that the
	 * list contains multiple entries of the given integer,
	 * all will be removed.
	 * 
	 * @param element the integer value to be removed.
	 */
	public void remove(int element)
	{
		int current = 0;
		int shiftstart;
		
		while (current < count)
		{
			if (list[current] == element)
			{
				shiftstart = current;
				--count;
				
				while (shiftstart < count)
				{
					list[shiftstart] = list[shiftstart + 1];
					++shiftstart;
				}
			}
			else
				++current;
		}
	}
	
	/**
	 * Returns the number of integers currently in the list.
	 * 
	 * @return number of integers in the list.
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Displays all current integers in the list.
	 * Integers will be displayed in the order they
	 * were added to the list.
	 * In the event that the list is empty, nothing
	 * will be displayed.
	 */
	public String toString()
	{
		String contents = "";
		
		for (int current = 0; current < count; ++current)
		{
			contents = contents + list[current];
			if (current < count - 1)
				contents = contents + " ";
		}
		
		return contents;
	}
	
	/**
	 * Finds the location of the given integer within the 
	 * list. The location will be the index location.
	 * For example, if the list contains 3 4 5 7, and the
	 * element parameter is 5, 2 will be the returned value.
	 * 
	 * @param element Integer to be searched for in the list.
	 * @return Index location of the given integer.
	 */
	public int search(int element)
	{
		int location = -1;
		int current = 0;
		
		while (current < count && location == -1)
		{
			if (list[current] == element)
				location = current;
			++current;
		}
		
		return location;
	}
}