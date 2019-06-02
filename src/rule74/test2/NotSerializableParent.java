package rule74.test2;

/**
 *
 *
 * @author gwon
 * @history
 *          2019. 5. 25. initial creation
 */

public class NotSerializableParent {

	/***************************************************
	 * During an object's de-serialization, it starts with parent class. Since the parent class is
	 * non-serializable, it can retrieve the property information of the parent classes through the
	 * default constructor. If there is no default constructor, the object becomes invalid.
	 *
	 * This NotSerializableParent class non-serializable and has no default constructor, so an error
	 * occurs when de-serializing a Child class that inherits from this class.
	 *
	 * public NotSerializableParent(){
	 *
	 * }
	 *
	 *
	 ****************************************************/

	public NotSerializableParent(String str) {
		System.out.println("Constructor with param");
	}

}
