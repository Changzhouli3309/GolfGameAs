package se.lexicon.GolfGame;

import org.junit.Test;
import org.junit.Assert;

public class CountTest {
	@Test
	public void test_GetDistans() {
		double a=45,s=56,g=9.8,expected=320;
		double actual=GolfM.countD(a, s, g);
		Assert.assertEquals(expected, actual,0);
	}
	@Test
	public void test_Matching() {
		double mid1=3,mid2=4;
		int size1=3,size2=8,di=1;
		Assert.assertTrue(GolfM.isHit(GolfM.getSize(mid1, size1, di),GolfM.getSize(mid2, size2, di)));
	}
}
