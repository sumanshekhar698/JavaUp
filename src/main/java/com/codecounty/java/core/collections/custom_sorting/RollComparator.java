package com.codecounty.java.core.collections.custom_sorting;

import java.util.Comparator;

public class RollComparator implements Comparator<StudentPlain> {

	@Override
	public int compare(StudentPlain s1, StudentPlain s2) {
		if (s1.roll == s2.roll)
			return 0;
		else if (s1.roll > s2.roll)
			return 1;
		else
			return -1;
	}

}
