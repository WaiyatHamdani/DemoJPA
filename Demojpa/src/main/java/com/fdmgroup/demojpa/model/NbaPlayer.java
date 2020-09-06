package com.fdmgroup.demojpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLAYERS_NBA")   //creating table into oracle sql using hibernate
@NamedQueries({
	@NamedQuery(name="findall",query="SELECT p FROM PLAYERS_NBA p")
})

public class NbaPlayer {
	
	
	@Id
	@SequenceGenerator(name="PLAYER_SEQ", sequenceName="PLAYER_NBA_ID_SEQ",initialValue=1001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLAYER_SEQ")
	private int Id;
	
	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="carrer_points")
	private int CareerPoints;

	
	
	
	public NbaPlayer(String firstname, String lastname, int carrerpoint) {
		super();
		this.FirstName=firstname;
		this.LastName=lastname;
		this.CareerPoints=carrerpoint;
	}
	
	public NbaPlayer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getCareerPoints() {
		return CareerPoints;
	}
	public void setCareerPoints(int carrerPoints) {
		this.CareerPoints = carrerPoints;
	}
	@Override
	public String toString() {
		return "NbaPlayer [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", CareerPoints="
				+ CareerPoints + "]";
	}

	
	
}
