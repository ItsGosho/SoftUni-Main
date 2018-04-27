package T03_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private Integer year;
    private List<String> authors;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(String... authors) {
        this.authors=new ArrayList<>();
        this.authors.addAll(Arrays.asList(authors));
    }

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    @Override
    public int compareTo(Book o) {
        if(this.title.compareTo(o.getTitle())==0){
            return this.year.compareTo(o.getYear());
        }
        return o.getTitle().compareTo(this.title);
    }
}
