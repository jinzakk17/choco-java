package yose;

import java.math.*;
import java.util.ArrayList;

public class PowerOfTwo {
	ArrayList<Integer> listOfTwo = new ArrayList();

	public void calculatePowerOfTwo(int number) {

		if ((number % 2) == 0) {
			listOfTwo.add(2);
			if (number / 2 != 1) {
				calculatePowerOfTwo(number / 2);
			}

		} else {

			listOfTwo.add(number);
		}

	}

}  