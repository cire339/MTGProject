package com.eric.mtgproject.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardSetJson {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("block")
	@Expose
	private String block;
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
	@SerializedName("cards")
	@Expose
	private List<CardJson> cards = new ArrayList<CardJson>();
	@SerializedName("onlineOnly")
	@Expose
	private Boolean onlineOnly;
	
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
	* The cards
	*/
	public List<CardJson> getCards() {
		return cards;
	}
	
	/**
	* 
	* @param cards
	* The cards
	*/
	public void setCards(List<CardJson> cards) {
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

	/**
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * @param block the block to set
	 */
	public void setBlock(String block) {
		this.block = block;
	}

	/**
	 * @return the onlineonly
	 */
	public Boolean getOnlineOnly() {
		return onlineOnly;
	}

	/**
	 * @param onlineonly the onlineonly to set
	 */
	public void setOnlineOnly(Boolean onlineOnly) {
		this.onlineOnly = onlineOnly;
	}

}