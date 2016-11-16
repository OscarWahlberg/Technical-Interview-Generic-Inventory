package se.tritech.javatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keeps track of how many X we have, for some type of X.
 * <p/>
 * Example: <br/>
 * For type Fruit, we have an Inventory of apple: 13, pear: 10 and lemon: 7.
 * <br/>
 */
public class Inventory<T extends Item> {
	private final Map<T, Integer> inventory;

	public Inventory() {
		inventory = new HashMap<T, Integer>();
	}

	/**
	 * Adds number of item to inventory.
	 */
	public void add(T item, int number) {
		int newNumber = number;
		
		if (this.inventory.containsKey(item))		// Overdriven användning av this. kan struntas i.
			newNumber += this.inventory.get(item);
		
		this.inventory.put(item, newNumber);
	}

	/**
	 * Returns the number of a particular item in inventory.
	 */
	public int getCount(T item) {
		if (this.inventory.containsKey(item)) {
			return this.inventory.get(item);
		} else {
			System.out.println("No item [name: " + item.getName() + "] in inventory");
			return 0;
		}
	}

	/**
	 * Deletes <i>number</i> of a particular item and returns how many items
	 * were deleted. If no items remain, that type of item is removed from
	 * inventory.
	 */
	public int delete(T item, int number) {

		if (!this.inventory.containsKey(item)) {
			System.out.println("No item [name: " + item.getName() + "] preasent in inventory. 0 deleted");
			return 0;
		}

		if (number >= getCount(item)) {
			return inventory.remove(item);
		} else {
			inventory.put(item, getCount(item) - number);
			return number;
		}
	}

	/**
	 * Deletes all items for which condition is true. Returns the total number
	 * of items deleted.
	 */
	public int delete(Condition<T> condition) {
		int numberOfDeleted = 0;
		List<T> deleteList = new ArrayList<>();

		for (T item : inventory.keySet()) {
			if (condition.evaluate(item)) {
				deleteList.add(item);
			}
		}
		
		for (T item: deleteList){
			numberOfDeleted += inventory.remove(item);
		}

		return numberOfDeleted;
	}

	
/*	  public static void main(String args[]) { 
		  Inventory<DairyProduct> dairyInv = new Inventory<DairyProduct>();
	  
	  DairyProduct milk = new DairyProduct("Milk", 7); dairyInv.add(milk, 5);
	  System.out.println("Amount of item milk in dairyInv:\t\t" +
	  dairyInv.getCount(milk));
	  
	  System.out.println("Subtract 3 milk from dairyInv"); int deleted =
	  dairyInv.delete(milk, 3); System.out.println(
	  "Amount of item milk deleted from dairyInv:\t" + deleted);
	  System.out.println("Amount of item milk in dairyInv:\t\t" +
	  dairyInv.getCount(milk));
	  
	  System.out.println("Subtract 3 milk from dairyInv"); deleted =
	  dairyInv.delete(milk, 3); System.out.println(
	  "Amount of item milk deleted from dairyInv:\t" + deleted);
	  System.out.println("Amount of item milk in dairyInv:\t\t" +
	  dairyInv.getCount(milk));
	  
	  DairyProduct badMilk = new DairyProduct("Bad Milk", 0); deleted =
	  dairyInv.delete(badMilk, 5); System.out.println(
		 "amount of bad Milk deleted:\t\t\t" + deleted);
	 
	  }*/
	 

	public void clear() {
		inventory.clear();
	}
}
