package com.example.mockito.basic;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {
    @Test
    public void testFetchData() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        when(mockApi.isAvailable()).thenReturn(true);

        MyService svc = new MyService(mockApi);
        String result = svc.fetchData();

        assertEquals("Fetched Mock Data", result);
        verify(mockApi).getData();
        verify(mockApi).isAvailable();
    }

    @Test
    public void testFetchDataUnavailable() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.isAvailable()).thenReturn(false);

        MyService svc = new MyService(mockApi);
        String result = svc.fetchData();

        assertEquals("Service unavailable", result);
        verify(mockApi, never()).getData();
    }

    @Test
    public void testStoreData() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.isAvailable()).thenReturn(true);

        MyService svc = new MyService(mockApi);
        svc.storeData("Test Data");

        verify(mockApi).sendData("Test Data");
    }

    @Test
    public void testProcessAndFetch() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("HELLO");

        MyService svc = new MyService(mockApi);
        String result = svc.processAndFetch();

        assertEquals("hello", result);
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService svc = new MyService(mockApi);
        svc.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Result");

        MyService svc = new MyService(mockApi);
        svc.storeData("Test");

        verify(mockApi).sendData(anyString());
        verify(mockApi).sendData("Test");
    }

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());

        MyService svc = new MyService(mockApi);
        svc.storeData("Data");

        verify(mockApi, times(1)).sendData("Data");
    }
}
