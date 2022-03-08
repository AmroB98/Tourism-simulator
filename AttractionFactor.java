





class AttractionFactor implements AttractAbstract{
	protected final	int 		MAXIMUMVALUE	= 0xF;
	
	protected 		enum 		ActivityType{
		NotAtached,
		Food,
		Nature,
		Technology,
		Residence,
		Historical;
	}

	AttractionFactor(){}

	public 	String 		 getActivitesStr(){				return "";}
	public 	String		 Type(){						return ActivityType.NotAtached.toString();}
	public	String		 toString(){					return "AttachMeToActivityToGetResults";}
	public	int			 get(){							return -1;}
	public	int			 getAllHex(){					return -1;}
	public	boolean		 set(String Activity){			return false;}
	public	void		 do_activity(){					}	
	public 	double		 Pay_fee(){						return getPrice()*getAllHex();}
	public 	double		 getPrice(){					return -1;}	
	public 	void		 setPrice(double Prices){}
	public  void		 setAllHex(int HEX){}
	public	void		 close(){}	
	public 	int			 ActivityIncome() { 			return 0;}
		
	
}
