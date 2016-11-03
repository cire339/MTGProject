package com.eric.mtgproject.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardSet {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("gathererCode")
	@Expose
	private String gathererCode;
	@SerializedName("oldCode")
	@Expose
	private String oldCode;
	@SerializedName("magicCardsInfoCode")
	@Expose
	private String magicCardsInfoCode;
	@SerializedName("releaseDate")
	@Expose
	private String releaseDate;
	@SerializedName("border")
	@Expose
	private String border;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("booster")
	@Expose
	private Object booster = new Object[15];
	@SerializedName("cards")
	@Expose
	private List<Card> cards = new ArrayList<Card>();
	
	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
		return name;
	}
	
	/**
	* 
	* @param name
	* The name
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* 
	* @return
	* The code
	*/
	public String getCode() {
		return code;
	}
	
	/**
	* 
	* @param code
	* The code
	*/
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	* 
	* @return
	* The gathererCode
	*/
	public String getGathererCode() {
		return gathererCode;
	}
	
	/**
	* 
	* @param gathererCode
	* The gathererCode
	*/
	public void setGathererCode(String gathererCode) {
		this.gathererCode = gathererCode;
	}
	
	/**
	* 
	* @return
	* The magicCardsInfoCode
	*/
	public String getMagicCardsInfoCode() {
		return magicCardsInfoCode;
	}
	
	/**
	* 
	* @param magicCardsInfoCode
	* The magicCardsInfoCode
	*/
	public void setMagicCardsInfoCode(String magicCardsInfoCode) {
		this.magicCardsInfoCode = magicCardsInfoCode;
	}
	
	/**
	* 
	* @return
	* The releaseDate
	*/
	public String getReleaseDate() {
		return releaseDate;
	}
	
	/**
	* 
	* @param releaseDate
	* The releaseDate
	*/
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	* 
	* @return
	* The border
	*/
	public String getBorder() {
		return border;
	}
	
	/**
	* 
	* @param border
	* The border
	*/
	public void setBorder(String border) {
		this.border = border;
	}
	
	/**
	* 
	* @return
	* The type
	*/
	public String getType() {
		return type;
	}
	
	/**
	* 
	* @param type
	* The type
	*/
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	* 
	* @return
	* The booster
	*/
	public Object getBooster() {
		return booster;
	}

	/**
	* 
	* @param booster
	* The booster
	*/
	public void setBooster(Object booster) {
		this.booster = booster;
	}
	
	/**
	* 
	* @return
	* The cards
	*/
	public List<Card> getCards() {
		return cards;
	}
	
	/**
	* 
	* @param cards
	* The cards
	*/
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	/**
	 * @return the oldCode
	 */
	public String getOldCode() {
		return oldCode;
	}

	/**
	 * @param oldCode the oldCode to set
	 */
	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

}