package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WalletBettingTest {

  @Test
  public void walletWith12BalanceWhenBet8ThenBalanceIs4() throws Exception {
    // given
    Wallet wallet = new Wallet();
    wallet.addMoney(12);

    wallet.bet(8);

    assertThat(wallet.balance())
        .isEqualTo(12 - 8); // evident data 12 - 8 = 4
  }

  @Test
  public void walletWith27Bet7AndBet9BalanceIs11() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(27);

    wallet.bet(7);
    wallet.bet(9);

    assertThat(wallet.balance())
        .isEqualTo(27 - 7 - 9);
  }

  @Test
  public void whenBetFullAmountOfWalletThenWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(33);

    wallet.bet(33);

    assertThat(wallet.isEmpty())
        .isTrue();
    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void betMoreThanBalanceThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(9);

    assertThatThrownBy(() -> {
      wallet.bet(10);
    }).isInstanceOf(IllegalArgumentException.class);
  }

}