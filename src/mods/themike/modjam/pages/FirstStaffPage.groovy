package mods.themike.modjam.pages

import mods.themike.modjam.api.pages.IPage

class FirstStaffPage implements IPage {

	@Override
	public String[] getContents() {
		return [
			"To start into being an apprentice",
			"you'll need a staff. Start by",
			"collecting Spatial Dust from mob",
			"drops, then craft Crystalline",
			"Essence.",
		];
	}

	@Override
	public String getHeader() {
		return "Your first Staff";
	}

}
