package com.tns.bank_framework;

public class CurrentAcc extends BankAcc{

private final float creditLimit=1500;

public float getCreditLimit() {
	return creditLimit;
}
public CurrentAcc()
{
	
}
public CurrentAcc(int accNo, String accNm, float accBal,float  creditLimit ) {
	super(accNo, accNm, creditLimit);
	// TODO Auto-generated constructor stub
}
@Override
public void withdraw(float f) {
	// TODO Auto-generated method stub
	super.withdraw(f);
}
@Override
public String toString() {
	return "CurrentAcc [creditLimit=" + creditLimit + ", getCreditLimit()=" + getCreditLimit() + ", getAccNo()="
			+ getAccNo() + ", getAccNm()=" + getAccNm() + ", getAccBal()=" + getAccBal() + ", toString()="
			+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}

}
