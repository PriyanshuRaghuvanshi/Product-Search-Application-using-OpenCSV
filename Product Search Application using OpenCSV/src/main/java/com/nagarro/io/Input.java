package com.nagarro.io;

import java.util.Scanner;
import com.nagarro.enums.*;
import com.nagarro.tshirt.Tshirt;

public class Input {
	
	/**
	 * Prompts the user for T-shirt details and returns a Tshirt object with the details.
	 * 
	 * @return Tshirt object with T-shirt details entered by the user.
	 */
	
	public Tshirt getInput() {
			
			Tshirt tshirt = new Tshirt();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the Required Details:\n");
					
			String color = getColor(sc);
		    String size = getSize(sc);
		    String gender = getGender(sc);
		    String outputPreference = getOutputPreference(sc);
		    
		    tshirt.setColor(Color.valueOf(color.toUpperCase()));
		    tshirt.setSize(Size.valueOf(size.toUpperCase()));
		    tshirt.setGender(Gender.valueOf(gender.toUpperCase()));
		    tshirt.setOutputPreference(OutputPreference.valueOf(outputPreference.toUpperCase()));
		    
		    return tshirt;
		}

public String getColor(Scanner sc) {
		boolean isValid = true;
		System.out.println("Enter color of Tshirt:\n(available: Black,White,Blue,Purple,Grey,Pink,Maroon,Yellow)");
		
		String color="";
		do {
			try {
				color = sc.nextLine();
			//	System.out.println(Color.valueOf(color.toUpperCase()));
				if(Color.valueOf(color.toUpperCase())!=null)
					isValid = false;
				
			}
			catch(IllegalArgumentException e) {
				System.out.println("Enter a valid color of Tshirt:\n(available: Black,White,Blue,Purple,Grey,Pink,Maroon,Yellow)");
			}
		}
		while(isValid);
		return color;
	}
	
	public String getSize(Scanner sc) {
		boolean isValid = true;
		System.out.println("Enter size of Tshirt: \n(choose: S , M , L, XL )");
		
		String sizeType="";
		do {
			try {
				sizeType = sc.nextLine();
				if(Size.valueOf(sizeType.toUpperCase())!=null)
					isValid = false;
				
			}
			catch(IllegalArgumentException e) {
				System.out.println("Enter a valid size of Tshirt:\n(choose: S , M , L, XL )");}
		
			} while(isValid);
		return sizeType;
	}
		
		public String getGender(Scanner sc) {
			boolean isValid = true;
			System.out.println("Gender : \n(M-male,F-female,U-unisex)");
			
			String gender="";
			do {
				try {
					gender = sc.nextLine();
					if(Gender.valueOf(gender.toUpperCase())!=null)
						isValid = false;
					
				}
				catch(IllegalArgumentException e) {
					System.out.println("Enter a valid Gender:\n(M-male , F-femle,U-unisex )");
			}
			} while(isValid);
			return gender;
		}
			
			public String getOutputPreference(Scanner sc) {
				boolean isValid = true;
				System.out.println("Enter sorting output preference of Tshirt : \n(Price,Rating,Both)");
				
				String outputPreference="";
				do {
					try {
						outputPreference = sc.nextLine();
						if(OutputPreference.valueOf(outputPreference.toUpperCase())!=null)
							isValid = false;
						
					}
					catch(IllegalArgumentException e) {
						System.out.println("Enter a valid output preference:");
				}
			} while(isValid);
				return outputPreference;
	}

			
//this method allow user to access updated output as well as user can search for more t-shirts
			public String updatedOutput() {
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Do You want to Search More T-shirts: (Y/N)");
				String input = scanner.next();
				return input;
			}
}