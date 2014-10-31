package apliccation;

import java.rmi.Naming;

import model.Status;

public class Client
{
	private IF_Server server = null;
	
	public void connectToServer(String serverIp) throws Exception
	{
		this.server = (IF_Server)Naming.lookup("//" + serverIp + ":" + IF_Server.PORT + "/" + IF_Server.SERVER_NAME);
		
		System.out.println("Conectado ao Servidor");
	}
	
	private void register(String name, String rg) throws Exception
	{
		if (name == null)
			name = Console.readLine("Nome: ");
		if (rg == null)
			rg = Console.readLine("RG: ");
		
		model.Form form = new model.Form();
		form.setName(name);
		form.setRg(rg);
		server.registerPerson(form);
	}
	
	private void query(String rg) throws Exception
	{
		try
		{
			boolean chave = true;
			while (chave)
			{
				model.IF_Person person = server.queryPerson(rg);
				System.out.println(person);
				String command = Console.readLine(">> ");
				if (command.equals("entrada"))
				{
					if (person.getStatus().getType() == Status.Type.ENTRY)
					{
						System.out.println("Atenção: O Registro já está dentro do prédio, deseja mudar sua localização? (s/n)");
						if (!Console.readLine().equalsIgnoreCase("s"))
							continue; // Volta para o 'while (chave)'
					}
					
					String level = Console.readLine("Destino: ");
					server.registerEntry(rg, level);
					System.out.println("OK");
				}
				else if (command.equals("saida"))
				{
					if (person.getStatus().getType() == Status.Type.ENTRY)
					{
						server.registerExit(rg);
						System.out.println("OK");
					}
				}
				else chave = false;
			}
		}
		catch (myExceptions.PersonNotRegisteredException e)
		{
			System.out.println("RG não encontrado nos registros, gostaria de cadastra-lo? (s/n)");
			String ans = Console.readLine();
			if (ans.equalsIgnoreCase("s"))
			{
				this.register(null, rg);
				this.query(rg);
			}
		}
		
	}
	
	public void run() throws Exception
	{
		boolean chave = true;
		String command;
		while (chave)
		{
			command = Console.readLine(": ");
			if (command.equals("exit"))
				chave = false;
			else if (command.equals("cad"))
			{
				this.register(null, null);
			}
			else if (!command.isEmpty())
			{
				this.query(command);
			}
		}
	}
	
	public static void main(String args[])
	{
		Client client = new Client();
		
		try
		{
			client.connectToServer("127.0.0.1");
			client.run();
		}
		catch (Exception e)
		{
			System.out.println("Fatal Error:");
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
