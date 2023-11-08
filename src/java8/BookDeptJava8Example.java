package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDeptJava8Example {

    public static void main(String[] args) {

        List<Dept> deptList = new ArrayList<>();
        deptList.add(new Dept(1, "Horror"));
        deptList.add(new Dept(2, "Comedy"));
        deptList.add(new Dept(3, "Romance"));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "IT", "AA-01", 1));
        bookList.add(new Book(2, "Scary movie", "AA-02", 1));
        bookList.add(new Book(3, "Poltergeist", "AA-01", 1));
        bookList.add(new Book(4, "Hungama", "AB-01", 2));
        bookList.add(new Book(5, "Chup Chup ke", "AB-03", 2));
        bookList.add(new Book(6, "Kuch kuch hota hai", "AC-01", 3));
        bookList.add(new Book(7, "k3g", "AC-01", 3));

        List<BookDeptDTO> bookDeptDTOList = bookList.stream()
                .filter(b -> b.getDeptId() == 1)
                .map(book -> {
                    BookDeptDTO bookDeptDTO = new BookDeptDTO();
                    bookDeptDTO.setBookName(book.getBookName());
                    bookDeptDTO.setShelfName(book.getShelfName());
                    bookDeptDTO.setDeptName(deptList.stream()
                            .filter(d -> d.getDeptId() == book.getDeptId())
                            .findFirst()
                            .map(Dept::getDeptName)
                            .orElse(null));

                    return bookDeptDTO;
                }).collect(Collectors.toList());

        bookDeptDTOList.forEach(System.out::println);

    }

}

class BookDeptDTO {

    private String bookName;
    private String deptName;
    private String shelfName;

    public BookDeptDTO() {
    }

    public BookDeptDTO(String bookName, String deptName, String shelfName) {
        this.bookName = bookName;
        this.deptName = deptName;
        this.shelfName = shelfName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    @Override
    public String toString() {
        return "BookDeptDTO{" +
                "bookName='" + bookName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", shelfName='" + shelfName + '\'' +
                '}';
    }
}

class Book {

    private int bookId;
    private String bookName;
    private String shelfName;
    private int deptId;

    public Book() {
    }

    public Book(int bookId, String bookName, String shelfName, int deptId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.shelfName = shelfName;
        this.deptId = deptId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", shelfName='" + shelfName + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}

class Dept {
    private int deptId;
    private String deptName;

    public Dept() {
    }

    public Dept(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
