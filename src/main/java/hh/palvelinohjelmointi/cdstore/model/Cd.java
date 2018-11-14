package hh.palvelinohjelmointi.cdstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Cd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String artist;
	private int year;
	private double price;


	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Cd() {
	}

	public Cd(String title, String artist, int year, Long id, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Cd [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + "," + ", price=" + price + " category =" + this.getCategory() + "]";

		else
			return "Cd [id=" + id + ", title=" + title + ", artist=" + artist + ", year=" + year + "," +" price=" + price + "]";
	}
}