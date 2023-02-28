package com.tns.bank_application;
import com.tns.bank_framework.SavingAcc;

public class MMSavingAcc extends SavingAcc {
	
private static final float MINBAL = 1000;
	


	public MMSavingAcc(int accNo, String accNm, float accBal, boolean isSalaried)
	{
		super(accNo, accNm, accBal, isSalaried);
	}
	
	@Override
	public void withdraw(float accBal)
	{
		System.out.println("Dear Customer:\n		Your Saving Account Balance  are:"+accBal);
	}

	
	
	@Override
	public String toString() {
		return "MMSavingAcc [isSalaried()=" + isSalaried() + ", toString()=" + super.toString() + ", getAccNo()="
				+ getAccNo() + ", getAccNm()=" + getAccNm() + ", getAccBal()=" + getAccBal() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public static float getMinbal()
	{
		return MINBAL;
	}
}