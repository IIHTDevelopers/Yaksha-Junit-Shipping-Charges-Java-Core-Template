package com.shipping.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.shipping.service.ShippingService;

public class ShippingTest {
	ShippingService service = null;

	@Test
	public void testCalculateShippingCost_LightPackage() {
		service = new ShippingService(2, 100);
		assertEquals(1000, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_MediumPackage() {
		service = new ShippingService(10, 100);
		assertEquals(1500, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_HeavyPackage() {
		service = new ShippingService(25, 100);
		assertEquals(2000, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_MinimalDistance() {
		service = new ShippingService(10, 1); // Minimal distance with a medium weight package
		assertEquals(15, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_VeryHeavyPackage() {
		service = new ShippingService(100, 50); // Very heavy package with moderate distance
		assertEquals(1000, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_ZeroWeightPackage() {
		service = new ShippingService(0, 100); // Edge case: zero weight (should handle as the lightest package)
		assertEquals(1000, service.calculateShippingCost(), 0.001);
	}
}