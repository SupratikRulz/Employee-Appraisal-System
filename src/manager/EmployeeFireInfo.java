package manager;
import java.io.Serializable;

import javax.swing.JComboBox;

	
	



	public class EmployeeFireInfo implements Serializable
	{
		
		private static final long serialVersionUID=1L;
		
		private String sex;
		private String emailid;
		private String address;
		private String marstatus;
		private String phno;
		private String dob;
		private String dept;
		private String password;
		private String approvalstatus;
		private String employeeid;
		
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMarstatus() {
			return marstatus;
		}

		public void setMarstatus(String marstatus) {
			this.marstatus = marstatus;
		}

		public String getPhno() {
			return phno;
		}

		public void setPhno(String phno) {
			this.phno = phno;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getApprovalstatus() {
			return approvalstatus;
		}

		public void setApprovalstatus(String approvalstatus) {
			this.approvalstatus = approvalstatus;
		}

		public String getEmployeeid() {
			return employeeid;
		}

		public void setEmployeeid(String employeeid) {
			this.employeeid = employeeid;
		}

		
		
		public EmployeeFireInfo(String name, String  sex, String emailid,
				String address, String marstatus, String phno, String dob,
				String dept, String password,String employeeid) {
			super();
			this.name = name;
			this.sex = sex;
			this.emailid = emailid;
			this.address = address;
			this.marstatus = marstatus;
			this.phno = phno;
			this.dob = dob;
			this.dept = dept;
			this.password = password;
			this.approvalstatus=approvalstatus;
			this.employeeid=employeeid;
		}
		
	}
		

