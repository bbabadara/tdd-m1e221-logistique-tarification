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
int basePrice = premium? 0 : (zone == Zone.URBAN ? 2000 : 5000);
int surcharge = 0;

if(weight>5){
    surcharge=(int)((weight-5)*500);
}

return basePrice+surcharge;
}

    
}