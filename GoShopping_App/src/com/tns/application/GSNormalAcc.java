package com.tns.application;

import com.tns.framework.NormalAcc;

public class GSNormalAcc extends NormalAcc
 {

  public GSNormalAcc(int accNo, String accNm, float charges, float deliveryCharges) {
		super(accNo, accNm, charges, deliveryCharges);
		// TODO Auto-generated constructor stub
	}
@Override
public void bookProduct(float charges) {
	System.out.println("Dear Normal User:-\n	Your product Charges are: "+charges+"\n	 And Delivery Charges is: "+deliveryCharges );
	System.out.println("	           Total charges: "+(charges+deliveryCharges));
}
@Override
public String toString() {
	return "GSNormalAcc [accNo=" + getAccNo() + ", charges=" + getCharges() + ", toString()=" + super.toString()
	+ ", getAccNm()=" + getAccNm() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
}

 }
