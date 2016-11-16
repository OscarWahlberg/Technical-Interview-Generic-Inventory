package se.tritech.javatest;

//import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DairyProduct implements Item {
	private String name;
	private Calendar expiryDate;

	public DairyProduct(String name, int expiresInNumberOfDays) {
		this.name = name;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, expiresInNumberOfDays);
		this.expiryDate = cal;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Calendar getExpiryDate() {
		return this.expiryDate;
	}

/*	public static void main(String args[]) {
		DairyProduct d = new DairyProduct("Milk", 365);
		System.out.println(d.getName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d.getExpiryDate().getTime()));
	}*/

}
