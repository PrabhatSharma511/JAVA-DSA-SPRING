package Serialization;

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private transient String password; // Will not be serialized if set transient
    private String age;

    public Employee(int id, String name, String password, String age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(password != null ? password.hashCode() : null);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    	ois.defaultReadObject();;
    	this.password=null;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + "]";
	}

//    @Override
//    public String toString() {
//        return "Employee{id=" + id + ", name='" + name + "', password='" + password + "'}";
//    }
}
