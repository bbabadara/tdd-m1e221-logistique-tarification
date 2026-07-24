package com.logistique.tarification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class DeliveryPricingEngineTest {

    @Mock
    WeatherAlertPort weatherAlertPort;

    DeliveryPricingEngine engine;

    @BeforeEach
    void setup() {
        engine = new DeliveryPricingEngine(weatherAlertPort);
    }
//test tarifzone  urbain
    @Test
    void shouldReturn2000ForUrbanZone() {

        when(weatherAlertPort.hasFloodAlert(anyString()))
                .thenReturn(false);

        int price = engine.calculate(
                Zone.URBAN,
                3,
                false,
                "Dakar");

        assertEquals(2000, price);
    }

// test tarif zone rural
@Test
void shouldReturn5000ForRuralZone() {

    when(weatherAlertPort.hasFloodAlert(anyString()))
            .thenReturn(false);

    int price = engine.calculate(
            Zone.RURAL,
            3,
            false,
            "Kaolack");

    assertEquals(5000, price);
}

}
