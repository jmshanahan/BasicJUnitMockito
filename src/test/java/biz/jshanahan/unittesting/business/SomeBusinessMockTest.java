package biz.jshanahan.unittesting.business;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;

import biz.jshanahan.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;
	@Mock
	SomeDataService dataServiceMock;
	
	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		int actualResult =business.calculateSumUsingDataService();
		assertEquals(6, actualResult);	
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int actualResult =business.calculateSumUsingDataService();
		assertEquals(0, actualResult);	
	}
}
