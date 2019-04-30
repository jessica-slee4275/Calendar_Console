
public class CalendarCal {
	private int month[] = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	private int imonth[] = new int[] {31,29,31,30,31,30,31,31,30,31,30,31}; //leap year
	public boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if(0==(year%4) && 0!=(year%100) || 0==year%400) {
			isLeapYear = true;
		}
		return isLeapYear;
	}
	
	public int NumberOfLeapYear(int year) {
		int count = 0;
		for(int i=1; i<=year; i++) {
			if(isLeapYear(i)) {
				count++;
			}
		}
		return count;
	}
	
	public int NumberOfDays(int year, int month, int day) {
		int count = day;
		if(isLeapYear(year)) {
			for(int i=0; i<month-1; i++) {
				count += this.imonth[i];
			}
		}else {
			for(int i=0; i<month-1; i++) {
				count += this.month[i];
			}
		}
		return count;
	}
	
	public int startDay(int year, int month) {
		int count = 0;
		int leapYear = NumberOfLeapYear(year-1);
		int NumberOfDaysInYear =  NumberOfDays(year, month, 1);
		count = (leapYear)*2 + (year-1-leapYear) + NumberOfDaysInYear;
		return count%7;
	}
	
	public boolean isLastDay(int year, int month, int day) {
		boolean isLast = false;
		if(isLeapYear(year)) {
			if(day == this.month[month-1]) {
				isLast = true;
			}
			else {
				if(day == this.imonth[month-1]) {
					isLast = true;
				}
			}
			
		}
		return isLast;
	}
	
	public int getDates(int year, int month) {
		if(isLeapYear(year)) {
			return this.imonth[month-1];
		}else {
			return this.month[month-1];
		}
	}
	
	public void printCalendar(int year, int month) {
		int linecheck = 0;
		String temp = "";
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		linecheck = startDay(year, month);
		//according to start day, match day of the week.
		for(int j = 0; j < linecheck; j++) {
			temp += "\t";
		}
		System.out.print(temp);
		int count = getDates(year, month);
		
		for(int i = 1; i<= count; i++) {
			System.out.print(i + "\t");
			linecheck++;
			if(linecheck == 7) {
				if(this.isLastDay(year, month, i)) {
					return; // if last day, doesn't need to more line.
				}
				System.out.println();
				linecheck = 0;
			}
		}
	}
}
