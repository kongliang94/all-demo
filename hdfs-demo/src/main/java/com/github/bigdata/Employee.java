package com.github.bigdata;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Employee implements WritableComparable<Employee>{

	//7369,SMITH,CLERK,7902,1980/12/17,800,0,20
	private int empno;
	private String empname;
	private String job;
	private int leaderno;
	private String enterdate;
	private int sal;
	private int comm;
	private int deptno;


	public Employee(int empno, String empname, String job, int leaderno, String enterdate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.empname = empname;
		this.job = job;
		this.leaderno = leaderno;
		this.enterdate = enterdate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		this.empno = input.readInt();
		this.empname = input.readUTF();
		this.job = input.readUTF();
		this.leaderno = input.readInt();
		this.enterdate = input.readUTF();
		this.sal = input.readInt();
		this.comm = input.readInt();
		this.deptno = input.readInt();
		
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(this.empno);
		output.writeUTF(this.empname);
		output.writeUTF(this.job);
		output.writeInt(this.leaderno);
		output.writeUTF(this.enterdate);
		output.writeInt(this.sal);
		output.writeInt(this.comm);
		output.writeInt(this.deptno);
		
	}


	@Override
	public int compareTo(Employee o) {
		//当前员工薪水小于传入对象员工薪水
		if (this.getDeptno()>o.getDeptno()){
			return 1;
		}else if(this.getDeptno()<o.getDeptno()){
			return -1;
		}else{
			return this.getSal()-o.getSal();
		}
	}
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getLeaderno() {
		return leaderno;
	}
	public void setLeaderno(int leaderno) {
		this.leaderno = leaderno;
	}
	public String getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
