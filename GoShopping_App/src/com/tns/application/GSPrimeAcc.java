package com.tns.application;

import com.tns.framework.PrimeAcc;

public class GSPrimeAcc extends PrimeAcc 
{
   private static final float Charges = 0;
   
   public GSPrimeAcc(int accNo, String accNm, float charges, boolean isPrime) {}
   

public GSPrimeAcc(int accNo, String accNm, float charges) {
	super(accNo, accNm, charges);
	// TODO Auto-generated constructor stub
}


public static float getDliverycharges() {
	return Charges;
}

@Override
public void bookProduct(float charges) {
	// TODO Auto-generated method stub
	super.bookProduct(charges);
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}


}
