package com.devnexus.workshop.junit5;

public class ParkBuilding {

	public static final ParkBuilding DOME = new ParkBuilding(1992, "Georgia Dome; demolished 2017", false);
	public static final ParkBuilding WORLD_CONGRESS = new ParkBuilding(1976, "Georgia World Congress", true);

	private int age;
	private String name;
	private boolean stillOpen;

	public ParkBuilding(int age, String name, boolean stillOpen) {
		super();
		this.age = age;
		this.name = name;
		this.stillOpen = stillOpen;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public boolean isStillOpen() {
		return stillOpen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (stillOpen ? 1231 : 1237);
		result = prime * result + name.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ParkBuilding other = (ParkBuilding) obj;
		return age == other.age && stillOpen == other.stillOpen && name.equals(other.name);
	}

}
