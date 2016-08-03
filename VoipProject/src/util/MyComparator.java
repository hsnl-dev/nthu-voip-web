package util;

import java.util.Comparator;

import talk.account.service.xsd.WebContact;

public class MyComparator implements Comparator{

	/**
	 * @param args
	 */
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		WebContact o1 = (WebContact) arg0;
		WebContact o2 = (WebContact) arg1;
		int order1 = o1.getOrder();
		int order2 = o2.getOrder();
		return order1 - order2;
	}

}
