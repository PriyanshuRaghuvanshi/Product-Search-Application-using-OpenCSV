package com.nagarro.searchtshirt;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.nagarro.csvservices.*;
import com.nagarro.customexceptions.CustomException;
import com.nagarro.enums.*;
import com.nagarro.tshirt.Tshirt;
import com.opencsv.exceptions.CsvValidationException;
//import week5.advancejava1.SearchIp.TshirtSearchIp;
//import com.nagarro.comparators.*;

public class SearchOperation {

//	Scanner sc;
	
	public ArrayList<Tshirt> getMatchingTshirts(Tshirt tshirtsSerachIp) throws FileNotFoundException, CsvValidationException, NumberFormatException, CustomException{
		 
		ArrayList<Tshirt>requiredTshirt = new ArrayList<Tshirt>();
		CsvFileReader csvReader = new CsvFileReader();
		Map<String, List<Tshirt>> data = csvReader.getmapData();
		List<Tshirt> allTshirts = new ArrayList<>();
		for (List<Tshirt> value : data.values()) {
			allTshirts.addAll(value);
		}
	
		
		String inputFormat = String.format("%s,%s,%s", tshirtsSerachIp.getColor(),tshirtsSerachIp.getSize(),tshirtsSerachIp.getGender());
		
		String outputFormat;
		String output = tshirtsSerachIp.getOutputPreference().name();
		
		System.out.println("Your choice of Output Preference is : ");
		
		for(Tshirt allTshirtDataiterator : allTshirts) {
	 		
	    outputFormat = String.format("%s,%s,%s", allTshirtDataiterator.getColor(),allTshirtDataiterator.getSize(),allTshirtDataiterator.getGender());
			
		if(inputFormat.equalsIgnoreCase(outputFormat))
		requiredTshirt.add(allTshirtDataiterator);
			
		}
		
		//exception
		if (requiredTshirt.size() == 0) {
			throw new CustomException("We apologize, but the product you searched for is currently not available");
		}
		
		
		//comparators for output preference
		Comparator<Tshirt> comparator = Comparator.comparing(Tshirt::getPrice);
		
		if(output.equalsIgnoreCase("Price")) {
			comparator =Comparator.comparing(Tshirt::getPrice);
			System.out.println(output);
			
		}else if(output.equalsIgnoreCase("Rating")) {
			comparator =Comparator.comparing(Tshirt::getRating).reversed();
			System.out.println(output);
			
		}else {
			comparator =Comparator.comparing(Tshirt::getRating).reversed().thenComparing(Tshirt::getPrice).reversed();
			System.out.println(output);
			
		}
		requiredTshirt.sort(comparator);
		System.out.println("\n\n");
		
		
		//returning the list with required t-shirts 
		return requiredTshirt;
	}
}
