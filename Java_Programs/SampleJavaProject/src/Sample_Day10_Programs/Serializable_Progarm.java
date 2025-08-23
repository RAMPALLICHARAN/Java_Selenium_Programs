package Sample_Day10_Programs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Person implements Serializable {
	private int id;
	private String name;

	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	public Person() {
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=  " + name +   "]";
	}
}

public class Serializable_Progarm {
	public static void main(String[] args) {
		
		Person person1 = new Person();
		person1.setId(101);
		person1.setName("Name One  ");

		try {
			
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\91830\\Downloads\\Sample1.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

			objectOut.writeObject(person1);

			
			objectOut.close();
			fileOut.close();

			System.out.println("✅ Serialized data written to file.");
		} catch (IOException e) {
			System.out.println("Error during serialization:");
			e.printStackTrace();
		}
	}
}
