package mods.themike.modjam.pages

import mods.themike.modjam.api.pages.IPage

class TitlePage implements IPage {

	@Override
	public String[] getContents() {
		return ["", "\247oA mysterious scroll...", "Seems to be full of information.", "", "", "\247l By a local hermit."];
	}

	@Override
	public String getHeader() {
		return "Papyrus Scroll";
	}

}
