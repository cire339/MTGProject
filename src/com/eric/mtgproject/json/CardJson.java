package com.eric.mtgproject.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardJson {

	@SerializedName("artist")
	@Expose
	private String artist;
	@SerializedName("border")
	@Expose
	private String border;
	@SerializedName("cmc")
	@Expose
	private String cmc;
	@SerializedName("colorIdentity")
	@Expose
	private List<String> colorIdentity = new ArrayList<String>();
	@SerializedName("colors")
	@Expose
	private List<String> colors = new ArrayList<String>();
	@SerializedName("flavor")
	@Expose
	private String flavor;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("imageName")
	@Expose
	private String imageName;
	@SerializedName("layout")
	@Expose
	private String layout;
	@SerializedName("loyalty")
	@Expose
	private String loyalty;
	@SerializedName("manaCost")
	@Expose
	private String manaCost;
	@SerializedName("mciNumber")
	@Expose
	private String mciNumber;
	@SerializedName("multiverseid")
	@Expose
	private String multiverseid;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("names")
	@Expose
	private List<String> names = new ArrayList<String>();
	@SerializedName("number")
	@Expose
	private String number;
	@SerializedName("power")
	@Expose
	private String power;
	@SerializedName("rarity")
	@Expose
	private String rarity;
	@SerializedName("reserved")
	@Expose
	private Boolean reserved;
	@SerializedName("subtypes")
	@Expose
	private List<String> subtypes = new ArrayList<String>();
	@SerializedName("supertypes")
	@Expose
	private List<String> supertypes = new ArrayList<String>();
	@SerializedName("text")
	@Expose
	private String text;
	@SerializedName("timeshifted")
	@Expose
	private Boolean timeshifted;
	@SerializedName("toughness")
	@Expose
	private String toughness;
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("types")
	@Expose
	private List<String> types = new ArrayList<String>();
	@SerializedName("variations")
	@Expose
	private List<String> variations = new ArrayList<String>();
	@SerializedName("watermark")
	@Expose
	private String watermark;
	
	/**
	* 
	* @return
	* The artist
	*/
	public String getArtist() {
	return artist;
	}
	
	/**
	* 
	* @param artist
	* The artist
	*/
	public void setArtist(String artist) {
	this.artist = artist;
	}
	
	/**
	* 
	* @return
	* The cmc
	*/
	public String getCmc() {
	return cmc;
	}
	
	/**
	* 
	* @param cmc
	* The cmc
	*/
	public void setCmc(String cmc) {
	this.cmc = cmc;
	}
	
	/**
	* 
	* @return
	* The colorIdentity
	*/
	public List<String> getColorIdentity() {
	return colorIdentity;
	}
	
	/**
	* 
	* @param colorIdentity
	* The colorIdentity
	*/
	public void setColorIdentity(List<String> colorIdentity) {
	this.colorIdentity = colorIdentity;
	}
	
	/**
	* 
	* @return
	* The colors
	*/
	public List<String> getColors() {
	return colors;
	}
	
	/**
	* 
	* @param colors
	* The colors
	*/
	public void setColors(List<String> colors) {
	this.colors = colors;
	}
	
	/**
	* 
	* @return
	* The flavor
	*/
	public String getFlavor() {
	return flavor;
	}
	
	/**
	* 
	* @param flavor
	* The flavor
	*/
	public void setFlavor(String flavor) {
	this.flavor = flavor;
	}
	
	/**
	* 
	* @return
	* The id
	*/
	public String getId() {
	return id;
	}
	
	/**
	* 
	* @param id
	* The id
	*/
	public void setId(String id) {
	this.id = id;
	}
	
	/**
	* 
	* @return
	* The imageName
	*/
	public String getImageName() {
	return imageName;
	}
	
	/**
	* 
	* @param imageName
	* The imageName
	*/
	public void setImageName(String imageName) {
	this.imageName = imageName;
	}
	
	/**
	* 
	* @return
	* The layout
	*/
	public String getLayout() {
	return layout;
	}
	
	/**
	* 
	* @param layout
	* The layout
	*/
	public void setLayout(String layout) {
	this.layout = layout;
	}
	
	/**
	* 
	* @return
	* The manaCost
	*/
	public String getManaCost() {
	return manaCost;
	}
	
	/**
	* 
	* @param manaCost
	* The manaCost
	*/
	public void setManaCost(String manaCost) {
	this.manaCost = manaCost;
	}
	
	/**
	* 
	* @return
	* The mciNumber
	*/
	public String getMciNumber() {
	return mciNumber;
	}
	
	/**
	* 
	* @param mciNumber
	* The mciNumber
	*/
	public void setMciNumber(String mciNumber) {
	this.mciNumber = mciNumber;
	}
	
	/**
	* 
	* @return
	* The multiverseid
	*/
	public String getMultiverseid() {
	return multiverseid;
	}
	
	/**
	* 
	* @param multiverseid
	* The multiverseid
	*/
	public void setMultiverseid(String multiverseid) {
	this.multiverseid = multiverseid;
	}
	
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
	* The power
	*/
	public String getPower() {
	return power;
	}
	
	/**
	* 
	* @param power
	* The power
	*/
	public void setPower(String power) {
	this.power = power;
	}
	
	/**
	* 
	* @return
	* The rarity
	*/
	public String getRarity() {
	return rarity;
	}
	
	/**
	* 
	* @param rarity
	* The rarity
	*/
	public void setRarity(String rarity) {
	this.rarity = rarity;
	}
	
	/**
	* 
	* @return
	* The subtypes
	*/
	public List<String> getSubtypes() {
	return subtypes;
	}
	
	/**
	* 
	* @param subtypes
	* The subtypes
	*/
	public void setSubtypes(List<String> subtypes) {
	this.subtypes = subtypes;
	}
	
	/**
	* 
	* @return
	* The text
	*/
	public String getText() {
	return text;
	}
	
	/**
	* 
	* @param text
	* The text
	*/
	public void setText(String text) {
	this.text = text;
	}
	
	/**
	* 
	* @return
	* The toughness
	*/
	public String getToughness() {
	return toughness;
	}
	
	/**
	* 
	* @param toughness
	* The toughness
	*/
	public void setToughness(String toughness) {
	this.toughness = toughness;
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
	* The types
	*/
	public List<String> getTypes() {
	return types;
	}
	
	/**
	* 
	* @param types
	* The types
	*/
	public void setTypes(List<String> types) {
	this.types = types;
	}

	/**
	 * @return the border
	 */
	public String getBorder() {
		return border;
	}

	/**
	 * @param border the border to set
	 */
	public void setBorder(String border) {
		this.border = border;
	}

	/**
	 * @return the loyalty
	 */
	public String getLoyalty() {
		return loyalty;
	}

	/**
	 * @param loyalty the loyalty to set
	 */
	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}

	/**
	 * @return the names
	 */
	public List<String> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<String> names) {
		this.names = names;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the reserved
	 */
	public Boolean getReserved() {
		return reserved;
	}

	/**
	 * @param reserved the reserved to set
	 */
	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	/**
	 * @return the supertypes
	 */
	public List<String> getSupertypes() {
		return supertypes;
	}

	/**
	 * @param supertypes the supertypes to set
	 */
	public void setSupertypes(List<String> supertypes) {
		this.supertypes = supertypes;
	}

	/**
	 * @return the timeshifted
	 */
	public Boolean getTimeshifted() {
		return timeshifted;
	}

	/**
	 * @param timeshifted the timeshifted to set
	 */
	public void setTimeshifted(Boolean timeshifted) {
		this.timeshifted = timeshifted;
	}

	/**
	 * @return the variations
	 */
	public List<String> getVariations() {
		return variations;
	}

	/**
	 * @param variations the variations to set
	 */
	public void setVariations(List<String> variations) {
		this.variations = variations;
	}

	/**
	 * @return the watermark
	 */
	public String getWatermark() {
		return watermark;
	}

	/**
	 * @param watermark the watermark to set
	 */
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

}