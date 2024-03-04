package com.jspiders.onetomany.BidireDto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Comp1 {

	@Override
	public String toString() {
		return "Comp1 [id=" + id + ", name=" + name + ", address=" + address + ", emplo1s=" + emplo1s + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,unique = true)
	private String name;
	private String address;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "comp1")
	private List<Emplo1>emplo1s;

}
