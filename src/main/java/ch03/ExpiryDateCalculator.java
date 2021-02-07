package ch03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = 1;

        if (payData.getFirstBilldingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if(payData.getFirstBilldingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(payData.getFirstBilldingDate().getDayOfMonth());
            }
        }

        return payData.getBillingDate().plusMonths(addedMonths);
    }
}
