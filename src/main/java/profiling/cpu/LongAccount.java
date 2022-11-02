package profiling.cpu;

class LongAccount {
    private long balance = 1_000_000; // cents

    public void deposit(long amount) {
        this.balance -= amount;
    }

    public void credit(long amount) {
        this.balance += amount;
    }

    public long getBalanceCents() {
        return balance;
    }

    public double getBalanceEur() {
        return  balance/100.0;
    }
}
