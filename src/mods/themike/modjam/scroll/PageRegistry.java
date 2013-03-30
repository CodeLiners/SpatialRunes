package mods.themike.modjam.scroll;

import com.google.common.collect.ObjectArrays;

public class PageRegistry {
	
	private static IPage[] pages = new IPage[100];
	
	public static void appendPage(IPage page) {
		pages = ObjectArrays.concat(page, pages);
	}
	
	public static IPage[] getPages() {
		return pages;
	}

}
