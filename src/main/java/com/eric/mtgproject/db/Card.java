package com.eric.mtgproject.db;
// Generated 10-Nov-2016 6:56:03 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Card generated by hbm2java
 */
@Entity
@Table(name = "card", catalog = "mtg")
public class Card implements java.io.Serializable {

	private String cardId;
	private CardSet cardSet;
	private String artist;
	private String border;
	private String cmc;
	private String colorIdentity;
	private String colors;
	private String flavor;
	private String imageName;
	private String layout;
	private String loyalty;
	private String manaCost;
	private String mcinumber;
	private String multiverseId;
	private String name;
	private String cardNames;
	private String cardNumber;
	private String cardPower;
	private String rarity;
	private Boolean reserved;
	private String subtypes;
	private String superTypes;
	private String text;
	private Boolean timeShifted;
	private String toughness;
	private String cardType;
	private String types;
	private String variations;
	private String watermark;

	public Card() {
	}

	public Card(String cardId, CardSet cardSet, String artist, String colorIdentity, String colors, String imageName,
			String name, String rarity, String cardType, String types) {
		this.cardId = cardId;
		this.cardSet = cardSet;
		this.artist = artist;
		this.colorIdentity = colorIdentity;
		this.colors = colors;
		this.imageName = imageName;
		this.name = name;
		this.rarity = rarity;
		this.cardType = cardType;
		this.types = types;
	}

	public Card(String cardId, CardSet cardSet, String artist, String border, String cmc, String colorIdentity,
			String colors, String flavor, String imageName, String layout, String loyalty, String manaCost,
			String mcinumber, String multiverseId, String name, String cardNames, String cardNumber, String cardPower,
			String rarity, Boolean reserved, String subtypes, String superTypes, String text, Boolean timeShifted,
			String toughness, String cardType, String types, String variations, String watermark) {
		this.cardId = cardId;
		this.cardSet = cardSet;
		this.artist = artist;
		this.border = border;
		this.cmc = cmc;
		this.colorIdentity = colorIdentity;
		this.colors = colors;
		this.flavor = flavor;
		this.imageName = imageName;
		this.layout = layout;
		this.loyalty = loyalty;
		this.manaCost = manaCost;
		this.mcinumber = mcinumber;
		this.multiverseId = multiverseId;
		this.name = name;
		this.cardNames = cardNames;
		this.cardNumber = cardNumber;
		this.cardPower = cardPower;
		this.rarity = rarity;
		this.reserved = reserved;
		this.subtypes = subtypes;
		this.superTypes = superTypes;
		this.text = text;
		this.timeShifted = timeShifted;
		this.toughness = toughness;
		this.cardType = cardType;
		this.types = types;
		this.variations = variations;
		this.watermark = watermark;
	}

	@Id

	@Column(name = "CardID", unique = true, nullable = false)
	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SetID", nullable = false)
	public CardSet getCardSet() {
		return this.cardSet;
	}

	public void setCardSet(CardSet cardSet) {
		this.cardSet = cardSet;
	}

	@Column(name = "Artist", nullable = false)
	public String getArtist() {
		return this.artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Column(name = "Border")
	public String getBorder() {
		return this.border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	@Column(name = "CMC")
	public String getCmc() {
		return this.cmc;
	}

	public void setCmc(String cmc) {
		this.cmc = cmc;
	}

	@Column(name = "ColorIdentity", nullable = false)
	public String getColorIdentity() {
		return this.colorIdentity;
	}

	public void setColorIdentity(String colorIdentity) {
		this.colorIdentity = colorIdentity;
	}

	@Column(name = "Colors", nullable = false)
	public String getColors() {
		return this.colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	@Column(name = "Flavor", length = 500)
	public String getFlavor() {
		return this.flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Column(name = "ImageName", nullable = false)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "Layout")
	public String getLayout() {
		return this.layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	@Column(name = "Loyalty")
	public String getLoyalty() {
		return this.loyalty;
	}

	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	@Column(name = "ManaCost")
	public String getManaCost() {
		return this.manaCost;
	}

	public void setManaCost(String manaCost) {
		this.manaCost = manaCost;
	}

	@Column(name = "MCINumber")
	public String getMcinumber() {
		return this.mcinumber;
	}

	public void setMcinumber(String mcinumber) {
		this.mcinumber = mcinumber;
	}

	@Column(name = "MultiverseID")
	public String getMultiverseId() {
		return this.multiverseId;
	}

	public void setMultiverseId(String multiverseId) {
		this.multiverseId = multiverseId;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CardNames")
	public String getCardNames() {
		return this.cardNames;
	}

	public void setCardNames(String cardNames) {
		this.cardNames = cardNames;
	}

	@Column(name = "CardNumber")
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "CardPower")
	public String getCardPower() {
		return this.cardPower;
	}

	public void setCardPower(String cardPower) {
		this.cardPower = cardPower;
	}

	@Column(name = "Rarity", nullable = false)
	public String getRarity() {
		return this.rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	@Column(name = "Reserved")
	public Boolean getReserved() {
		return this.reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	@Column(name = "Subtypes")
	public String getSubtypes() {
		return this.subtypes;
	}

	public void setSubtypes(String subtypes) {
		this.subtypes = subtypes;
	}

	@Column(name = "SuperTypes")
	public String getSuperTypes() {
		return this.superTypes;
	}

	public void setSuperTypes(String superTypes) {
		this.superTypes = superTypes;
	}

	@Column(name = "Text", length = 1000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "TimeShifted")
	public Boolean getTimeShifted() {
		return this.timeShifted;
	}

	public void setTimeShifted(Boolean timeShifted) {
		this.timeShifted = timeShifted;
	}

	@Column(name = "Toughness")
	public String getToughness() {
		return this.toughness;
	}

	public void setToughness(String toughness) {
		this.toughness = toughness;
	}

	@Column(name = "CardType", nullable = false)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "Types", nullable = false)
	public String getTypes() {
		return this.types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Column(name = "Variations")
	public String getVariations() {
		return this.variations;
	}

	public void setVariations(String variations) {
		this.variations = variations;
	}

	@Column(name = "Watermark")
	public String getWatermark() {
		return this.watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

}