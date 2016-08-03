package util;

public class KitsException extends Exception {

	private static final long serialVersionUID = -1595410537102354012L;
	//private String descible;
	private int status;
	public KitsException(String message, int status, String descible) {
		super(new StringBuilder().append(message).append(":").append(status).append(":")
				.append(descible).toString());
		this.status = status;
	}
	public int getStatus(){
		return this.status;
	}
	public KitsException(String message) {
		super(message);
	}
}
