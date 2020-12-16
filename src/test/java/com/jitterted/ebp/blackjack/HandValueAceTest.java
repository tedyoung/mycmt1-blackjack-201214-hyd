package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.SPADES;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHand("A", "5");

    // possible alternative
    String value = hand.displayValue();
    assertThat(hand.isValueEqualTo(11 + 5))
        .describedAs("Hand value was " + value)
        .isTrue();

//    assertThat(hand.value())
//        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "8", "3");

    assertThat(hand.isValueEqualTo(1 + 8 + 3))
        .isTrue();
  }

  private Hand createHand(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DUMMY_SUIT, rank));
    }

    StubDeck stubDeck = new StubDeck(cards);

    Hand hand = new Hand();

    for (int i = 0; i < cards.size(); i++) {
      hand.drawCard(stubDeck);
    }

    return hand;
  }

  static class StubDeck extends Deck {
    private final Iterator<Card> cardIterator;

    public StubDeck(List<Card> cards) {
      this.cardIterator = cards.listIterator();
    }

    @Override
    public Card draw() {
      return cardIterator.next();
    }
  }

}
