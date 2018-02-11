package com.devnexus.workshop.junit5;

import java.util.*;

public class GeorgiaAquarium {
	
	private GeorgiaAquarium() {
		super();
	}

	private static final List<String> SHOWS = Arrays.asList("Dolphin", "Sea Lion");
	
	public static int getNumberShows() {
		return SHOWS.size();
	}
	
	public static boolean isShow(String name) {
		return SHOWS.contains(name);
	}
	
}
