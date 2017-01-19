package employee;

import java.io.Serializable;

public class EmployeeAppraisal_Info implements Serializable
{
	private static final long serialVersionUID=1L;
	private String employeeid;
	private String leadearship;
	private String teamwork;
	private String customersatisfaction;
	private String discipline;
	private String punctuality;
	private String Nextyeargoals;
	private String date1;
	private String manleadearship;
	private String manteamwork;
	private String mancustomersatisfaction;
	private String mandiscipline;
	private String manpunctuality;
	private String mandate1;
	private String approveflag;
	private String empcomment;
	private String mancomment;
	private double average=0.0;
	
		
	
	



	public EmployeeAppraisal_Info(String employeeid,String leadearship, String teamwork,
			String customersatisfaction, String discipline, String punctuality,
			String nextyeargoals, String date1, String manleadearship,
			String manteamwork, String mancustomersatisfaction,
			String mandiscipline, String manpunctuality, String mandate1,String approveflag) {
		super();
		this.employeeid=employeeid;
		this.leadearship = leadearship;
		this.teamwork = teamwork;
		this.customersatisfaction = customersatisfaction;
		this.discipline = discipline;
		this.punctuality = punctuality;
		this.Nextyeargoals = nextyeargoals;
		this.date1 = date1;
		this.manleadearship = manleadearship;
		this.manteamwork = manteamwork;
		this.mancustomersatisfaction = mancustomersatisfaction;
		this.mandiscipline = mandiscipline;
		this.manpunctuality = manpunctuality;
		this.mandate1 = mandate1;
		this.approveflag=approveflag;
		this.mancomment="";
		this.empcomment="";
		this.average=(double)(Double.parseDouble(mandiscipline)/5+Double.parseDouble(manpunctuality)/5+Double.parseDouble(mancustomersatisfaction)/5+Double.parseDouble(manleadearship)/5+Double.parseDouble(manteamwork)/5);
	}
	
	

	public String getEmpcomment() {
		return empcomment;
	}
	public void setEmpcomment(String empcomment) {
		this.empcomment = empcomment;
	}
	public String getMancomment() {
		return mancomment;
	}
	public void setMancomment(String mancomment) {
		this.mancomment = mancomment;
	}
	public String getLeadearship() {
		return leadearship;
	}
	public void setLeadearship(String leadearship) {
		this.leadearship = leadearship;
	}
	public String getTeamwork() {
		return teamwork;
	}
	public void setTeamwork(String teamwork) {
		this.teamwork = teamwork;
	}
	public String getCustomersatisfaction() {
		return customersatisfaction;
	}
	public void setCustomersatisfaction(String customersatisfaction) {
		this.customersatisfaction = customersatisfaction;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public String getPunctuality() {
		return punctuality;
	}
	public void setPunctuality(String punctuality) {
		this.punctuality = punctuality;
	}
	public String getNextyeargoals() {
		return Nextyeargoals;
	}
	public void setNextyeargoals(String nextyeargoals) {
		Nextyeargoals = nextyeargoals;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getManleadearship() {
		return manleadearship;
	}
	public void setManleadearship(String manleadearship) {
		this.manleadearship = manleadearship;
	}
	public String getManteamwork() {
		return manteamwork;
	}
	public void setManteamwork(String manteamwork) {
		this.manteamwork = manteamwork;
	}
	public String getMancustomersatisfaction() {
		return mancustomersatisfaction;
	}
	public void setMancustomersatisfaction(String mancustomersatisfaction) {
		this.mancustomersatisfaction = mancustomersatisfaction;
	}
	public String getMandiscipline() {
		return mandiscipline;
	}
	public void setMandiscipline(String mandiscipline) {
		this.mandiscipline = mandiscipline;
	}
	public String getManpunctuality() {
		return manpunctuality;
	}
	public void setManpunctuality(String manpunctuality) {
		this.manpunctuality = manpunctuality;
	}
	
	public String getMandate1() {
		return mandate1;
	}
	public void setMandate1(String mandate1) {
		this.mandate1 = mandate1;
	}
	public String getApproveflag() {
		return approveflag;
	}
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public double getAverage() {
		average=(double)(Double.parseDouble(mandiscipline)/5+Double.parseDouble(manpunctuality)/5+Double.parseDouble(mancustomersatisfaction)/5+Double.parseDouble(manleadearship)/5+Double.parseDouble(manteamwork)/5);
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}



}