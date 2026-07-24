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

//surchage de poids regle 2

@Test
void shouldAddWeightSurcharge() {

    when(weatherAlertPort.hasFloodAlert(anyString()))
            .thenReturn(false);

    int price = engine.calculate(
            Zone.URBAN,
            8,
            false,
            "Dakar");

    assertEquals(3500, price);
}

@Test
void shouldOfferFreeBasePriceForPremium() {

    when(weatherAlertPort.hasFloodAlert(anyString()))
            .thenReturn(false);

    int price = engine.calculate(
            Zone.URBAN,
            4,
            true,
            "Dakar");

    assertEquals(0, price);
}
@Test
void shouldChargeWeightForPremiumAbove15Kg() {

    when(weatherAlertPort.hasFloodAlert(anyString()))
            .thenReturn(false);

    int price = engine.calculate(
            Zone.RURAL,
            18,
            true,
            "Saint-Louis");
    assertEquals(6500, price);
}

@Test
void shouldAddWeatherRiskFee() {

    when(weatherAlertPort.hasFloodAlert(anyString()))
            .thenReturn(true);

    int price = engine.calculate(
            Zone.URBAN,
            4,
            false,
            "Dakar");

    assertEquals(3000, price);
}
}

