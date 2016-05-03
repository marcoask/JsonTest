package it.assini.preparation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataTest {
	
	static String separator ="\n=========================================================\n";
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		String date1InString = "01-05-2016 10:00:00";
		Date date1 = sdf.parse(date1InString);
		
		String date2InString = "01-05-2016 10:11:00";
		Date date2 = sdf.parse(date2InString);
		
		System.out.println("data1: " + date1 +"\ndata2: " + date2); //Tue Aug 31 10:20:56 SGT 1982
		
		long diffMinutes = getDateDiffinUnit(date1,date2,TimeUnit.MINUTES);
		
		System.out.println("\nDifferenza in minuti: " + diffMinutes);

		
		//Dati n intervalli disponibili, divido l'intervallo temporale in n
		System.out.println(separator);
		int maxInterrogation = 9;
		System.out.println("Divido l'intervallo in "+maxInterrogation);
		long oneIntervalMinutes= (diffMinutes/(maxInterrogation-1));
		long oneIntervalMillisec= oneIntervalMinutes*1000*60;
		System.out.println("oneIntervalMillisec= "+oneIntervalMillisec +" (minutes: " +oneIntervalMinutes+")");

		long sum = date1.getTime();
		for (int i=1; i<=maxInterrogation; i++){
			
			Date dateLoop = new Date(sum);
			System.out.println(i+":  "+dateLoop+"\t"+getTravelTimeAtSpecifiedDate("A","B",dateLoop));
			sum = sum+oneIntervalMillisec;
			
		}
		
		System.out.println(separator);
			
		//Data la lunghezza di un intervallo (m minuti), ricavo x intervalli lunghi m
		System.out.println(separator);
		oneIntervalMinutes = 10;
		oneIntervalMillisec= oneIntervalMinutes*1000*60;
		System.out.println("oneIntervalMillisec= "+oneIntervalMillisec +" (minutes: " +oneIntervalMinutes+")");
		sum = date1.getTime();
		int j = 1;
		while (getDateDiffinUnit(date2,new Date(sum),TimeUnit.MINUTES)<0){
			Date dateLoop = new Date(sum);
			System.out.println(j+":  "+dateLoop+"\t"+getTravelTimeAtSpecifiedDate("A","B",dateLoop));
			sum = sum+oneIntervalMillisec;
			j++;
		}
		//System.out.println(maxInterrogation+":  "+date2);
		
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiffinUnit(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	public static int getTravelTimeAtSpecifiedDate(String start, String stop, Date date){
		Random random = new Random();
		
		int j = 3;
		int n = 100-j;
		int k = random.nextInt(n)+j;//Valori compresi tra 3 e 100
		
		return k;
		
	}

}
