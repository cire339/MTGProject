CREATE TABLE `card` (
  `CardID` varchar(255) NOT NULL,
  `Artist` varchar(255) NOT NULL,
  `Border` varchar(255) DEFAULT NULL,
  `CMC` varchar(255) DEFAULT NULL,
  `ColorIdentity` varchar(255) NOT NULL,
  `Colors` varchar(255) NOT NULL,
  `Flavor` varchar(500) DEFAULT NULL,
  `ImageName` varchar(255) NOT NULL,
  `Layout` varchar(255) DEFAULT NULL,
  `Loyalty` varchar(255) DEFAULT NULL,
  `ManaCost` varchar(255) DEFAULT NULL,
  `MCINumber` varchar(255) DEFAULT NULL,
  `MultiverseID` varchar(255) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `CardNames` varchar(255) DEFAULT NULL,
  `CardNumber` varchar(255) DEFAULT NULL,
  `CardPower` varchar(255) DEFAULT NULL,
  `Rarity` varchar(255) NOT NULL,
  `Reserved` tinyint(1) DEFAULT NULL,
  `SetID` varchar(255) NOT NULL,
  `Subtypes` varchar(255) DEFAULT NULL,
  `SuperTypes` varchar(255) DEFAULT NULL,
  `Text` varchar(1000) DEFAULT NULL,
  `TimeShifted` tinyint(1) DEFAULT NULL,
  `Toughness` varchar(255) DEFAULT NULL,
  `CardType` varchar(255) NOT NULL,
  `Types` varchar(255) NOT NULL,
  `Variations` varchar(255) DEFAULT NULL,
  `Watermark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CardID`),
  KEY `card_setid_fk` (`SetID`),
  CONSTRAINT `card_setid_fk` FOREIGN KEY (`SetID`) REFERENCES `card_set` (`SetID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE `card_set` (
  `SetID` varchar(255) NOT NULL,
  `Block` varchar(255) DEFAULT NULL,
  `Border` varchar(255) NOT NULL,
  `GathererCode` varchar(255) DEFAULT NULL,
  `MagicCardsInfoCode` varchar(255) DEFAULT NULL,
  `OldCode` varchar(255) DEFAULT NULL,
  `OnlineOnly` tinyint(1) NOT NULL,
  `ReleaseDate` varchar(255) NOT NULL,
  `SetName` varchar(255) NOT NULL,
  `SetType` varchar(255) NOT NULL,
  PRIMARY KEY (`SetID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

CREATE TABLE card_price (
	CardPriceID varchar(255) NOT NULL,
	CardID varchar(255) NOT NULL,
	Price DECIMAL(2,2),
	PRIMARY KEY (CardPriceID),
	KEY card_id_fk (CardID),
	CONSTRAINT card_id_fk FOREIGN KEY (CardID) REFERENCES card (CardID)
)