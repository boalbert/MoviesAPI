package se.iths.movieratingwebservice.dtos;

public class MovieWithInfoDto {

    private MovieDto movieDto;
    private DirectorDto directorDto;
    private String genre;
    private String language;


    public MovieWithInfoDto() {
    }

    @Override
    public String toString() {
        return "MovieWithInfoDto{" +
                "movieDto=" + movieDto +
                ", directorDto=" + directorDto +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public MovieDto getMovieDto() {
        return movieDto;
    }

    public void setMovieDto(MovieDto movieDto) {
        this.movieDto = movieDto;
    }

    public DirectorDto getDirectorDto() {
        return directorDto;
    }

    public void setDirectorDto(DirectorDto directorDto) {
        this.directorDto = directorDto;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MovieWithInfoDto(MovieDto movieDto, DirectorDto directorDto, String genre, String language) {
        this.movieDto = movieDto;
        this.directorDto = directorDto;
        this.genre = genre;
        this.language = language;
    }
}
