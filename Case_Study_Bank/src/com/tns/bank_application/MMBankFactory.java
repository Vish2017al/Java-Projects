package com.tns.bank_application;
import com.tns.bank_framework.*;
public class MMBankFactory implements BankFactory{

	@Override
	public MMSavingAcc getNewSavingAcc(int accNo, String accNm, float accBal, boolean isSalaried) {
		// TODO Auto-generated method stub
		 MMSavingAcc s=new  MMSavingAcc(accNo ,accNm,accBal,isSalaried);
		 return s;
	}

	@Override
	public MMCurrentAcc getNewCurrentAcc(int accNo, String accNm, float accBal, float creditLimit) {
		// TODO Auto-generated method stub
		MMCurrentAcc c=new MMCurrentAcc(accNo ,accNm,accBal,creditLimit);
		return c;
	}

	
}
