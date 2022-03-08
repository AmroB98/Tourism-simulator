


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tourist {
static  ArrayList <String> VisitedCities  = new ArrayList <String> ();
static  ArrayList<Integer> TouristsFactor = new ArrayList <Integer>();

private static  int PotentialTourists=1;
private int TouristsExpenses=1;


	public Tourist(int MaximumTourists) { //Number of Daily tourists		
		Tourist.PotentialTourists = MaximumTourists;
		
	}	 
	public double getTouristsExpenses(int index) {
		TouristsExpenses=getCityTourists(index)*Tourism.cities.get(index).getCityActivityIncome();
		return TouristsExpenses;		
	}
	public void setTouristsExpenses(int touristsExpenses) {
		TouristsExpenses = touristsExpenses;
	}
	public int getPotentialTourists() {
		return PotentialTourists;
	}
	public  void setFactorsArray(int dailyTourists) {
		PotentialTourists = dailyTourists;
	}	
	public static void GenerateFactorsArray () { //Generate random factors array, size:number of cities
		Random rand = new Random();			
		for (int c = 0;c<Tourism.cities.size();c++) 		
			Tourist.TouristsFactor.add(rand.nextInt(0xffff)*rand.nextInt(0xffffff));				
	}	
	public  void Visit () { 
		ArrayList<Long> TotalFactors = new ArrayList<Long>();
		TotalFactors.removeAll(TotalFactors);
		for (int c = 0;c<Tourism.cities.size();c++)			
			TotalFactors.add(Tourism.cities.get(c).getTotalAF());		
		
		int c=0;
		for (int t=0;t<PotentialTourists;t++) {
			GenerateFactorsArray();				
			for (int i = 0 ; i<Tourism.cities.size();i++) {				
				if (TotalFactors.get(i) > Tourist.TouristsFactor.get(i+c)) 
					Tourist.VisitedCities.add(Tourism.cities.get(i).getCityName());
				}
			c=c+Tourism.cities.size();
		}	 
	 }	
	public  void VisitedCounter() {
			for (int i = 0 ; i<Tourism.cities.size();i++)
			System.out.println("Tourists visted "+Tourism.cities.get(i).getCityName()+":"+Collections.frequency(Tourist.VisitedCities, Tourism.cities.get(i).getCityName()));
		}			
	public int getCityTourists(int index) { //Takes index of Cities Array and returns Tourists who visited the city								
				return Collections.frequency(Tourist.VisitedCities, Tourism.cities.get(index).getCityName());
			}			
	public double IncomeFromTourist(int index) {
		
		double Income;
		
		Income=0;
		Income=getCityTourists(index)*Tourism.cities.get(index).getCityActivityIncome() *Tourism.cities.get(index).getPricesFactor();
				return  	Income;			
			}
		}
