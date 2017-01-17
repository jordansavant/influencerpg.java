import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class Region {
	
	Map<Trait, Integer> traitLevels;
	
	String regionName;
	
	public Region(String regionName)
	{
		traitLevels = new EnumMap<Trait, Integer>(Trait.class);
		
		this.regionName = regionName;
		
		System.out.println("Region " + regionName + " created.");
		
	}
	
	public void setTraitLevels(Map<Trait, Integer> traitLevels)
	{
		this.traitLevels = traitLevels;
		
		System.out.println("Region " + regionName + " trait levels changed to :" + traitLevels);
	}
	
	public Map<Trait, Integer> getTraitLevels()
	{
		return traitLevels;
	}
	
	public Integer getTraitLevel(Trait trait)
	{
		return traitLevels.get(trait);
	}
	
	public void setTraitLevel(Trait trait, Integer level)
	{
		this.getTraitLevels().put(trait, level);
	}

	public String getName()
	{	
		return regionName;
	}
	
	
	public void update()
	{
		// no regional updates at this time
		reduceCitizenTrait(Trait.FEAR_OF_DEATH);
	}
	
	
	
	
	// EFFECTS OF REGIONS
	// FEAR OF DEATH
	// - residually reduce the fear of death for citizens 
	// - for now, we reduce it by one for all citizens
	protected void reduceCitizenTrait(Trait trait)
	{
		ArrayList<Person> persons = PersonManager.getInstance().getPersons();
		
		Iterator<Person> itr = persons.iterator();
		while(itr.hasNext())
		{
			Person next = itr.next();
			
			next.getTraitLevels().put(trait, (next.getTraitLevels().get(trait) - 1));
		}
	}
}
