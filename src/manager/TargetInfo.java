package manager;

import java.io.Serializable;

public class TargetInfo implements Serializable {
	
	
	private String target;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public TargetInfo(String target) {
		super();
		this.target = target;
	}
	
	

}
