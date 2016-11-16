package se.tritech.javatest;

public class TestClass {

	public static void main(String[] args) {
		addToInventoryTest(7, 9);
		deleteFromAvailableTest(5, 7);
		deleteDairyProductByConditionTest(10, 1);
		deleteByConditionTest(10, 0);
	}
	
	private static void addToInventoryTest (int firstValueToAdd, int secondValueToAdd){
		System.out.println("### Test addToInventoryTest(" + firstValueToAdd + ", " + secondValueToAdd + ") ######");
		
		Inventory<Item> dairyInv = new Inventory<Item>();
		DairyProduct milk = new DairyProduct("Milk", firstValueToAdd);
		
		System.out.println("Milk in inventory: " + dairyInv.getCount(milk));
		dairyInv.add(milk, firstValueToAdd);
		System.out.println("Milk in inventory: " + dairyInv.getCount(milk));
		dairyInv.add(milk, secondValueToAdd);
		System.out.println("Milk in inventory: " + dairyInv.getCount(milk));
		
		
	}
	
	private static void deleteFromAvailableTest (int available, int delete){
		System.out.println("\n### Test deleteFromAvailableTest(" + available + ", " + delete + ") ######");
		
		Inventory<Item> dairyInv = new Inventory<Item>();
		DairyProduct milk = new DairyProduct("Milk", 7);
		dairyInv.add(milk, available);
		
		int milkInInv = dairyInv.getCount(milk);
		int numberOfDeletedMilks = dairyInv.delete(milk, delete);
		System.out.println("Trying to delete " + delete + " Milk when " + milkInInv + " is available results in " + numberOfDeletedMilks + " being deleted");
	}
	
	private static void deleteDairyProductByConditionTest (int amountInInventory, int daysToExpire){
		System.out.println("\n### Test deleteDairyProductByConditionTest() #########");
		
		Inventory<DairyProduct> dairyInv = new Inventory<DairyProduct>();
		DairyProduct milk = new DairyProduct("Milk", daysToExpire);
		dairyInv.add(milk, amountInInventory);
		
		
		DairyProductExpireDateCondition<DairyProduct> expDateCond = new DairyProductExpireDateCondition<DairyProduct>();
		
		int numberOfDeleted = dairyInv.delete(expDateCond);
		System.out.println("numberOfDeleted: " + numberOfDeleted);
		
	}
	
	private static void deleteByConditionTest (int amountInInventory, int daysToExpire){
		System.out.println("\n### Test deleteByConditionTest() #########");
		
		Inventory<Item> dairyInv = new Inventory<Item>();
		DairyProduct milk = new DairyProduct("Milk", daysToExpire);
		DairyProduct cheese = new DairyProduct("Cheese", 365);
		DairyProduct butter = new DairyProduct("Butter", 60);
		dairyInv.add(milk, amountInInventory);
		dairyInv.add(cheese, 5);
		dairyInv.add(butter, 7);
		
		
		EvaluateExpiredateByCondition<Item> expDateCond = new EvaluateExpiredateByCondition<Item>("Milk");
		
		int numberOfDeleted = dairyInv.delete(expDateCond);
		System.out.println("numberOfDeleted: " + numberOfDeleted);
		DairyProduct yoghurt = new DairyProduct("Yoghurt", 30);
		
		dairyInv.add(yoghurt, numberOfDeleted);
		System.out.println("Yoghurt in inventory: " + dairyInv.getCount(yoghurt) + " " + yoghurt.getName());
		
	}
}
