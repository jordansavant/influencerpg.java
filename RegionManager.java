import java.util.ArrayList;
import java.util.Iterator;


public class RegionManager {

	private static RegionManager instance;
	private ArrayList<Region> regions;
	
	protected RegionManager()
	{
		regions = new ArrayList<Region>();
	}
	
	public static RegionManager getInstance()
	{
		if(instance == null)
		{
			instance = new RegionManager();
		}
		
		return instance;
	}
	
	public Region getSafestRegion()
	{
		Region safestRegion = null;
		
		Iterator<Region> itr = regions.iterator();
		while(itr.hasNext())
		{
			Region next = itr.next();
			
			if(safestRegion == null)
			{
				safestRegion = itr.next();
			}
			else{
				if(safestRegion.getTraitLevel(Trait.FEAR_OF_DEATH) > next.getTraitLevel(Trait.FEAR_OF_DEATH))
				{
					safestRegion = next;
				}
			}
		}
		
		return safestRegion;
		
	}

	public void addRegion(Region region)
	{
		this.getRegions().add(region);
	}
	
	
	public ArrayList<Region> getRegions()
	{
		if(regions == null)
		{
			regions = new ArrayList<Region>();
		}
		
		return regions;
	}
	
	
	public void update()
	{
		Iterator<Region> itr = this.getRegions().iterator();
		while(itr.hasNext())
		{
			Region next = itr.next();
			
			next.update();
		}
	}
	
}
