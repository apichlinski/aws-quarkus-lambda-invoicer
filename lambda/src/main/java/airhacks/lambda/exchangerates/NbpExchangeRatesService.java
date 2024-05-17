package airhacks.lambda.exchangerates;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class NbpExchangeRatesService implements ExchangeRatesService {
    private final String LIST_DELIMITER = ",";
    @Inject
    @RestClient
    NbpClient client;

    public List<Rate> getExchangeRates() {
        return client.getExchangeRates().getFirst().rates;
    }

    public List<Rate> getExchangeRates(String currency) {
        List<String> currencies = Arrays.stream(currency.toLowerCase().split(LIST_DELIMITER)).toList();
        return getExchangeRates()
                .stream()
                .filter(rate -> currencies.contains(rate.code.toLowerCase()))
                .collect(Collectors.toList());
    }
}
