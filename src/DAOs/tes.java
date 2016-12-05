package JssDAO;

public class School {
	int id;
	String Name;
	String City;
	
	public School(int id, String name,String city) {
		this.id=id;
		this.Name=name;
		this.City=city;
		// TODO Auto-generated constructor stub
	}
	
	public void setCity(String city) {
		City = city;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getCity() {
		return City;
	}
	public String getName() {
		return Name;
	}
	public int getId() {
		return id;
	}
	
	
	
	
}