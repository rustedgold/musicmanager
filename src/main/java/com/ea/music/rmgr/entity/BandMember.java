package com.ea.music.rmgr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BandMember {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long memberId;
	private String name;
	private String address;
	private String contact;
	private String age;
	private String gender;
	private String activeMember;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getActiveMember() {
		return activeMember;
	}
	public void setActiveMember(String activeMember) {
		this.activeMember = activeMember;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BandMember [memberId=" + memberId + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ ", age=" + age + ", gender=" + gender + ", activeMember=" + activeMember + ", getAddress()="
				+ getAddress() + ", getContact()=" + getContact() + ", getAge()=" + getAge() + ", getGender()="
				+ getGender() + ", getActiveMember()=" + getActiveMember() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
