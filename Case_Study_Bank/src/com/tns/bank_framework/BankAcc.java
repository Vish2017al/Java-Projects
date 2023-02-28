package com.tns.bank_framework;

public abstract class BankAcc {
private int accNo;
private String accNm;
private float accBal;


public int getAccNo() {
	return accNo;
}

public String getAccNm() {
	return accNm;
}

public void setAccNm(String accNm) {
	this.accNm = accNm;
}

public float getAccBal() {
	return accBal;
}

public BankAcc()
{
	
}

public BankAcc(int accNo, String accNm, float accBal) {
	super();
	this.accNo = accNo;
	this.setAccNm(accNm);
	this.accBal = accBal;
}
public void withdraw(float f)
{
	
}
	public void deposite(float f)
	{
		
	}

	@Override
	public String toString() {
		return "BankAcc [accNo=" + accNo + ", accNm=" + accNm + ", accBal=" + accBal + ", getAccNo()=" + getAccNo()
				+ ", getAccNm()=" + getAccNm() + ", getAccBal()=" + getAccBal() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	


	
}
