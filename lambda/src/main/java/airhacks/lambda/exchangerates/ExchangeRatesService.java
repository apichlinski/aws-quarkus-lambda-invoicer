package airhacks.lambda.exchangerates;

import java.util.List;

public interface ExchangeRatesService {
    List<Rate> getExchangeRates();
    List<Rate> getExchangeRates(String currency);

}
