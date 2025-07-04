import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount(123456, "Ivan", 1000.0);
    }

    @Test
    public void shouldDepositValidAmount() {
        assertEquals(1500.0, account.deposit(500.0), 0.001);
    }

    @Test
    public void shouldNotDepositInvalidAmount() {
        assertEquals(1000.0, account.deposit(-200.0), 0.001);
    }

    @Test
    public void shouldWithdrawValidAmount() {
        assertEquals(800.0, account.withdraw(200.0), 0.001);
    }

    @Test
    public void shouldNotWithdrawNegativeAmount() {
        assertEquals(1000.0, account.withdraw(-50.0), 0.001);
    }

    @Test
    public void shouldNotWithdrawAmountGreaterThanBalance() {
        assertEquals(1000.0, account.withdraw(2000.0), 0.001);
    }

    @Test
    public void shouldReturnCorrectAccountNumber() {
        assertEquals(123456, account.getAccountNumber());
    }

    @Test
    public void shouldCreateAccountWithZeroBalance() {
        BankAccount newAccount = new BankAccount(456, "Coach Migs", 0.0);
        assertEquals(0.0, newAccount.getBalance(), 0.001);
        assertEquals(456, newAccount.getAccountNumber());
    }
}
