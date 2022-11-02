package profiling.cpu;

import java.math.BigDecimal;
import java.text.DecimalFormat;

class BigDecimalAccount {
    private BigDecimal balance = BigDecimal.valueOf(10_000);

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        BigDecimalAccount account = new BigDecimalAccount();
        for (int i = 0; i < 10_000; i++) {
            account.credit(BigDecimal.valueOf(10.22));
            account.deposit(BigDecimal.valueOf(20.25));
        }
        System.out.println(new DecimalFormat("completed in ###,###,### ns").format(System.nanoTime() - start));
    }
}
