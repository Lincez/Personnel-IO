package apliccation;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.*;

public class Server extends UnicastRemoteObject implements IF_Server
{
	protected Server() throws RemoteException
	{
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void registerPerson(Form form) throws Exception
	{
		IF_Person person = PersonFactory.getInstance().makePerson(form);
		DataBase.getInstance().addPerson(person);
	}

	@Override
	public void registerEntry(String rg, String destinationLevel) throws Exception
	{
		IF_Person person = this.queryPerson(rg);
		person.newStatus(Status.Type.ENTRY, destinationLevel);
	}

	@Override
	public void registerExit(String rg) throws Exception
	{
		IF_Person person = this.queryPerson(rg);
		person.newStatus(Status.Type.EXIT, person.getStatus().getLevel());
	}
	
	@Override
	public IF_Person queryPerson(String rg) throws Exception
	{
		IF_Person person = DataBase.getInstance().queryPerson(rg);
		if (person == null) throw new myExceptions.PersonNotRegisteredException(rg);
		return person;
	}
	
	public static void main(String args[])
	{
		try
		{
			System.out.println("Abrindo Servidor");
			
			Server server = new Server();
			Registry registry = LocateRegistry.createRegistry(IF_Server.PORT);
			registry.rebind(SERVER_NAME, server);
			
			System.out.println("Ligado ao registro");
		}
		catch (Exception e)
		{
			System.out.println("Erro:");
			System.out.println(e);
		}
	}
}
