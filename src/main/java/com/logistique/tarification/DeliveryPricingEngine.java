package com.logistique.tarification;

public class DeliveryPricingEngine {

    private final WeatherAlertPort weatherAlertPort;

    public DeliveryPricingEngine(WeatherAlertPort weatherAlertPort) {
        this.weatherAlertPort = weatherAlertPort;
    }

    public int calculate(Zone zone,
                         double weight,
                         boolean premium,
                         String destination) {

          if (zone == Zone.URBAN)
        return 2000;

    return 5000;
    }

    
}