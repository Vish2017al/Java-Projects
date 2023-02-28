package com.tns.client;

import com.tns.application.GSNormalAcc;
import com.tns.application.GSPrimeAcc;
import com.tns.application.GSShopFactory;

public class Client {

	public static void main(String[] args) {
		GSShopFactory gssfactory = new GSShopFactory();
		gssfactory.getNewPrimeAcc(1189,"Vishal", 499, true);
		gssfactory.getNewNormalAcc(2454,"Harsh" , 899, 40);
		
		GSPrimeAcc gsprime = new GSPrimeAcc(1189,"Vishal",499,true);
		gsprime.getAccNo();
		gsprime.getAccNm();
		gsprime.getCharges();
		
		gsprime.bookProduct(5700);
		gsprime.toString();
		
		GSNormalAcc gsnormal = new GSNormalAcc(2454,"Harsh" , 899, 40);
		gsnormal.getAccNo();
		gsnormal.getAccNm();
		gsnormal.getCharges();
		gsnormal.getDeliveryCharges();
		
		gsnormal.bookProduct(2959);
		gsnormal.toString();

	}

}
