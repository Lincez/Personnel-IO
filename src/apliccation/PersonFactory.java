package apliccation;

import model.*;

public class PersonFactory
{
	private int id = 0;
	
	public IF_Person makePerson(Form form)
	{
		Person person = new Person(this.getNewId());
		person.setName(form.getName());
		person.setRg(form.getRg());
		
		return person;
	}
	
	private int getNewId()
	{
		return id++;
	}
	
	private PersonFactory()
	{
		
	}
	
	private static PersonFactory instance = new PersonFactory();
	
	public static PersonFactory getInstance()
	{
		return instance;
	}
}
