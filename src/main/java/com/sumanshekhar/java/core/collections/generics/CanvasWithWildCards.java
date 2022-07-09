package com.sumanshekhar.java.core.collections.generics;

import java.util.List;
import java.util.Map;

public class CanvasWithWildCards {
	public void draw(CanvasWithWildCards s) {
		s.draw(this);
	}

	/*
	 * The ? stands for an unknown type, just like the wildcards we saw earlier.
	 * However, in this case, we know that this unknown type is in fact a subtype of
	 * Shape. (Note: It could be Shape itself, or some subclass; it need not
	 * literally extend Shape.) We say that Shape is the upper bound of the
	 * wildcard.
	 */
	public void drawAll(List<Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}

		shapes.add(new Rectangle());
	}

	// ***this will accept any list having instance of Shape but all the Shapes
	// should be same
	public void drawAll2(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
//		shapes.add(new Rectangle());//Compile time error

		/*
		 * There is, as usual, a price to be paid for the flexibility of using
		 * wildcards. That price is that it is now illegal to write into shapes in the
		 * body of the method. For instance, the above is not allow
		 */

		/*
		 * You should be able to figure out why the code above is disallowed. The type
		 * of the second parameter to shapes.add() is ? extends Shape-- an unknown
		 * subtype of Shape. Since we don't know what type it is, we don't know if it is
		 * a supertype of Rectangle; it might or might not be such a supertype, so it
		 * isn't safe to pass a Rectangle there.
		 */
	}
}

abstract class Shape {
	public abstract void draw(CanvasWithWildCards c);
}

class Rectangle extends Shape {
	private int x, y, width, height;

	public void draw(CanvasWithWildCards c) {
	}
}

class Circle extends Shape {
	private int x, y, radius;

	public void draw(CanvasWithWildCards c) {
	}
}

/*
 * Map<K,V> is an example of a generic type that takes two type arguments,
 * representing the keys and values of the map. Again, note the naming
 * convention for formal type parameters--K for keys and V for values.
 */
class ShapeRepositoryDB {
	public static void addRegistry(Map<String, ? extends Shape> registry) {
	}
}
