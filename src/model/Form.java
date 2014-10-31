package model;

public class Form implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String rg;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getRg()
	{
		return rg;
	}
	public void setRg(String rg)
	{
		this.rg = rg;
	}	
}
