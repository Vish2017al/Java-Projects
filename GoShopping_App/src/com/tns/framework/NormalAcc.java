package com.tns.framework;

public class NormalAcc extends ShopAcc {

	protected float deliveryCharges=40;
	
     public NormalAcc() {}
     
	public NormalAcc(int accNo, String accNm, float charges, float deliveryCharges) {
		super(accNo, accNm, charges);
		this.deliveryCharges = deliveryCharges;
	}


	public float getDeliveryCharges() {
		return deliveryCharges;
	}
	
	@Override
	public void bookProduct(float charges) {
		// TODO Auto-generated method stub
		super.bookProduct(charges);
	}


	@Override
	public String toString() {
		return "NormalAcc [deliveryCharges=" + deliveryCharges + "]";
	}
}
