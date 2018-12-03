package biz.jshanahan.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import org.mockito.ArgumentCaptor;
import java.util.List;

import org.junit.Test;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());	
	}
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10,mock.size());
	}
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes",mock.get(0));
		assertEquals(null,mock.get(1));
	}
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes",mock.get(0));
		assertEquals("in28Minutes",mock.get(1));
	}
	@Test
	public void verificationBasics() {
		mock.get(0);
		mock.get(1);
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
	}
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("SomeString");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("SomeString", captor.getValue());
	}
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}	
	
}
