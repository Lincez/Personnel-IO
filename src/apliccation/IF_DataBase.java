package apliccation;

import model.*;

public interface IF_DataBase
{
	public IF_Person queryPerson(String rg);
	public void addPerson(IF_Person person);
}
