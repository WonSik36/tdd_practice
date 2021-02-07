package ch03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        PayData data = PayData.builder()
                .billingDate(billingDate)
                .payAmount(payAmount)
                .build();

        return calculateExpiryDate(data);
    }

    public LocalDate calculateExpiryDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }
}
