package com.testng;

import org.testng.annotations.Test;

public class Group {
	@Test(groups="smoke")
	private void m1() {
		System.out.println("m1 smoke");

	}
	@Test(groups="sanity")
	private void m2() {
		System.out.println("m2 sanity");

	}
	@Test(groups="Reg")
	private void m3() {
		System.out.println("m3 Reg");

	}
	@Test(groups="smoke")
	private void m4() {
		System.out.println("m4 smoke");

	}

}
