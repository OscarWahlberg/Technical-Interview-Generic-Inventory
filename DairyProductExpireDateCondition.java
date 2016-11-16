package se.tritech.javatest;

import java.util.Calendar;

public class DairyProductExpireDateCondition<T extends DairyProduct> implements Condition<T> {

	@Override
	public boolean evaluate(T object) {
		Calendar now = Calendar.getInstance();
		return !object.getExpiryDate().after(now);
	}
}
