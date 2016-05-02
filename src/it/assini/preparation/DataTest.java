package it.assini.preparation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataTest {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		String date1InString = "01-05-2016 10:00:00";
		Date date1 = sdf.parse(date1InString);
		
		String date2InString = "01-05-2016 11:00:00";
		Date date2 = sdf.parse(date2InString);
		
		System.out.println("data1: " + date1 +"\ndata2: " + date2); //Tue Aug 31 10:20:56 SGT 1982
		
		long diff = getDateDiff(date1,date2,TimeUnit.MINUTES);
		
		System.out.println("\nDifferenza in minuti: " + diff);
		
		//Dati n intervalli disponibili, divido l'intervallo temporale in n
		
		
		//Data la lunghezza di un intervallo (m minuti), ricavo x intervalli lunghi m
		
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

}
