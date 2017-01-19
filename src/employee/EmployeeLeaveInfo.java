package employee;

import java.io.Serializable;

public class EmployeeLeaveInfo implements Serializable{
	private static final long serialVersionUID=1L;
	private String numberofleaves="0";
	private String employeeid;
	private String status;
	private String durationofleave;
	private String typeofleave;
	private String reason;
	private String days;
	
	public String getDurationofleave() {
		return durationofleave;
	}
	public void setDurationofleave(String durationofleave) {
		this.durationofleave = durationofleave;
	}
	public String getTypeofleave() {
		return typeofleave;
	}
	public void setTypeofleave(String typeofleave) {
		this.typeofleave = typeofleave;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNumberofleaves() {
		return numberofleaves;
	}
	public void setNumberofleaves(String numberofleaves) {
		this.numberofleaves = numberofleaves;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public EmployeeLeaveInfo( String employeeid,String status) {
		super();
		
		this.employeeid = employeeid;
		this.status = status;
		
	}
	
	
	
	
	

}
