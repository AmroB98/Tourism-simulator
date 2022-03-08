
public class City {
		private AttractAbstract 	ListOfActivites[] = new AttractAbstract[5];
		
		private	double 				PricesFactor = 0.78;
		private long 				TotalAF = 0x0L;
		private String				CityName = "";

		City(String cityname,Long TotalAF,double setPrice){
			this(cityname,TotalAF);
			if(setPrice != 0)PricesFactor = setPrice;
		}
		City(String cityname){
			CityName = cityname;
			ListOfActivites[0] = new Food();
			ListOfActivites[1] = new Nature();
			ListOfActivites[2] = new Technology();
			ListOfActivites[3] = new Residence();
			ListOfActivites[4] = new Historical();
		}
		City(String cityname,long TotalAF){
			CityName = cityname;
			this.TotalAF = TotalAF;
			ListOfActivites[0] = new Food(		(int) (TotalAF     &0xfff));			
			ListOfActivites[1] = new Nature(	(int)((TotalAF>>12)&0xfff));
			ListOfActivites[2] = new Technology((int)((TotalAF>>24)&0xfff));
			ListOfActivites[3] = new Residence(	(int)((TotalAF>>36)&0xfff));
			ListOfActivites[4] = new Historical((int)((TotalAF>>48)&0xfff));
		}
		
		
		public void setPricesFactor(double f){ 		PricesFactor = f;}
		public void	SetCityName(String CityName){	this.CityName = CityName;}
		public void	setTotalAF(long af){			TotalAF = af;  		for(int i = 0 ; i < 5 ; i++) ListOfActivites[i].setAllHex((int)((TotalAF>>(i*12)&0xfff)));	}
		
		
		public String	getCityName(){				return CityName;}
		public long		getTotalAF(){ 				TotalAF = 0; 		for(int i = 0 ; i < 5 ; i++) TotalAF+=((long)(ListOfActivites[i].getAllHex()<<(i*8)));return TotalAF;	}
		public double 	getPricesFactor(){			return PricesFactor;}

		
		public String CityActivites(){			
			String tmp = "";
			for(int i = 0 ; i < 5 ; i++) {
				tmp += " `-->";
				tmp += String.format(" %-10s : %s\n",ListOfActivites[i].Type(),ListOfActivites[i].getActivitesStr());
				}
			return tmp;
			}
		public int  getCityActivityIncome(){	int c = 0 ; for(int i = 0 ; i < 5 ; i++) c+=ListOfActivites[i].ActivityIncome(); return c;}
		public void IncreaseRank(){				for(int i = 0 ; i < 5 ; i++) ListOfActivites[i].do_activity();}
		public void set_activity(String act){	for(int i = 0 ; i < 5 ; i++) ListOfActivites[i].set(act);}
		public void do_activity(int i){			if(i<ListOfActivites.length) ListOfActivites[i].do_activity();}
		public void do_activites(){				for(int i = 0 ; i < 5 ; i++) ListOfActivites[i].do_activity();}
		
									   
		
}

