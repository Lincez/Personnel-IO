package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Status implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private String level;
	private String time;
	private String date;
	public enum Type
	{
		ENTRY,
		EXIT
	} 
	private Type type;
	
	public Status(Type newType, String newLevel)
	{
		this.set(newType);
		this.level = newLevel;
	}
	
	private void set(Type newType)
	{
		this.type = newType;
		Date date = new Date();
		SimpleDateFormat sdfHour = new SimpleDateFormat("HH:mm:ss");
		this.time = sdfHour.format(date);
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		this.date = sdfDate.format(date);
	}
	
	public String getTime()
	{
		return this.time;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	public String getLevel()
	{
		return this.level;
	}
	
	public String toString()
	{
		String rt = "";
		if (getType() == Type.ENTRY)
		{
			rt = "Localização: ";
		}
		else
		{
			rt = "Ultima visita: ";
		}
		return rt + "(" + getLevel() + "): " + getDate() + "; " + getTime();
	}
	
	public static void main(String args[])
	{
		System.out.println(new Status(Type.ENTRY, "2"));
		System.out.println(new Status(Type.EXIT, "2"));
	}
}
