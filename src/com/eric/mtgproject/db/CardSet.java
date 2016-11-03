package com.eric.mtgproject.db;
// Generated 3-Nov-2016 10:49:47 AM by Hibernate Tools 5.2.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CardSet generated by hbm2java
 */
@Entity
@Table(name = "card_set", catalog = "mtg")
public class CardSet implements java.io.Serializable {

	private String setId;
	private String block;
	private String border;
	private String gathererCode;
	private String magicCardsInfoCode;
	private String oldCode;
	private boolean onlineOnly;
	private String releaseDate;
	private String setName;
	private String setType;
	private Set<Card> cards = new HashSet<Card>(0);

	public CardSet() {
	}

	public CardSet(String setId, String border, boolean onlineOnly, String releaseDate, String setName,
			String setType) {
		this.setId = setId;
		this.border = border;
		this.onlineOnly = onlineOnly;
		this.releaseDate = releaseDate;
		this.setName = setName;
		this.setType = setType;
	}

	public CardSet(String setId, String block, String border, String gathererCode, String magicCardsInfoCode,
			String oldCode, boolean onlineOnly, String releaseDate, String setName, String setType, Set<Card> cards) {
		this.setId = setId;
		this.block = block;
		this.border = border;
		this.gathererCode = gathererCode;
		this.magicCardsInfoCode = magicCardsInfoCode;
		this.oldCode = oldCode;
		this.onlineOnly = onlineOnly;
		this.releaseDate = releaseDate;
		this.setName = setName;
		this.setType = setType;
		this.cards = cards;
	}

	@Id

	@Column(name = "SetID", unique = true, nullable = false)
	public String getSetId() {
		return this.setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	@Column(name = "Block")
	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	@Column(name = "Border", nullable = false)
	public String getBorder() {
		return this.border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	@Column(name = "GathererCode")
	public String getGathererCode() {
		return this.gathererCode;
	}

	public void setGathererCode(String gathererCode) {
		this.gathererCode = gathererCode;
	}

	@Column(name = "MagicCardsInfoCode")
	public String getMagicCardsInfoCode() {
		return this.magicCardsInfoCode;
	}

	public void setMagicCardsInfoCode(String magicCardsInfoCode) {
		this.magicCardsInfoCode = magicCardsInfoCode;
	}

	@Column(name = "OldCode")
	public String getOldCode() {
		return this.oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	@Column(name = "OnlineOnly", nullable = false)
	public boolean isOnlineOnly() {
		return this.onlineOnly;
	}

	public void setOnlineOnly(boolean onlineOnly) {
		this.onlineOnly = onlineOnly;
	}

	@Column(name = "ReleaseDate", nullable = false)
	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Column(name = "SetName", nullable = false)
	public String getSetName() {
		return this.setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	@Column(name = "SetType", nullable = false)
	public String getSetType() {
		return this.setType;
	}

	public void setSetType(String setType) {
		this.setType = setType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardSet")
	public Set<Card> getCards() {
		return this.cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

}
