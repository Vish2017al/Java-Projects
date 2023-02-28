package com.tns.bank_framework;

public  class SavingAcc extends BankAcc {

	private boolean isSalaried;
	private static final float MINBAL=100;
	
	public boolean isSalaried() {
		return isSalaried;
	}
	
	public static float getMinbal() {
		return MINBAL;
	}
	
	public SavingAcc(int accNo,String accNm,float accBal,boolean isSalaried)
	{
		
	}

	public SavingAcc(boolean isSalaried) {
		super();
		this.isSalaried = isSalaried;
	}

	@Override
	public void withdraw(float f) {
		// TODO Auto-generated method stub
		super.withdraw(f);
	}

	@Override
	public String toString() {
		return "SavingAcc [isSalaried=" + isSalaried + ", isSalaried()=" + isSalaried() + ", getAccNo()=" + getAccNo()
				+ ", getAccNm()=" + getAccNm() + ", getAccBal()=" + getAccBal() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	}
	
