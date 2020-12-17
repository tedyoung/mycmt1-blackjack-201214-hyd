package com.jitterted.ebp.blackjack;

public class Wallet {
  private int balance = 0;

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    ensureAmountIsZeroOrMore(amount);
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int betAmount) {
    ensureSufficientBalance(betAmount);
    balance -= betAmount;
  }

  private void ensureAmountIsZeroOrMore(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureSufficientBalance(int betAmount) {
    if (balance < betAmount) {
      throw new IllegalArgumentException();
    }
  }
}
