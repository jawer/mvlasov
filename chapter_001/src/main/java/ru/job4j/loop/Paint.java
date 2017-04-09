package ru.job4j.loop;

/**.
 * Class Factorial solving part 4 task 4.2
 * @author Mikhail Vlasov
 * @since 4.8.2017
 * @version 1
 */
public class Paint {

	/**.
	 * Painting a piramid
	 * @param h height
	 * @return String piramid
	 */
	public String piramid(int h) {
		String piramid = "";
		//int cupCounter = 1;
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= h * 2 - 1; j++) {
				if (((j <= h) && ((j + i) <= h)) || ((j > h) && (j - i) >= h)) {
					piramid += " ";
				} else {
					piramid += "^";
				}
			}
			//cupCounter += 2;
			if (i != h) {
				piramid += System.getProperty("line.separator");
			}
		}
		return piramid;
	}
}