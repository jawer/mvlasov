package ru.job4j.loop;

/**.
 * Class Factorial solving part 4 task 4.2
 * @author Mikhail Vlasov
 * @since 4.8.2017
 * @version 1
 */
public class Factorial {

	/**.
	 * Counting factorial
	 * @param n number
	 * @return int factorial
	 */
	public int calc(int n) {
		int factorial = 1;
		if (n < 0) {
			System.out.println("Invalid input");
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			for (int i = 1; i <= n; i++) {
				factorial = factorial * i;
			}
		}
		return factorial;
	}
}