package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalender {
	public static void main(String[] args) {
		System.out.println("请输入日期 (格式:yyyy-MM-dd)");
		Scanner input = new Scanner(System.in);
		String myString = input.nextLine();
		DateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date myDate = myFormat.parse(myString);
			Calendar myCalendar = new GregorianCalendar();
			myCalendar.setTime(myDate);
			int myDay = myCalendar.get(Calendar.DATE);
			myCalendar.set(Calendar.DATE, 1);
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			for (int i = 1; i < myCalendar.get(Calendar.DAY_OF_WEEK); i++) {
				System.out.print("\t");
			}
			for (int i = 1; i <= myCalendar.getActualMaximum(Calendar.DATE); i++) {
				if (i == myDay) {
					System.out.print("*");
				}
				System.out.print(i + "\t");
				if (myCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					System.out.println();
				}
				myCalendar.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}