package org.legendtitans.apcompscience.mma;

import java.awt.image.BufferedImage;

public class Fighter {
	private String name;
	private BufferedImage picture;
	private String description;
	private int currentHitPoints;
	private int maxHitPoints;
	private int minDamage;
	private int maxDamage;	
	public Fighter(String name, String description,
			int currentHitPoints, int maxHitPoints, 
			int minDamage, int maxDamage, BufferedImage picture) {
		this.name = name;
		this.description = description;
		this.currentHitPoints = currentHitPoints;
		this.maxHitPoints = maxHitPoints;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.picture = picture;
	}
	public Fighter(String name, String description, BufferedImage picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.currentHitPoints = 100;
		this.maxHitPoints = 100;
		this.minDamage = 5;
		this.maxDamage = 10;
	}
	public boolean isAlive() {
		if (currentHitPoints >= 0) {
			return true;
		} 
		return false;
	}
	public BufferedImage getPicture() {
		return picture;
	}
	public String getDescription() {
		return description;
	}
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}
	public void setCurrentHitPoints(int chp) {
		currentHitPoints = currentHitPoints - chp;
	}
	public int attack() {
		int attackStrength = (int)(Math.random() * (maxDamage - minDamage) + minDamage);
		return attackStrength;
	}
	public void defend() {
		int total = (maxHitPoints / 100) * 10;
		currentHitPoints = currentHitPoints + total;
		if (currentHitPoints > maxHitPoints) {
			currentHitPoints = maxHitPoints;
		}
	}
	public int special() {
		return attack() * 2;
	}
}
