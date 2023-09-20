package com.nagarro.csvservices;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.nagarro.enums.*;
import com.nagarro.tshirt.Tshirt;
import com.nagarro.constants.*;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;


public class CsvFileReader {
  Map<String, List<Tshirt>> mapData = new HashMap<>();
  
public  Map<String, List<Tshirt>> getmapData() throws CsvValidationException, NumberFormatException {
	File folder = new File(Constants.DIRECTORY_PATH);
			
          File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));
          for (File file : files) {
        	  //System.out.println(file.getAbsolutePath());
               readFiles(file.getAbsolutePath());
        	  }
             return mapData;
             }

   
 public void readFiles(String file) throws CsvValidationException, NumberFormatException {
       try {
       
	CSVParser parser = new CSVParserBuilder().withSeparator(Constants.SEPERATOR).withIgnoreQuotations(true).build();
       CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).withSkipLines(1).build();
       String[] allmapData;
         List<Tshirt> list = new ArrayList<>();
      try{
	    while ((allmapData = csvReader.readNext()) != null) {
		Tshirt tshirt = new Tshirt();
        tshirt.setId(allmapData[0]);
        tshirt.setName(allmapData[1]);
        tshirt.setColor(Color.valueOf(allmapData[2].toUpperCase()));
        tshirt.setGender(Gender.valueOf(allmapData[3].toUpperCase()));
        tshirt.setSize(Size.valueOf(allmapData[4].toUpperCase()));
        tshirt.setPrice(Double.parseDouble(allmapData[5]));
        tshirt.setRating(Double.parseDouble(allmapData[6]));
        tshirt.setAvalibilty(allmapData[7]);
        list.add(tshirt);
      }
      mapData.put(file, list);
      } catch (IOException e) {
       e.printStackTrace();
      }
      }catch(FileNotFoundException e) {
	
      }
  }
public void deleteCsvFilemapData(String file) {
 mapData.remove(file);
 }

}