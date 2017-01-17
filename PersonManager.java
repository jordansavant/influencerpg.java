import java.util.ArrayList;
import java.util.Iterator;


public class PersonManager {

	private static PersonManager instance;
	private ArrayList<Person> persons;
	
	protected PersonManager()
	{
		persons = new ArrayList<Person>();
	}
	
	public static PersonManager getInstance()
	{
		if(instance == null)
		{
			instance = new PersonManager();
		}
		
		return instance;
	}
	
	public void addPerson(Person person)
	{
		this.getPersons().add(person);
	}
	
	
	public ArrayList<Person> getPersons()
	{
		if(persons == null)
		{
			persons = new ArrayList<Person>();
		}
		
		return persons;
	}
	
	
	
	public void update()
	{
		Iterator<Person> itr = this.getPersons().iterator();
		while(itr.hasNext())
		{
			Person next = itr.next();
			
			next.update();
		}
	}
}
