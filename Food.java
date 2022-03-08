

import java.util.Random;
import java.util.Scanner;

class Food extends AttractionFactor{
	//fields
	Scanner input = new Scanner(System.in);

	private int ActivitiesDone 		= 0;
	private int Activity 			= 0;
	private int AFactor 			= 0;
	public enum ActivitiesList{
		NOTHINGDONE(0),
		FASTFOOD(1),
		CAFE(2),
		FAMILYRESTURANT(4),
		HIGHCLASSRESTURANT(8),
		KODO(16),
		PIZZAHUT(32),
		RIDAN(64),
		CHINESERESTURANT(128),
		ITALYRESTURANT(256),
		DOSE(512),
		DUNKINDONUTS(1024),
		KFC(2048);
		private int importance = 0;
		ActivitiesList(int importance){ 	this.importance = importance;};
		public int getvalue(){				return importance;};
		};

	// constructors
	Food(){ 					}
	Food(String Activity){		set(Activity); }
	Food(int initialHex) {		setAllHex(initialHex); }
	// set methods
	public void		setAllHex(int HEX){ ActivitiesDone = HEX ;}
	public boolean 	set(String Activity) {
		boolean Done = false;
		try {
			this.Activity = ActivitiesList.valueOf(Activity.toUpperCase()).ordinal();
			if((ActivitiesDone & ActivitiesList.values()[this.Activity].getvalue()) == 0)
				AFactor = AFactor + this.Activity;
			ActivitiesDone = ActivitiesDone | ActivitiesList.values()[this.Activity].getvalue();
			if(ActivitiesDone==super.MAXIMUMVALUE) this.Activity = 0;
			Done = true;
		}catch(Exception x) {
			this.Activity = 0;
		}
		return Done;
	}

	//get methods
	public int 		get(){							return AFactor;	}
	public int 		getAllHex(){					return ActivitiesDone;}
	public String 	getActivitesStr() {
		String Activites = "";		
		if( ActivitiesDone == 0)
			Activites  = "Nothing" ;
		else
			for(int i = 0 ; i < ActivitiesList.values().length ; i++) {
				if((ActivitiesDone & (1<<(i-1)))   == (1<<(i-1)))   Activites  += String.format("%20s",ActivitiesList.values()[i].toString());
				if(i==6) Activites += "\n                   ";
			}
		return Activites ;
	}

	// do activity
	public void do_activity() {
		
			Random random 	= new Random();
			int RandomTech 	= random.nextInt(ActivitiesList.values().length-1)+1;
			if(ActivitiesDone < super.MAXIMUMVALUE) {
				while((ActivitiesDone & ActivitiesList.values()[RandomTech].getvalue()) != 0)
					RandomTech 		= random.nextInt(ActivitiesList.values().length-1)+1;
				this.Activity 	= RandomTech ;
				ActivitiesDone	= ActivitiesDone ^ ActivitiesList.values()[RandomTech].getvalue();
				AFactor 		= AFactor + RandomTech;
			}				
	} 

	public int			ActivityIncome() { int c = 0 ; for(int i = 0 ; i < ActivitiesList.values().length;i++)
		if((ActivitiesDone & (1<<(i-1)))   == (1<<(i-1))) c += ActivitiesList.values()[i].ordinal(); return c;}
	public String 		toString(){ return ActivitiesList.values()[Activity].toString();}
	public String		Type(){		return ActivityType.Food.toString();}
	public void			close()	{	input.close();}
}

