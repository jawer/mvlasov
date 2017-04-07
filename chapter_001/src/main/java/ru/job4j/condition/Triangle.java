package ru.job4j.condition;

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
		double aB = Math.sqrt(Math.pow((double) (this.a.getX() - this.b.getX()), 2D) + Math.pow((double) (this.a.getY() - this.b.getY()), 2D));
		double bC = Math.sqrt(Math.pow((double) (this.b.getX() - this.c.getX()), 2D) + Math.pow((double) (this.b.getY() - this.c.getY()), 2D));
		double aC = Math.sqrt(Math.pow((double) (this.a.getX() - this.c.getX()), 2D) + Math.pow((double) (this.a.getY() - this.c.getY()), 2D));
		double semiperimeter = (aB + aC + bC) / 2;
		double area = Math.sqrt((semiperimeter - aB) * (semiperimeter - aC) * (semiperimeter - bC) * semiperimeter);

		if (area == 0) {
			System.out.println("No triangle can be built");
			return 0;
		}

		return area;
	}
}