package org.arpit.java2blog;  
  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
  

import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
  
/* 
 * @Author : Arpit Mandliya 
 */  
public class JSONSimpleWritingToFileExample {  
  
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
  
        JSONObject countryObj = new JSONObject();  
        countryObj.put("Name", "India");  
        countryObj.put("Population", new Integer(1000000));  
  
        JSONArray listOfStates = new JSONArray();  
        listOfStates.add("Madhya Pradesh");  
        listOfStates.add("Maharastra");  
        listOfStates.add("Rajasthan");  
  
        countryObj.put("States", listOfStates);  
  
        try {  
              
            // Writing to a file  
            File file=new File("C:\\json-test\\CountryJSONFile.json");  
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print(countryObj);  
  
            fileWriter.write(countryObj.toJSONString());  
            fileWriter.flush();  
            fileWriter.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
}  

