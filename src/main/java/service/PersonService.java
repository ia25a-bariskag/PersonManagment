package service;

import java.util.ArrayList;

import Model.Person;
import jakarta.servlet.http.Cookie;

public class PersonService{
	private static ArrayList<Person> persons = new ArrayList<Person>();
	
	public static ArrayList<Person> getPerson() {
		return persons;
	}
	
	public static void insert(Person person) {
		persons.add(person);
	}
	
	public static void delete(String uuid) {
		int index = 0;
		for (int i = 0; i < persons.size(); i++) {
				Person p= persons.get(i);
			if (p.getUuid().equals(uuid)) {
				index = i;
				break;
			}
		}
		persons.remove(index);
	}
 
	
	public static void update(String uuid, String firstname, String lastname) {
		for (int i = 0; i < persons.size(); i++) {
				Person p= persons.get(i);
			if (p.getUuid().equals(uuid)) {
				p.setNachname(lastname);
				p.setVorname(firstname);
			}
		}
		
		
	}
	public static void updateKeinNN(String uuid, String firstname) {
		for (int i = 0; i < persons.size(); i++) {
				Person p= persons.get(i);
			if (p.getUuid().equals(uuid)) {
				p.setVorname(firstname);
			}
		}
	}
	
	public static void updateKeinVN(String uuid, String lastname) {
		for (int i = 0; i < persons.size(); i++) {
			Person p= persons.get(i);
			if (p.getUuid().equals(uuid)) {
				p.setNachname(lastname);
			}
		}
	}
	
}