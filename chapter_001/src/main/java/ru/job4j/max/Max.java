package ru.job4j.max;

/**.
 * Class Max ������� ������ ����� 3 ����� 3.1
 * @author Mikhail Vlasov
 * @since 4.4.2017
 * @version 1
 */
public class Max {

	/**
	 * ���������� ������������ �� ���� �����.
	 * @param first ������ �����
	 * @param second ������ �����
	 * @return int ������� �� ���� �����
	 */
	public int max(int first, int second) {
		int maximum;
		maximum = first >= second ? first : second;
		return maximum;
	}
}