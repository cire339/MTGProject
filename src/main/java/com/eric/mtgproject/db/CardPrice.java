package com.eric.mtgproject.db;
// Generated 19-Nov-2016 9:37:28 PM by Hibernate Tools 5.2.0.Beta1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CardPrice generated by hbm2java
 */
@Entity
@Table(name = "card_price", catalog = "mtg", uniqueConstraints = @UniqueConstraint(columnNames = "CardID"))
public class CardPrice implements java.io.Serializable {

	private Integer cardPriceId;
	private Card card;
	private BigDecimal price;

	public CardPrice() {
	}

	public CardPrice(Card card) {
		this.card = card;
	}

	public CardPrice(Card card, BigDecimal price) {
		this.card = card;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CardPriceID", unique = true, nullable = false)
	public Integer getCardPriceId() {
		return this.cardPriceId;
	}

	public void setCardPriceId(Integer cardPriceId) {
		this.cardPriceId = cardPriceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CardID", unique = true, nullable = false)
	public Card getCard() {
		return this.card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Column(name = "Price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}