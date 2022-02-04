package com.dwav.vo;

public class HomeVO {
	
	private int    Accom_Id	       ;
	private int    Accomodates	   ;
	private int    Bathrooms	   ;
	private int    Bedrooms	       ;
	private String Descrption	   ;
	private String User_id	       ;
	private String Location	       ;
	private int    Price	       ;
	private String Property_Type   ;
	private String Room_Type	   ;
	private int    Beds	           ;
	private String Building_Type   ;
	private String Currency_Unit   ;
	private String Name	           ;
	private int    Avg_Point	   ;
	
	public HomeVO(){}

	public int getAccom_Id() {
		return Accom_Id;
	}

	public void setAccom_Id(int accom_Id) {
		Accom_Id = accom_Id;
	}

	public int getAccomodates() {
		return Accomodates;
	}

	public void setAccomodates(int accomodates) {
		Accomodates = accomodates;
	}

	public int getBathrooms() {
		return Bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		Bathrooms = bathrooms;
	}

	public int getBedrooms() {
		return Bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		Bedrooms = bedrooms;
	}

	public String getDescrption() {
		return Descrption;
	}

	public void setDescrption(String descrption) {
		Descrption = descrption;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getProperty_Type() {
		return Property_Type;
	}

	public void setProperty_Type(String property_Type) {
		Property_Type = property_Type;
	}

	public String getRoom_Type() {
		return Room_Type;
	}

	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}

	public int getBeds() {
		return Beds;
	}

	public void setBeds(int beds) {
		Beds = beds;
	}

	public String getBuilding_Type() {
		return Building_Type;
	}

	public void setBuilding_Type(String building_Type) {
		Building_Type = building_Type;
	}

	public String getCurrency_Unit() {
		return Currency_Unit;
	}

	public void setCurrency_Unit(String currency_Unit) {
		Currency_Unit = currency_Unit;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAvg_Point() {
		return Avg_Point;
	}

	public void setAvg_Point(int avg_Point) {
		Avg_Point = avg_Point;
	}

	@Override
	public String toString() {
		return "HomeVO [Accom_Id=" + Accom_Id + ", Accomodates=" + Accomodates + ", Bathrooms=" + Bathrooms
				+ ", Bedrooms=" + Bedrooms + ", Descrption=" + Descrption + ", User_id=" + User_id + ", Location="
				+ Location + ", Price=" + Price + ", Property_Type=" + Property_Type + ", Room_Type=" + Room_Type
				+ ", Beds=" + Beds + ", Building_Type=" + Building_Type + ", Currency_Unit=" + Currency_Unit + ", Name="
				+ Name + ", Avg_Point=" + Avg_Point + ", toString()=" + super.toString() + "]";
	}

	public HomeVO(int accom_Id, int accomodates, int bathrooms, int bedrooms, String descrption, String user_id,
			String location, int price, String property_Type, String room_Type, int beds, String building_Type,
			String currency_Unit, String name, int avg_Point) {
		super();
		Accom_Id = accom_Id;
		Accomodates = accomodates;
		Bathrooms = bathrooms;
		Bedrooms = bedrooms;
		Descrption = descrption;
		User_id = user_id;
		Location = location;
		Price = price;
		Property_Type = property_Type;
		Room_Type = room_Type;
		Beds = beds;
		Building_Type = building_Type;
		Currency_Unit = currency_Unit;
		Name = name;
		Avg_Point = avg_Point;
	}






	
	
	
}