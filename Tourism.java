
import java.io.*;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



/*
 * 
 * Author 	: Amro				Email : Amrob00@hotmail.com
 * Author 	: Muath Abdullah	Email : m0az@outlook.com
 * Date 	: 3/31/2020
 * 
 * 
 * 
 * 
 */

public class Tourism {
  static File file = new java.io.File("DataBase.Tsm");
  
  //static 
  static ArrayList <City> cities = new ArrayList<City>();
  static Tourist tourist = new Tourist(2500);
  static int total = 0;
  static int Days = 0;
  
  //MAIN METHOD
  public static void main(String[] args) {
	  	  
	  Scanner input = new Scanner(System.in);
	    
	  int Choice = 'x';
	  while(true) {
		 
		  System.out.print("\n\n");
		  System.out.print(			  ",--------------------------------------------.\n"
				  					+ "| Options :                 "+String.format("%05d",Days)+" Days \t     |\n"
		  							+ "| \t[01] Show full Details.              |\n"
		  							+ "| \t[02] Show Cities List.               |"+String.format("  number of cities : %4d",cities.size())+"\n"
		  							+ "| \t[03] Show Total Visitors.            |\n"
		  							+ "| \t[04] Add New City.                   |\n"
		  							+ "| \t[05] Edit Current City.              |\n"
		  							+ "| \t[06] Make visiting Turn.  New Day    |\n"
		  							+ "| \t[07] Set Number Of Tourists.         |\n"
		  							+ "| \t[08] save.                           |\n"
		  							+ "| \t[09] load.                           |\n"
		  							+ "| \t[10] delete city.                    |\n"
		  							+ "| \t[11] delete all.                     |\n"
		  							+ "| \t[12] Exit.                           |\n"
		  							+ "'--------------------------------------------'\n > ");
		  
		  try {
			  Choice = input.nextInt();
		  }catch(InputMismatchException y) {
			  System.out.print("\n error ! ,Exception Handled.. I am going to turn off.\n");
			  break;
		  }
		  
		  
		  if(Choice == 12)
			   break;			  	  
		  else if(Choice == 1)
			  Option_1();
		  else if(Choice == 2) 
			  Option_2();
		  else if(Choice == 3) 
			  Option_3();
		  else if(Choice == 4) 
			  Option_4();
		  else if(Choice == 5) 
			  Option_5();
		  else if(Choice == 6) 
			  Option_6();
		  else if(Choice == 7) 
			  Option_7();
		  else if(Choice == 8) 
			  Option_8();
		  else if(Choice == 9) 
			  Option_9();
		  else if(Choice == 10) 
			  {
			  Option_2();
			  System.out.print("\n Insert City Address > ");
			  try{
				  Choice = input.nextInt()-1;
				  
				  if(Choice >= 0 & Choice < cities.size())
					  cities.remove(Choice);
			  }catch(InputMismatchException y) {
				  continue;
			  	}
			  
			  }
		  else if(Choice == 11) { 
			  	cities.clear();
		  		Days = 0;
		  }else
			  System.out.print("\n Out of Range , Try again please.\n"); 
	  }
	  
	  input.close();	  
	  

	    
 }// Main 


  
private static void Option_1() {
	  for(int i = 0 ; i<cities.size();i++){
		  	System.out.println(".-----------------------.-----------------------.-------------------------------.");
		  	System.out.print(String.format("| City: %-15s\t| PriceFactor: %5.3f\t| Attraction Factor: %-10x |\n",cities.get(i).getCityName(),cities.get(i).getPricesFactor(),cities.get(i).getTotalAF()));
		  	System.out.println("`--------.--------------'-----------------------'-----------------------.-------'");
		    System.out.print(String.format("\t |  Number of Tourists who visited %-18s : %-6d  |\n",String.format("%s is ",cities.get(i).getCityName()),tourist.getCityTourists(i)));
		    System.out.println(".--------'----------------.---------------------.-----------------------'-------.");
		  	System.out.print(String.format("| ExpectedTourists: %-5d | Income: %-8.2f\t| ExpectedExpenses: %-5.2f\t|\n",tourist.getPotentialTourists(),tourist.IncomeFromTourist(i),tourist.getTouristsExpenses(i)));
		  	System.out.println("`-------------------------'---------------------'-------------------------------'");		    
			System.out.print("[+] "+cities.get(i).getCityName()+"'s Acitivites:\n :");
			System.out.println("\n"+cities.get(i).CityActivites());
			System.out.println("\n\n");				 
	  		}
	  System.out.print("Total Number of Cities : "+cities.size()+"\n");
  }
  
  
private static void Option_2() {
	  System.out.print("\n Cities :"); 
	  for(int i = 0 ; i<cities.size();i++)
		  System.out.print(String.format("\n %03d --> %-15s",i+1,cities.get(i).getCityName())); 
	  
  }
  
  
private static void Option_3() {
	  int t = 0;
	  for(int i = 0 ; i <cities.size();i++ )
		  t+=tourist.getCityTourists(i);
	  total = t;
	  System.out.print(" .---------------------------------.");
	  System.out.print(String.format("\n | Total Cities Visitors is %-6d |\n",total));
	  System.out.print(" '---------------------------------'");
  }
  
private static void Option_4() {
	System.out.print("Insert City Name : ");
	Scanner input 	= new Scanner(System.in);
	String Name 	= input.next();
	String Active 	= "";
	double prc		= 0.1;
	City city 		= new City(Name);	
	
	city.setTotalAF(0xffffffffffffffL);
	System.out.print("[+] All Available Activies : \n"+city.CityActivites());
	city.setTotalAF(0);
	do{
		System.out.print("Insert City Activities [put nothing to finish ]: ");
		Active = input.next();
		city.set_activity(Active);			
	}while(!Active.toLowerCase().equals("nothing"));
	do {
		System.out.print("Insert City Price Factor [ 1 >= factor > 0 ] : ");
		  try {
			  prc = input.nextDouble();		  
		  }catch(InputMismatchException y) {
			  prc = 0.5;
		  }
	}while(!(prc>0 & prc <= 1));
	city.setPricesFactor(prc);  
	cities.add(city);
	
}
  
private static void Option_5() {
	Scanner input 	= new Scanner(System.in);
	Option_2();
	System.out.print("\n -------\n ======> Insert City Number to Edit [ put 0 to return to main ]: ");
	int Choice ;
	int Choice2 = 1; 
	
	  try {
		  Choice = input.nextInt();
		  Choice-=1;
	  }catch(InputMismatchException y) {
		  Choice = 0;
	  }
	  
	  if(Choice < cities.size() & Choice >= 0)
		  while(Choice2 != 0) {
			  System.out.print(		"\n,--------------------------------------------.\n"
									+ "| Edit " + String.format("%-25s",(cities.get(Choice).getCityName()+ " Options :")) +"             |\n"
									+ "| \t[01] Do a Specific Activity.         |\n"
									+ "| \t[02] Do Activity (randomly).         |\n"
									+ "| \t[03] Show the City Visitors.         |\n"
									+ "| \t[04] Show The City income.           |\n"
									+ "| \t[05] Change City`s Name.             |\n"
									+ "| \t[06] set Price`s Factor.             |\n"
									+ "| \t[07] set Total AttractionFactor.     |\n"
									+ "| \t[08] Exit.                           |\n"
									+ "'--------------------------------------------'\n > ");
			  try {
				  Choice2 = input.nextInt();
			  }catch(InputMismatchException y) {
				  Choice2 = 0;
				  break;
			  }
		  
		  
		  
		  if(Choice2 == 1){
			  	System.out.print("Activity Name : ");
			  	cities.get(Choice).set_activity(input.next());
			  	}
		  else if(Choice2 == 2)
		  		{
			  		Random rand = new Random();
			  		cities.get(Choice).do_activity(rand.nextInt(5));
		  		}
		  else if(Choice2 == 3)
		  		{
			  		System.out.print(tourist.getCityTourists(Choice));
		  		}  
		  else if(Choice2 == 4)
		  		{
			  		System.out.print(tourist.IncomeFromTourist(Choice));
		  		}  
		  else if(Choice2 == 5)
		  		{
			  		System.out.print("Insert City New Name : ");
			  		cities.get(Choice).SetCityName(input.next());
		  		}  
		  else if(Choice2 == 6)
		  		{
			  		System.out.print("Insert Price Factor (1.0 >= x > 0.0): ");
			  		try{
			  			double price = input.nextDouble();
			  			if(1 >= price & price > 0) 
			  				cities.get(Choice).setPricesFactor(price);
			  		}catch(InputMismatchException y) {
			  			System.out.print("wrong ! ");
			  		}
		  		
		  		}  
		  else if(Choice2 == 7)
		  		{
			  	System.out.print("Insert New Total Attraction Factor (ex : fffffffffffffff): ");
		  		try{
		  			long factor = input.nextLong(16);
		  			cities.get(Choice).setTotalAF(factor);
		  			
		  		}catch(InputMismatchException y) {
		  			System.out.print("wrong ! ");
		  			}
		  		}  
		  else if(Choice2 == 8)
			  break;
		  else
			  System.out.print("Wrong!");
		  }
	  
  }
  
private static void Option_6() {			
	  tourist.Visit();
	  Days++;
	}

private static void Option_7() {			
	System.out.print("Insert Number Of tourists : ");
	Scanner input = new Scanner(System.in);
	try{
			int tourists = input.nextInt();
			tourist.setFactorsArray(tourists);
	}catch(InputMismatchException y) {
		System.out.print("Wrong !");
	}
	
}

  
private static void Option_8() {
	  try {
		  save();
		  System.out.print("Saved sucessfully.\n");
	  }catch(IOException e) {
		  System.out.print("Ops! , I can not save DataBase.");
	  }
}  
  
  
private static void Option_9() {
	  try {
		  cities = load();
		  System.out.print("Loaded sucessfully.\n");
	  }catch(IOException e) {
		  System.out.print("Ops! , I can not get db");
	  }
}  
  
  
  
  
  
  
  
  
  
private static ArrayList <City> load() throws FileNotFoundException{
  		Scanner FileInput = new Scanner(file);
  		ArrayList <City> tmp =  new ArrayList<City>();
  		
  		if(file.canRead()){
  			while(FileInput.hasNextLine()){
  				String[] parts = FileInput.nextLine().split("\\:");
  				if(parts.length == 3) {  					
  					City TempCity = new City(parts[0]);
  					TempCity.setTotalAF(Long.parseLong(parts[1],16));
  					TempCity.setPricesFactor(Double.parseDouble(parts[2]));
  					try{
  					tmp.add( new City(parts[0],Long.parseLong(parts[1],16),Double.parseDouble(parts[2])));
  					}catch(NumberFormatException wrongnumber){
  						tmp.add( new City(parts[0],0));
  					}
  				}
  			}
  		}else
  			System.out.println("File not readable!");
  		FileInput.close();
  		return tmp;
  	}






private static void save() throws IOException{
  		FileWriter FileInput = new FileWriter(file);  		
  		if(file.canWrite()){
  			for(int i = 0; i <  cities.size()  ; i++){
  				String NewdbLine = (  cities.get(i).getCityName() 
  									+ ":" + String.format("%016x",cities.get(i).getTotalAF())
  									+ ":" + cities.get(i).getPricesFactor())  	
  									+ "\n";				
  				if(NewdbLine.length() > 3)  					
  						FileInput.write(NewdbLine);  					
  			}
  		}else
  			System.out.println("File not Writeable!");
  		FileInput.close();
  	}
	
}

