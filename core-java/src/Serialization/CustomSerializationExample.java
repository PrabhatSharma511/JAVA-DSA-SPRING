package Serialization;

import java.io.*;
import java.util.Base64;

class SecureEmployee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private transient String password; // Store encrypted password only

    public SecureEmployee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        // Encrypt password before serialization
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        oos.writeObject(encryptedPassword);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Decrypt password during deserialization
        String encryptedPassword = (String) ois.readObject();
        this.password = new String(Base64.getDecoder().decode(encryptedPassword));
    }

    @Override
    public String toString() {
        return "SecureEmployee{id=" + id + ", name='" + name + "', password='" + password + "'}";
    }
}

public class CustomSerializationExample {
    public static void main(String[] args) {
        SecureEmployee emp = new SecureEmployee(1, "John Doe", "mypassword123");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secureEmployee.ser"))) {
            oos.writeObject(emp);
            System.out.println("Serialized: " + emp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secureEmployee.ser"))) {
            SecureEmployee deserializedEmp = (SecureEmployee) ois.readObject();
            System.out.println("Deserialized: " + deserializedEmp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
