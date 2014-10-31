package model;

import java.util.ArrayList;

public class Person implements IF_Person
{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String rg;
	private String name;
	
	ArrayList<Status> statusList = new ArrayList<Status>();
	
	public Person(int newId)
	{
		this.id = newId;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getRg()
	{
		return this.rg;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void setRg(String newRg)
	{
		this.rg = newRg;
	}
	
	public void newStatus(Status.Type type, String level)
	{
		this.statusList.add(new Status(type, level));
	}
	
	public Status getStatus()
	{
		if (this.statusList.size() == 0) return null;
		
		return this.statusList.get(this.statusList.size() - 1);
	}
	
	public ArrayList<Status> getStatusList()
	{
		return this.statusList;
	}
	
	public String toString()
	{
		return getId() + ": " + getName() + "; " + getRg() + "; " + getStatus();  
	}
}
