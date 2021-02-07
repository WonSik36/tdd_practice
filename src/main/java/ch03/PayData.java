package ch03;

import java.time.LocalDate;

public class PayData {
    private LocalDate firstBilldingDate;
    private LocalDate billingDate;
    private int payAmount;

    private PayData() {}

    public PayData(LocalDate firstBilldingDate, LocalDate billingDate, int payAmount) {
        this.firstBilldingDate = firstBilldingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBilldingDate() {
        return firstBilldingDate;
    }

    public LocalDate getBillingDate() {
        return this.billingDate;
    }

    public int getPayAmount() {
        return this.payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.firstBilldingDate = firstBillingDate;
            return this;
        }

        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }

        public PayData build() {
            return data;
        }
    }
}
