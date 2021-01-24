package rule74.test2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 5. 25. initial creation
 */
public class Child extends NotSerializableParent implements Serializable {

	public Child(String str) {
		super(str);
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Child child = new Child("test");

		// Serialization
		byte[] serializedMember;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
				oos.writeObject(child);
				serializedMember = baos.toByteArray();
			}
		}

		// De-Serialization
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				Object objectMember = ois.readObject();

				// InvalidClassException occurs with "no valid constructor" message
				Child deChild = (Child) objectMember;
			}
		}
	}

}
