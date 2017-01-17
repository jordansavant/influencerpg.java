import java.util.EnumMap;
import java.util.Map;

public class Person {
	
	private String personName;
	
	private Region region;
	
	private Map<Trait, Integer> traitLevels;
	
	private Map<Trait, Integer> traitTolerances;
	
	private Map<Trait, Integer> traitThresholds;
	
	
	public Person(String personName, Region startingRegion)
	{
		traitLevels = new EnumMap<Trait, Integer>(Trait.class);
		traitTolerances = new EnumMap<Trait, Integer>(Trait.class);
		traitThresholds = new EnumMap<Trait, Integer>(Trait.class);
		
		this.personName = personName;
		
		region = startingRegion;
	}
	
	
	public Integer getTraitLevel(Trait trait)
	{
		return this.getTraitLevels().get(trait);
	}
	
	public Map<Trait, Integer> getTraitLevels()
	{
		return traitLevels;
	}
	
	public void setTraitLevels(Map<Trait, Integer> traitLevels)
	{
		this.traitLevels = traitLevels;
		
		System.out.println(personName + " trait levels changed to :" + traitLevels);
	}
	
	public void setTraitLevel(Trait trait, Integer level)
	{
		this.getTraitLevels().put(trait, level);
	}
	
	
	
	
	
	public Integer getTraitGoal(Trait trait)
	{
		return this.getTraitGoals().get(trait);
	}
	
	public Map<Trait, Integer> getTraitGoals()
	{
		return traitThresholds;
	}
	
	public void setTraitGoals(Map<Trait, Integer> traitGoals)
	{
		this.traitThresholds = traitGoals;
		
		System.out.println(personName + " trait goals changed to :" + traitLevels);
	}
	
	public void setTraitGoal(Trait trait, Integer goal)
	{
		this.getTraitGoals().put(trait, goal);
	}
	
	
	
	public void update()
	{
		for(Map.Entry<Trait, Integer> e : traitLevels.entrySet())
		{
			System.out.println("Checking " + personName + " trait levels: " + traitLevels );
			
			Integer level = e.getValue();
			Integer goal = traitThresholds.get(e.getKey());
			
			if(level >= goal)
			{
				// determine course of action for this fear and this person's traits
				migrateToSaferRegion();
			}
		}
	}
	
	
	
	
	// Decisions
	
	// FEAR OF DEATH
	//  if fear of death over goal
	
	// - relocate to safer region
	protected Boolean migrateToSaferRegion()
	{
		// look for safest region
		// update current region to safest region
		// need to relocate regions
		Region safestRegion = RegionManager.getInstance().getSafestRegion();
		
		if(!safestRegion.equals(this.region))
		{
			System.out.println(personName + " has grown too fearful of death in the " + region.getName() + " region and has moved to the " + safestRegion.getName() + " region instead.");
			
			this.region = safestRegion;
			
			return true;
		}
		
		return false;
	}
	
	// - attempt to remove threat
	
	// - take action to fortify security
	
}
