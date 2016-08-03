package util;

import java.util.Comparator;

public class ContactListComparator implements Comparator<Contact>{

	
	public int compare(Contact arg0, Contact arg1) {
		if(arg0.getOrder()<0  && arg1.getOrder()<0){
			return 0;
		}else if(arg0.getOrder()<0){
			return 1;
		}else if(arg1.getOrder()<0){
			return -1;
		}else{
			return Integer.compare(arg0.getOrder(), arg1.getOrder());
		}
		
	}

}
