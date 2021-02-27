package se.boalbert.moviesapi.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MovieEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String title;
	private LocalDate releaseDate;
	private int runTimeMins;
	private double imdbRating;

	private long genreId;
	private long directorId;
	private long languageId;
	//private List<Directors> - köra en list så man kan hantera flera regissörer?

	public MovieEntity() {
	}

	public MovieEntity(long id, String title, LocalDate releaseDate, int runTimeMins, double imdbRating, long genreId, long directorId, long languageId) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.runTimeMins = runTimeMins;
		this.imdbRating = imdbRating;
		this.genreId = genreId;
		this.directorId = directorId;
		this.languageId = languageId;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(long directorId) {
		this.directorId = directorId;
	}

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "MovieEntity{" +
				"id=" + id +
				", title='" + title + '\'' +
				", releaseDate=" + releaseDate +
				", runTimeMins=" + runTimeMins +
				", imdbRating=" + imdbRating +
				", genreId=" + genreId +
				", directorId=" + directorId +
				", languageId=" + languageId +
				'}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRunTimeMins() {
		return runTimeMins;
	}

	public void setRunTimeMins(int runTimeMins) {
		this.runTimeMins = runTimeMins;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
}
