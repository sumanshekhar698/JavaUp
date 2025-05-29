package dev.codecounty.java.java8.advance.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * Getting and Setting Field Values.
 *
 */
public class ReflectionDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class student = Class.forName("com.sumanshekhar.java.advance.reflections.Student");
		try {
			Student s1 = (Student) student.newInstance();
			/*
			 * You could use getConstrouctor, although note it will only return public
			 * constructors. Also, note that newInstance() isn't deprecated in Java 8
			 * (although using it still has all the problems that made the JDK developers
			 * deprecate it in 9
			 */
//			https://docs.oracle.com/javase/9/docs/api/java/lang/Class.html#newInstance--

			Method declaredDisplayMethod = student.getDeclaredMethod("display", null);// fetching the specific method
			// Still the method is unavailable as its private
			declaredDisplayMethod.setAccessible(true);// to make it accessible
			declaredDisplayMethod.invoke(s1, null);// invokes the method p1:object ref ; p2:method parameters

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Student s1 = (Student) student.getDeclaredConstructor().newInstance();
			Method declaredDisplayMethod = student.getDeclaredMethod("display", null);// fetching the specific method
			// Still the method is unavailable as its private
			declaredDisplayMethod.setAccessible(true);// to make it accessible
			declaredDisplayMethod.invoke(s1, null);// invokes the method p1:object ref ; p2:method parameters
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void extra() {
		{
			try {
				Class<Student> classObj = Student.class;
				/*
				 * Returns:the Field object of this class specified by name
				 */

				Field ageField = classObj.getField("age");
				System.out.println("Field Name = " + ageField.getName());// age
				System.out.println("Field Type = " + ageField.getType());// int

				Student student = classObj.newInstance();
				/*
				 * Sets the field represented by this Field object on the specified object
				 * argument to the specified new value.
				 */
				ageField.set(student, 23);
				Object ageValue = ageField.get(student);
				System.out.println("age =  " + ageValue);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
					| InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

}