package ch02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result1 = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result1);

        PasswordStrength result2 = meter.meter("abc1!ADD");
        assertEquals(PasswordStrength.STRONG, result2);
    }
}
