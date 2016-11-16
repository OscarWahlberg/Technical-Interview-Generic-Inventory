package se.tritech.javatest;

import java.util.Calendar;

public class EvaluateExpiredateByCondition<T extends Item> implements Condition<T> {

	String productName;
	
	public EvaluateExpiredateByCondition(String productName) {
		super();
		this.productName = productName;
	}

	@Override
	public boolean evaluate(T object) {
		if (object.getClass() == DairyProduct.class) {
			DairyProduct dairyProduct = DairyProduct.class.cast(object);
			Calendar now = Calendar.getInstance();

			if (dairyProduct.getName().equals(productName)) {
				return dairyProduct.getExpiryDate().before(now);
			}
		}

		return false;
	}

	/*
	 * @Override public boolean evaluate(T object) { if (object.getClass() ==
	 * DairyProduct.class) { DairyProduct dairyProduct =
	 * DairyProduct.class.cast(object); Calendar now = Calendar.getInstance();
	 * if (dairyProduct.getExpiryDate().after(now)) { // This line is a
	 * toung-twister. I might have it the wrong way around... return false; }
	 * else { return true; } }
	 * 
	 * return false; }
	 */

}