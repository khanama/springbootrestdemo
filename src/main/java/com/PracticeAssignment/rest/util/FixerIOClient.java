package com.PracticeAssignment.rest.util;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class FixerIOClient implements CurrencyExchange {
	
	private static final String CURRENCY_EUR = "EUR";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Value("${fixerio.url}")
    private String fixerIOUrl;
    @Value("${fixerio.apiaccesskey}")
    private String fixerIOApiAccessKey;

	@Override
	public double convert(String from, String to, double amount) {
            if (fixerIOApiAccessKey == null
                || fixerIOApiAccessKey.isEmpty()
                || "${fixerio.apiaccesskey}".equals(fixerIOApiAccessKey)) {
                throw new IllegalArgumentException("FixerIO Api Access Key is not set");
            }

            if (!CURRENCY_EUR.equals(to)) {
                throw new IllegalArgumentException("Currently only supported conversion is " + CURRENCY_EUR);
            }

            final FixerIOResponse fixerIOResponse =
                REST_TEMPLATE.getForEntity(URI.create(fixerIOUrl + fixerIOApiAccessKey  ), FixerIOResponse.class).getBody();

            if (fixerIOResponse.getRates() == null) {
                throw new IllegalStateException("No rates were retrieved from Fixer IO");
            }

            return amount * (1.0 / fixerIOResponse.getRates().get(from));
        }

}
