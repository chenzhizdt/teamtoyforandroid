package org.instorm.teamtoyforandroid;

public class SlidingMenu {
	private String name;
	private int tag;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public SlidingMenu(String name, int tag) {
		this.name = name;
		this.tag = tag;
	}
}
