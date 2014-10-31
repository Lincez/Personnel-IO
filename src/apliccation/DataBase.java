package apliccation;

import java.util.HashMap;

import model.IF_Person;

public class DataBase implements IF_DataBase
{
	private HashMap<String, IF_Person> clientMap = new HashMap<String, IF_Person>();
	
	public IF_Person queryPerson(String rg)
	{
		return clientMap.get(rg);
	}
	
	private static DataBase instance = new DataBase();
	
	public static IF_DataBase getInstance()
	{
		return instance;
	}
	
	private DataBase()
	{
		
	}

	@Override
	public void addPerson(IF_Person person)
	{
		this.clientMap.put(person.getRg(), person);
	}
	
}
