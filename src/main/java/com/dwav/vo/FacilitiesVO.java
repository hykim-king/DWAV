package com.dwav.vo;

public class FacilitiesVO {
	int amen_id;
	int accom_id;
	String amenity_type;
	String amenity_val;
	
	/** default 생성자 */
	public FacilitiesVO() {}

	
	
	
	
	public int getAmen_id() {
		return amen_id;
	}





	public void setAmen_id(int amen_id) {
		this.amen_id = amen_id;
	}





	public int getAccom_id() {
		return accom_id;
	}





	public void setAccom_id(int accom_id) {
		this.accom_id = accom_id;
	}





	public String getAmenity_type() {
		return amenity_type;
	}





	public void setAmenity_type(String amenity_type) {
		this.amenity_type = amenity_type;
	}





	public String getAmenity_val() {
		return amenity_val;
	}





	public void setAmenity_val(String amenity_val) {
		this.amenity_val = amenity_val;
	}








	@Override
	public String toString() {
		return "FacilitiesVO [amen_id=" + amen_id + ", accom_id=" + accom_id + ", amenity_type=" + amenity_type
				+ ", amenity_val=" + amenity_val + ", toString()=" + super.toString() + "]";
	}





	public FacilitiesVO(int amen_id, int accom_id, String amenity_type, String amenity_val) {
		super();
		this.amen_id = amen_id; //dummy, DB fill it by Sequence : AMEN_ID_AUTOINC
		this.accom_id = accom_id;
		this.amenity_type = amenity_type;
		this.amenity_val = amenity_val;
	}

	
}
