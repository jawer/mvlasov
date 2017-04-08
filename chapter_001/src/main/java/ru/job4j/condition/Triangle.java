package ru.job4j.condition;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**.
 * Class Point solving task for part 3 lesson 3.3
 * @author Mikhail Vlasov
 * @since 4.6.2017
 * @version 1
 */
public class Triangle {

	/**.
	 * Point a
	 */
	private Point a;

	/**.
	 * Point b
	 */
	private Point b;

	/**.
	 * Point c
	 */
	private Point c;

	/**.
	 * Constructor
	 * @param a defines a
	 * @param b defines b
	 * @param c defines c
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**.
	 * Calculating triangle area
	 * @return double area
	 */
	public double area() {
		//calculate the triangle area
		double aB = lineLength(this.a, this.b);
		double bC = lineLength(this.b, this.c);
		double aC = lineLength(this.a, this.c);
		double semiperimeter = (aB + aC + bC) / 2;
		double area = sqrt((semiperimeter - aB) * (semiperimeter - aC) * (semiperimeter - bC) * semiperimeter);

		if (area == 0) {
			System.out.println("No triangle can be built");
			return 0;
		}

		return area;
	}

	/**.
	 * Calculating line length
	 * @param first point of the line
	 * @param second point of the line
	 * @return double length
	 */
	private double lineLength(Point first, Point second) {
		return sqrt(pow((double) (first.getX() - second.getX()), 2D) + pow((double) (first.getY() - second.getY()), 2D));
	}
}