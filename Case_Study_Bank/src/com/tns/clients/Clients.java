package com.tns.clients;
import com.tns.bank_application.MMBankFactory;
import com.tns.bank_application.MMSavingAcc;
import com.tns.bank_application.MMCurrentAcc;
public class Clients {
	
public static void main(String[]args) 
{ 
	MMBankFactory b=new MMBankFactory();
	b.getNewSavingAcc(959422,"vish",1800 ,true);
	b.getNewCurrentAcc(121212,"akshay",220,51);
	
	MMSavingAcc sav=new MMSavingAcc(5484, "vish",500, true);
	sav.getAccNo();
	sav.getAccNm();
	sav.getAccBal();
	sav.withdraw(499);
	sav.toString();
	
	MMCurrentAcc cu=new MMCurrentAcc();
	 
	cu.getAccNo();
	cu.getAccNm();
	cu.getAccBal();
	cu.getCreditLimit();
	
	cu.withdraw(1500);
	cu.toString();
}
}
