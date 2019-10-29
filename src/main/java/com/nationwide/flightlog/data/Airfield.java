package com.nationwide.flightlog.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Airfield")
@NamedQuery(name = "Airfield.findMaxIdnumber",
			query = "select max(a.idnumber) from Airfield a")
public class Airfield {
	@Id
	private int idnumber;
	private String picture;
	private String description;
	private String tips;
	private String pros;
	private String cons;
	private float landingfee;
	
	public Airfield() {
		super();
	}
	
	public Airfield(int idnumber, String picture, String description, String tips, String pros, String cons,
			float landingfee) {
		this.idnumber = idnumber;
		this.picture = picture;
		this.description = description;
		this.tips = tips;
		this.pros = pros;
		this.cons = cons;
		this.landingfee = landingfee;
	}

	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getCons() {
		return cons;
	}

	public void setCons(String cons) {
		this.cons = cons;
	}

	public float getLandingfee() {
		return landingfee;
	}

	public void setLandingfee(float landingfee) {
		this.landingfee = landingfee;
	}
}