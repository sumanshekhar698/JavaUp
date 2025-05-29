package dev.codecounty.java.java8.advance.records;

import java.time.Year;
import java.util.Objects;

public record Book(String id, String title, Year release, Integer edition) {

    public Book {
        Objects.requireNonNull(id, "id is required");
        Objects.requireNonNull(title, "title is required");
        Objects.requireNonNull(release, "release is required");
        if (edition < 1) {
            throw new IllegalArgumentException("Edition cannot be negative");
        }
    }

//    public Book() {
//
//    }

//    public static Book builder() {
//        return new Book();
//    }


//    public static Book builder() {
//        return new Book();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {
        private String id;
        private String title;
        private Year release;
        private Integer edition = 1; // Default edition to 1

        public BookBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder release(Year release) {
            this.release = release;
            return this;
        }

        public BookBuilder edition(Integer edition) {
            if (edition < 1) {
                throw new IllegalArgumentException("Edition cannot be negative");
            }
            this.edition = edition;
            return this;
        }

        public Book build() {
            Objects.requireNonNull(id, "id is required");
            Objects.requireNonNull(title, "title is required");
            Objects.requireNonNull(release, "release is required");
            return new Book(id, title, release, edition);
        }
    }



}
