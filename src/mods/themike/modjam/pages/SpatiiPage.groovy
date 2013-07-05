package mods.themike.modjam.pages

import mods.themike.modjam.api.pages.IPage

class SpatiiPage implements IPage {

	@Override
	public String[] getContents() {
		return [
			"Spatii is an energy field given",
			"off by all living things, and a",
			"Mage is a master of manpulating",
			"Spatii.",
			"You must first become an ",
			"apprentice, and learn the ways",
			"of Spatii."
		];
	}

	@Override
	public String getHeader() {
		return "About Spatii";
	}

}
