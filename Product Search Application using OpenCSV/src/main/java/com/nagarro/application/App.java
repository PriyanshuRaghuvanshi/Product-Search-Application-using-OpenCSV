package com.nagarro.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.nagarro.tshirt.Tshirt;
import com.nagarro.csvservices.CsvWatcher;
import com.nagarro.enums.*;
import com.nagarro.io.*;
import com.nagarro.searchtshirt.*;
public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
	while (true) {
		try{
		 Thread csvWatcherTh =new Thread(new CsvWatcher());	
	     csvWatcherTh.start();
		
        Input input = new Input();
        Tshirt tshirtSearchIp = input.getInput();
        
        SearchOperation tshirtSearchOp = new SearchOperation();
        ArrayList<Tshirt>matchedTShirts = tshirtSearchOp.getMatchingTshirts(tshirtSearchIp);
        
        Output output = new Output();
        output.displayOutput(matchedTShirts);
       
        String newOutput =input.updatedOutput();
        if(newOutput.equalsIgnoreCase("N")) {
        	System.out.println("Thanks for using our application !!!");
            //break;
        	System.exit(0);
        }
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
			
	}
	}
}
