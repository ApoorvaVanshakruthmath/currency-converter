import java.util.HashMap;
import java.util.Scanner;

interface Converter {
    double convert(double amount, String currencyCode);
}

class CurrencyConverter implements Converter {

    private HashMap<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.94);
        exchangeRates.put("GBP", 0.82);
        exchangeRates.put("INR", 82.81);
        exchangeRates.put("JPY", 132.14);
    }

    public double convert(double amount, String currencyCode) {
        if (!exchangeRates.containsKey(currencyCode)) {
            System.out.println("Invalid currency code!");
            return 0;
        }

        double exchangeRate = exchangeRates.get(currencyCode);
        double convertedAmount = amount * exchangeRate;
        return convertedAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter currencyConverter = new CurrencyConverter();

        System.out.println("Enter the amount in USD: ");
        double amount = scanner.nextDouble();

        System.out.println("Enter the currency code (USD, EUR, GBP, INR, JPY): ");
        String currencyCode = scanner.next().toUpperCase();

        double convertedAmount = currencyConverter.convert(amount, currencyCode);

        System.out.println("Amount: " + amount + " USD");
        System.out.println("Converted Amount: " + convertedAmount + " " + currencyCode);
    }
}
