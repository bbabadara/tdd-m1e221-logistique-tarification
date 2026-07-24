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

        return 0;
    }

    
}