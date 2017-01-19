package manager;

import java.io.Serializable;

public class ManSetDay_Info implements Serializable {
	private static final long serialVersionUID=1L;
	private int date;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public ManSetDay_Info(int date) {
		super();
		this.date = date;
	}

}
