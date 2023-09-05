package ra.entity;

import ra.IEntity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static ra.run.Library.categoryList;

public class Book implements IEntity, Serializable {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String description;
    private int categoryId;// Xác định sách thuộc danh mục nào
    // Các construstor không tham số

    public Book() {
    }
    // Các construstor có tham số


    public Book(String bookId, String title, String author, String publisher, int year, String description, int categoryId) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
        this.categoryId = categoryId;
    }
    // // Các phương thức get/set


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return categoryId;
    }

    public void setId(int id) {
        this.categoryId = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Nhập thông tin sách
     */
    @Override
    public void input(Scanner scanner, List<Category> categoryList, List<Book> bookList) {
        this.bookId = validateBookId(scanner, bookList);
        this.title = validateTitle(scanner, bookList);
        this.author = validateAuthor(scanner);
        this.publisher = validatePublisher(scanner);
        this.year = validateYear(scanner);
        this.description = validateDescription(scanner);
        this.categoryId = validateCategoryId(scanner, categoryList);

    }

    public static int validateCategoryId(Scanner scanner, List<Category> categoryList) {
        System.out.println("Nhập vào categoryId :");
        do {
            List<Integer> listCategoryId = categoryList.stream().map(category -> category.getId()).collect(Collectors.toList());

            int categoryId = Integer.parseInt(scanner.nextLine());
            if (listCategoryId.contains(categoryId)) {
                return categoryId;
            } else {
                System.err.println("Mã không tồn tại , vui lòng nhập lại.");
            }
        } while (true);

    }

    public static boolean validateNull(String str) {
        if (str.trim().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String validateBookId(Scanner scanner, List<Book> list) {
        System.out.println("Nhập vào mã sách:");
        do {
            String bookId = scanner.nextLine();
            if (validateNull(bookId)) {
                if (bookId.length() == 4) {
                    if (bookId.startsWith("B")) {
                        boolean isExit = false;
                        for (Book book : list) {
                            if (book.getBookId().equals(bookId)) {
                                isExit = true;
                                break;
                            }
                        }
                        if (!isExit) {
                            return bookId;
                        } else {
                            System.err.println("Mã sách đã tồn tại, vui lòng nhập lại.");
                        }
                    } else {
                        System.err.println("Mã sách bắt đầu bằng ký tự B, vui lòng nhập lại.");
                    }
                } else {
                    System.err.println("Mã sách phải gồm 4 ký tự, vui lòng nhập lại.");
                }

            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (true);
    }

    public static String validateTitle(Scanner scanner, List<Book> list) {
        System.out.println("Nhập vào tiêu đề sách :");
        do {
            String title = scanner.nextLine();
            if (validateNull(title)) {
                if (title.length() >= 6 && title.length() <= 50) {
                    boolean isExit = false;
                    for (Book book : list) {
                        if (book.getTitle().equals(title)) {
                            isExit = true;
                            break;
                        }
                    }
                    if (!isExit) {
                        return title;
                    } else {
                        System.err.println("Tiêu đề sách đã tồn tại, vui lòng nhập lại.");
                    }
                } else {
                    System.err.println("Tiêu đề sách phải từ 6-50 ký tự, vui lòng nhập lại.");
                }
            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (true);
    }

    public static String validateAuthor(Scanner scanner) {
        System.out.println("Nhập vào tên tác giả:");
        do {
            String author = scanner.nextLine();
            if (validateNull(author)) {
                return author;
            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (true);
    }

    public static String validatePublisher(Scanner scanner) {
        System.out.println("Nhà xuất bản :");
        do {
            String publisher = scanner.nextLine();
            if (validateNull(publisher)) {
                return publisher;
            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (true);

    }

    public static int validateYear(Scanner scanner) {
        System.out.println("Nhập vào năm xuất bản :");
        do {
            String yearBook = scanner.nextLine();
            if (validateNull(yearBook)) {
                try {
                    int year = Integer.parseInt(yearBook);
                    Date now = new Date();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(now);
                    int yearNow = calendar.get(Calendar.YEAR);
                    if (year > 1970 && year <= yearNow) {
                        return year;
                    } else {
                        System.err.println("Năm xuất bản (tối thiểu từ năm 1970 và không lớn hơn năm hiện tại");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi định dạng năm.");
                } catch (Exception ex) {
                    System.err.println("Lỗi xảy ra trong quá trình nhập năm.");
                }
            } else {
                System.err.println("Vui lòng không để trống.");
            }

        } while (true);
    }

    public static String validateDescription(Scanner scanner) {
        System.out.println("Mô tả sách :");
        do {
            String description = scanner.nextLine();
            if (validateNull(description)) {
                return description;
            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (true);
    }

    /**
     * Hiển thị thông tin sách
     */
    @Override
    public void output(List<Category> categoryList) {
        String categoryName = null;
        for (Category category : categoryList) {
            if (category.getId() == this.categoryId) {
                categoryName = category.getName();
            }
        }
        System.out.printf("| %-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %n",
                this.bookId, this.title, this.author, this.publisher, this.year, this.description, categoryName);
    }
}
