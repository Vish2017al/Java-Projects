package com.tns.application;
import com.tns.framework.ShopFactory;
public class GSShopFactory implements ShopFactory{

	@Override
	public GSPrimeAcc getNewPrimeAcc(int accNo, String accNm, float charges, boolean isPrime) {
		
		GSPrimeAcc gsprime=new GSPrimeAcc(accNo,accNm,charges, isPrime);
		return gsprime;
	}

	@Override
	public GSNormalAcc getNewNormalAcc(int accNo, String accNm, float charges, float deliveryCharges) {
		// TODO Auto-generated method stub
		GSNormalAcc gsnormal=new GSNormalAcc(accNo,accNm,charges,deliveryCharges);
		return gsnormal;
	}
	

}
