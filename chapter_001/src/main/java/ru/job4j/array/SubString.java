package ru.job4j.array;

/**.
 * Class SubString solving part 6
 * @author Mikhail Vlasov
 * @since 4.20.2017
 * @version 1
 */
public class SubString {

	/**.
	 * Duplicate removal
	 * @param origin string
	 * @param sub substring
	 * @return boolean
	 */
	boolean contains(String origin, String sub) {
		/**.
		 * Checks if one of the strings is null ore substring is bigger than string
		 */
		if ((origin.length() == 0) || (sub.length() == 0) || (origin.length() < sub.length())) {
			return false;
		}
		char[] charArray = new char[origin.length()];
		char[] charSubArray = new char[sub.length()];
		charArray = origin.toCharArray();
		charSubArray = sub.toCharArray();
		boolean isContain = false;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == charSubArray[0]) {
				/**.
				 * Checks if char array of the string contains one symbol
				 */
				if (charSubArray.length == 1) {
					return true;
				}
				/**.
				 * Checks if the rest of the array of the string smaller than the rest of the array of the substring
				 */
				if ((charArray.length - i - 1) < (charSubArray.length - 1)) {
					return false;
				}
				/**.
				 * Compares array of the string with array of the substring
				 */
				for (int j = 1; j < charSubArray.length; j++) {
					if (charSubArray[j] != charArray[i + j]) {
						isContain = false;
						break;
					}
					isContain = true;
				}
			}
		}
		return isContain;
	}
}