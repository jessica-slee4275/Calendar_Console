
public class CalendarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalendarCal calendar = new CalendarCal();
		int year = 2019;
		for(int i=1; i<13; i++) {
			System.out.println("\t\t\t" + year + " - "+ i + "\n");
			calendar.printCalendar(year, i);
			System.out.println("\n---------------------------------------------------------");
		}
	}

}
