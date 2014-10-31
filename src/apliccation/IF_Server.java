package apliccation;

public interface IF_Server extends java.rmi.Remote
{
	public static final int PORT = 1020;
	public static final String SERVER_NAME = "Server";
	
	public void registerPerson(model.Form form) throws Exception;
	
	public void registerEntry(String rg, String destinationLevel) throws Exception;
	
	public void registerExit(String rg) throws Exception;
	
	public model.IF_Person queryPerson(String rg) throws Exception;
}
