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

    int total;

    if (zone == Zone.URBAN)
        total = 2000;
    else
        total = 5000;

    if (weight > 5) {
        total += (weight - 5) * 500;
    }

    return total;
}

    
}