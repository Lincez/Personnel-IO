package model;

import java.io.Serializable;
import java.util.ArrayList;

public interface IF_Person extends Serializable
{
	public int getId();
	public String getName();
	public String getRg();
	public void newStatus(Status.Type type, String level);
	public Status getStatus();
	public ArrayList<Status> getStatusList();

}
