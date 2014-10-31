package myExceptions;

public class PersonNotRegisteredException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	String rg = "";
	
	public PersonNotRegisteredException(String rg_)
	{
		super("RG Not Registered: " + rg_);
		this.rg = rg_;
	}
	
	public String getRg()
	{
		return this.rg;
	}

}
