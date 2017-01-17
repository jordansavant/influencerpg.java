import java.util.EnumMap;


public class InfluenceRpg {

	
	
	public static void main(String[] args)
	{
		
		// SET UP REGIONS
		Region zanzibar = new Region("Zanzibar");
		
		EnumMap<Trait, Integer> zanzibarTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		zanzibarTraitLevels.put(Trait.FEAR_OF_DEATH, 15);		
		zanzibar.setTraitLevels(zanzibarTraitLevels);
		
		Region yulo = new Region("Yulo");
		
		EnumMap<Trait, Integer> yuloTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		yuloTraitLevels.put(Trait.FEAR_OF_DEATH, 12);		
		yulo.setTraitLevels(yuloTraitLevels);
		
		Region kikkiomon = new Region("Kikkiomon");
		
		EnumMap<Trait, Integer> kikkiomonTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		kikkiomonTraitLevels.put(Trait.FEAR_OF_DEATH, 16);
		kikkiomon.setTraitLevels(kikkiomonTraitLevels);
		
		RegionManager.getInstance().addRegion(zanzibar);
		RegionManager.getInstance().addRegion(yulo);
		RegionManager.getInstance().addRegion(kikkiomon);
		
		
		// SET UP PEOPLE
		Person chubbs = new Person("Chubbs", zanzibar);
		Person isis = new Person("Isis", yulo);
		Person simon = new Person("Simon", kikkiomon);
		
		EnumMap<Trait, Integer> chubbsTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		chubbsTraitLevels.put(Trait.FEAR_OF_DEATH, 5);
		chubbs.setTraitLevels(chubbsTraitLevels);
		
		EnumMap<Trait, Integer> isisTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		isisTraitLevels.put(Trait.FEAR_OF_DEATH, 5);
		isis.setTraitLevels(isisTraitLevels);
		
		EnumMap<Trait, Integer> simonTraitLevels = new EnumMap<Trait, Integer>(Trait.class);
		simonTraitLevels.put(Trait.FEAR_OF_DEATH, 5);
		simon.setTraitLevels(simonTraitLevels);
		
		
		EnumMap<Trait, Integer> chubbsTraitGoals = new EnumMap<Trait, Integer>(Trait.class);
		chubbsTraitGoals.put(Trait.FEAR_OF_DEATH, 10);
		chubbs.setTraitGoals(chubbsTraitGoals);
		
		EnumMap<Trait, Integer> isisTraitGoals = new EnumMap<Trait, Integer>(Trait.class);
		isisTraitGoals.put(Trait.FEAR_OF_DEATH, 10);
		isis.setTraitGoals(isisTraitGoals);
		
		EnumMap<Trait, Integer> simonTraitGoals = new EnumMap<Trait, Integer>(Trait.class);
		simonTraitGoals.put(Trait.FEAR_OF_DEATH, 10);
		simon.setTraitGoals(simonTraitGoals);
		
		
		PersonManager.getInstance().addPerson(chubbs);
		PersonManager.getInstance().addPerson(isis);
		PersonManager.getInstance().addPerson(simon);
		
		// GAME LOOP
		while(true)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			RegionManager.getInstance().update();
			PersonManager.getInstance().update();
			
			chubbs.setTraitLevel(Trait.FEAR_OF_DEATH, 20);
		}
		
	}
	
	

}
