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

    int total = premium ? 0 : (zone == Zone.URBAN ? 2000 : 5000);

    if (weight > 5) {
        total += (int) ((weight - 5) * 500);
    }

    if (weatherAlertPort.hasFloodAlert(destination)) {
        total += 1000;
    }

    return total;
}

    
}