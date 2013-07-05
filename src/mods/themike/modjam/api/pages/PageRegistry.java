package mods.themike.modjam.api.pages;

import java.util.ArrayList;
import java.util.List;

public class PageRegistry {
	
	private static List<IPage> pages = new ArrayList<IPage>();
	
	public static void appendPage(IPage page) {
		pages.add(page);
	}
	
	public static List<IPage> getPages() {
		return pages;
	}

}
