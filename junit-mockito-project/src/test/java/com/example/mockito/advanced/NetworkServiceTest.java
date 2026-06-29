package com.example.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {
    @Mock
    private NetworkClient mockClient;
    private NetworkService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new NetworkService(mockClient);
    }

    @Test
    public void testCommunicate() {
        when(mockClient.connect()).thenReturn("Connected");
        when(mockClient.isConnected()).thenReturn(true);

        String result = service.communicate();

        assertEquals("Connected: Connected", result);
        verify(mockClient).connect();
        verify(mockClient).isConnected();
    }

    @Test
    public void testCommunicateFailure() {
        when(mockClient.connect()).thenReturn("Failed");
        when(mockClient.isConnected()).thenReturn(false);

        String result = service.communicate();

        assertEquals("Connection failed", result);
    }

    @Test
    public void testSendMessage() {
        when(mockClient.isConnected()).thenReturn(true);

        service.sendMessage("Hello");

        verify(mockClient).send("Hello");
    }

    @Test
    public void testSendMessageWhenNotConnected() {
        when(mockClient.isConnected()).thenReturn(false);

        service.sendMessage("Hello");

        verify(mockClient, never()).send(anyString());
    }

    @Test
    public void testClose() {
        service.close();

        verify(mockClient).disconnect();
    }

    @Test
    public void testVoidMethodWithException() {
        doThrow(new RuntimeException("Connection error"))
            .when(mockClient).disconnect();

        assertThrows(RuntimeException.class, () -> {
            service.close();
        });

        verify(mockClient).disconnect();
    }

    @Test
    public void testSpyBehavior() {
        NetworkClient spy = spy(new TestNetworkClient());
        NetworkService svc = new NetworkService(spy);

        when(spy.connect()).thenReturn("Spy Connected");
        when(spy.isConnected()).thenReturn(true);

        svc.communicate();

        verify(spy).connect();
    }

    private static class TestNetworkClient implements NetworkClient {
        @Override
        public String connect() {
            return "Real Connected";
        }

        @Override
        public String send(String msg) {
            return "Sent: " + msg;
        }

        @Override
        public void disconnect() {
        }

        @Override
        public boolean isConnected() {
            return false;
        }
    }
}
