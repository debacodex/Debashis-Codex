package com.github.debacodex.model;

public class MyItem {
	private String title;
	private String imageUrl;
	private String description; // Full detailed description
	private String shortDescription; // New field for a summarized description

	public MyItem(String title, String imageUrl, String description, String shortDescription) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.description = description;
		this.shortDescription = shortDescription; // Initialize the new field
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public String getShortDescription() {
		return shortDescription; // Getter for the short description
	}
}