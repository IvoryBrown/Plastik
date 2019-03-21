package com.main.extruder;

import java.util.Random;

public class CommentRandom {
	private static String[] Beginning = { "Cristiano Ronaldo 20 ezer eurós büntetést kapott az erekciós gólöröm miatt",
			"Fogalmam sincs mi értelme, de csak öt giga, szinte bárhol velünk lehet. 2007 októberétől 2015 májusáig vannak a hozzászólások.",
			"Végre le lehet tölteni a Reddit kommentjeit", "Még szerencse, hogy már nem lehet kommentelni!!!",
			"Nem mindenki ért egyet a 444 fantasztikus kommentreformjával :((",
			"12 hónap felfüggesztettre ítélték az internetes trollt, aki nemi erőszakkal fenyegetett egy lányt egy facebookos vitában.",
			"A kormányközeli propagandasajtó egy kicsit beleroppant ebbe a Trump-mámorba",
			"És a Washington Post volt szíriai tudósítóját igazolta le, hogy fotózza az életét. Részletek a Facebook-vezér mindennapjaiból.",
			"Magánhadsereget tart fenn Zuckerberg, hogy a profilján moderálják a kommenteket",
			"korábban, és a felháborodott kommentekre azzal",
			"A System of a Down gitárosa hálás szívvel emlékezett Charles Mansonra",
			"Híres magyar nők Instagram-fotói alatti kommentekkel mutatjuk be a tipikus hibákat, amiket kis gyakorlással könnyen el lehet kerülni. Uraim, több méltóságot!",
			"" };

	private static Random rand = new Random();

	public static String generateComment() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
