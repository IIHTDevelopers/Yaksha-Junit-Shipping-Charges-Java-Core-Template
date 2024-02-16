package com.shipping.service;

public class ShippingService {
	private double weight;
	private int distance;

	public ShippingService(double weight, int distance) {
		this.weight = weight;
		this.distance = distance;
	}

	public double calculateShippingCost() {
		double cost = 0.0;
		if (weight <= 5)
			cost = 10 * distance;
		else if (weight <= 20)
			cost = 15 * distance;
		else
			cost = 20 * distance;

		return cost;
	}
}
