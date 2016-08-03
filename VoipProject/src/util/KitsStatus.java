package util;

import org.apache.http.HttpStatus;

public interface KitsStatus extends HttpStatus{
	public static final int KITS_DUPLICATED = 40901; 
	public static final int KITS_ACC_NOT_FOUND = 40902; 
	
	public static final int KITS_BAD_REQUEST = 40001;
	public static final int KITS_UNAUTHORIZED = 40103;
}
