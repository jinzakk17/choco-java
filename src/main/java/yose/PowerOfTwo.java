package yose;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class PowerOfTwo {
	List<Integer> listOfTwo = new ArrayList();

	public List<Integer> calculatePowerOfTwo(int number) {

		if ((number % 2) == 0) {
			listOfTwo.add(2);
			if (number / 2 != 1) {
				calculatePowerOfTwo(number / 2);
			}

		} else {

			listOfTwo.add(number);
		}

		return listOfTwo;
	}
}  
