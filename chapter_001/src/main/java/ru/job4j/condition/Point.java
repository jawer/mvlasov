package ru.job4j.condition;

/**.
 * Class Point solving task for part 3 lesson 3.1
 * @author Mikhail Vlasov
 * @since 4.6.2017
 * @version 1
 */
public class Point {

	/**.
	 * Coordinate x
	 */
	private int x;

	/**.
	 * Coordinate y
	 */
	private int y;

	/**.
	 * Constructor
	 * @param x defines x
	 * @param y defines y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**.
	 * Getting argument x
	 * @return int x
	 */
	public int getX() {
		return this.x;
	}

	/**.
	 * Getting argument y
	 * @return int y
	 */
	public int getY() {
		return this.y;
	}

	/**.
	 * Checks if a and b belongs to the function y(x) = a*x + b
	 * @param a first number
	 * @param b second number
	 * @return boolean yes or no
	 */
	public boolean is(int a, int b) {
		return this.y == (a * this.x + b) ? true : false;
	}
}