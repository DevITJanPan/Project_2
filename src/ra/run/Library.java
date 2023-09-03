package ra.run;

import ra.entity.Book;
import ra.entity.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Library {
    static List<Category> categoryList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Quản lý Thể loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("3. Thoát");
            System.out.print("Sự lựa chọn của bạn:");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Library.catagoryMenu(scanner);
                        break;
                    case 2:
                        Library.bookMenu(scanner);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-3");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Vui lòng chọn số");
            } catch (Exception ex) {
                System.err.println("Có lỗi không xác định, vui lòng liên hệ hệ thống");
            }
        } while (true);
    }

    /**
     * Quản lý thể loại lưu vào file categories.txt
     */
    public static void readDataFromFile() {
        //1. Khởi tạo đối tượng File
        File file = new File("categories.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //2. Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            if (ois.readObject() != null) {
                categoryList = (List<Category>) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tồn tại file.");
        } catch (IOException e) {
            System.err.println("Lỗi trong quá trình thực hiện, vui lòng kiểm tra lại.");
        } catch (ClassNotFoundException e) {
            System.err.println("Lớp không tồn tại.");
        } finally {
            //5. Đóng các stream
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Có lỗi khi đóng stream");
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Có lỗi trong quá trình đóng các stream");
                }
            }
        }
    }

    public static void writeDataToFile() {
        //1. Khởi tạo đối tượng file
        File file = new File("categories.txt");
        FileOutputStream fos = null;
        ObjectOutput oos = null;
        try {
            //2. Khởi tạo đối tượng FileOutputStream từ file - Checked Excetion
            fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //4. Sử dụng writeObject để ghi object ra file
            oos.writeObject(categoryList);
            //5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        } catch (Exception ex) {
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        } finally {
            //6. Đóng các stream
            try {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        System.err.println("Xảy ra lỗi khi đóng các stream");
                    }
                }
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        System.err.println("Xảy ra lỗi khi đóng các stream");
                    }
                }
            } catch (Exception ex) {
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
    }

    /**
     * Quản lý sách lưu vào file books.txt
     */
    public static void readDataFromFileBook() {
        //1. Khởi tạo đối tượng File
        File file = new File("books.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            //2. Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            if (ois.readObject() != null) {
                bookList = (List<Book>) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tồn tại file.");
        } catch (IOException e) {
            System.err.println("Lỗi trong quá trình thực hiện, vui lòng kiểm tra lại.");
        } catch (ClassNotFoundException e) {
            System.err.println("Lớp không tồn tại.");
        } finally {
            //5. Đóng các stream
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Có lỗi khi đóng stream");
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Có lỗi trong quá trình đóng các stream");
                }
            }
        }
    }

    public static void writeDataToFileBook() {
        //1. Khởi tạo đối tượng file
        File file = new File("books.txt");
        FileOutputStream fos = null;
        ObjectOutput oos = null;
        try {
            //2. Khởi tạo đối tượng FileOutputStream từ file - Checked Excetion
            fos = new FileOutputStream(file);
            //3. Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //4. Sử dụng writeObject để ghi object ra file
            oos.writeObject(bookList);
            //5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        } catch (Exception ex) {
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        } finally {
            //6. Đóng các stream
            try {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        System.err.println("Xảy ra lỗi khi đóng các stream");
                    }
                }
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        System.err.println("Xảy ra lỗi khi đóng các stream");
                    }
                }
            } catch (Exception ex) {
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
    }

    public static void catagoryMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("===== QUẢN LÝ THỂ LOẠI =====");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên A – Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn là:");
            try {
                int choiceCategoryMenu = Integer.parseInt(scanner.nextLine());
                switch (choiceCategoryMenu) {
                    case 1:
                        writeDataToFile();
                        Library.inputCategory();
                        break;
                    case 2:
                        Library.sortNamedDisplayCategory();
                        break;
                    case 3:
                        Library.statisticCategory();
                        break;
                    case 4:
                        writeDataToFile();
                        Library.updateCategory(scanner);
                        break;
                    case 5:
                        writeDataToFile();
                        Library.deleteCategory();
                        break;
                    case 6:
                        writeDataToFile();
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-6");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Vui lòng chọn số");
            } catch (Exception ex) {
                System.err.println("Có lỗi không xác định, vui lòng liên hệ hệ thống");
            }
        } while (isExit);
    }

    /**
     * Methor thêm mới thể loại
     */
    public static void inputCategory() {
        Category category = new Category();
        category.input(scanner, categoryList);
        categoryList.add(category);
    }

    /**
     * Methor hiển thị danh sách theo tên A – Z
     */
    public static void sortNamedDisplayCategory() {
        categoryList.sort(Comparator.comparing(Category::getName));
        categoryList.forEach(Category::output);
    }

    /**
     * Methor thống kê thể loại và số sách có trong mỗi thể loại
     */
    public static void statisticCategory() {
        List<Integer> listCountBook = new ArrayList<>();
        //Duyệt từng thể loại sách
        categoryList.stream().forEach(category -> {
            //Tính số sách trên từng thể loại
            int cnt = (int) bookList.stream().filter(book -> category.getId() == book.getId()).count();
            // add số sách theo thể loại vào listCountBook
            listCountBook.add(cnt);
        });
        // Hiển thị thống kê
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.printf("Thể loại sách:%s - Số lượng:%d\n", categoryList.get(i).getName(), listCountBook.get(i));
//            listCountBook.get(i);
        }
    }

    /**
     * Methor cập nhật thể loại
     */
    public static void updateCategory(Scanner scanner) {
        if (categoryList.size() == 0) {
            System.err.println("Không có thể loại");
            return;
        }
        boolean isExit = true;
        System.out.println("Nhập mã thể loại muốn cập nhật: ");
        do {
            int updateCategoryId = Integer.parseInt(scanner.nextLine());
            boolean checkCategoryId = false;
            for (Category category : categoryList) {
                if (category.getId() == updateCategoryId) {
                    category.setName(Category.validateName(scanner, categoryList));
                    System.out.println("Đã cập nhật tên thể loại thành công.");
                    category.setStatus(Category.validateStatus(scanner));
                    System.out.println("Đã cập nhật trạng thái thể loại thành công.");
                    checkCategoryId = true;
                    isExit = false;
                }
            }
            if (!checkCategoryId) {
                System.err.println("Mã thể loại không tồn tại, vui lòng nhập lại.");
            }
        } while (isExit);
    }

    /**
     * Methor xóa thể loại
     */
    public static void deleteCategory() {
        System.out.println("Nhập mã thể loại muốn xóa :");
        int deleteId = Integer.parseInt(scanner.nextLine());
        boolean categoryisExit = false;
        boolean categoryExit = false;
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == deleteId) {
                categoryExit = true;
                if (bookList.size() != 0) {
                    for (Book book : bookList) {
                        if (book.getId() == deleteId) {
                            categoryisExit = true;
                            break;
                        }
                    }
                }
                if (!categoryisExit) {
                    categoryList.remove(i);
                } else {
                    System.err.println("Mã thể loại đã nằm trong danh mục không thể xóa. ");
                }
                break;
            }
        }
        if (!categoryExit) {
            System.err.println("Mã thể loại không tồn tại.");
        }
    }

    public static void bookMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách theo nhóm thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn là:");
            try {
                int choiceBookMenu = Integer.parseInt(scanner.nextLine());
                switch (choiceBookMenu) {
                    case 1:
                        Library.addNewBook();
                        break;
                    case 2:
                        Library.updateBook();
                        break;
                    case 3:
                        Library.deleteBook();
                        break;
                    case 4:
                        Library.searchIdBookName();
                        break;
                    case 5:
                        Library.displayBook();
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-6");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Vui lòng chọn số");
            } catch (Exception ex) {
                System.err.println("Có lỗi không xác định, vui lòng liên hệ hệ thống");
            }
        } while (isExit);
    }

    /**
     * Methor thêm mới sách
     */
    public static void addNewBook() {
        Book book = new Book();
        book.input(scanner, bookList);
        bookList.add(book);
    }

    /**
     * Methor cập nhật thông tin sách
     */
    public static void updateBook() {
        if (bookList.size() == 0) {
            System.err.println("Không có sách nào.");
            return;
        }
        boolean isExit = true;
        System.out.println("Nhập mã sách muốn cập nhật :");
        do {
            String updateBookId = scanner.nextLine();
            boolean checkBookId = false;
            for (Book books : bookList) {
                if (books.getBookId().equals(updateBookId)) {
                    books.setBookId(Book.validateBookId(scanner, bookList));
                    System.out.println("Đã cập nhật mã sách mới thành công.");
                    books.setTitle(Book.validateTitle(scanner, bookList));
                    System.out.println("Đã cập tiêu đề sách mới thành công.");
                    books.setAuthor(Book.validateAuthor(scanner));
                    System.out.println("Đã cập tên tác giả mới thành công.");
                    books.setPublisher(Book.validatePublisher(scanner));
                    System.out.println("Đã cập nhà xuất bản mới thành công.");
                    books.setYear(Book.validateYear(scanner));
                    System.out.println("Đã cập nhật nhà xuất bản mới thành công.");
                    books.setDescription(Book.validateDescription(scanner));
                    System.out.println("Đã cập nhật mô tả sách mới thành công.");
                    books.setId(Category.validateCategoryId(scanner, categoryList));
                    System.out.println("Đã cập nhât mã thể loại sách mới thành công.");
                    checkBookId = true;
                    isExit = false;
                }
            }
            if (!checkBookId) {
                System.err.println("Mã sách không tồn tại, vui lòng nhập lại.");
            }
        } while (isExit);
    }

    /**
     * Methor xóa sách
     */
    public static void deleteBook() {
        if (bookList.size() == 0) {
            System.err.println("Không có sách nào.");
            return;
        }
        boolean isExit = true;
        System.out.println("Nhập mã sách muốn xóa:");
        do {
            String deleteBookId = scanner.nextLine();
            boolean checkBookId = false;
            for (Book bookDelete : bookList) {
                if (bookDelete.getBookId().equals(deleteBookId)) {
                    bookList.remove(bookDelete);
                    System.out.println("Đã xóa sách thành công.");
                    checkBookId = true;
                    isExit = false;
                    break;
                }
            }
            if (!checkBookId) {
                System.err.println("Mã sách không tồn tại, vui lòng nhập lại.");
            }
        } while (isExit);
    }

    /**
     * Methor tìm kiếm sách
     */
    public static void searchIdBookName() {
        String searchName = scanner.nextLine();
        System.out.println("Nhập vào sách cần tìm :");
        bookList.stream().filter(book -> book.getTitle().contains(searchName)
                || book.getAuthor().contains(searchName)
                || book.getPublisher().contains(searchName)).collect(Collectors.toList());
        List<Book> bookList1 = bookList.stream().filter(book -> book.getTitle().contains(searchName)
                || book.getAuthor().contains(searchName)
                || book.getPublisher().contains(searchName)).collect(Collectors.toList());
        bookList1.forEach(Book::output);
    }

    /**
     * Methor hiển thị danh sách sách theo nhóm thể loại
     */
    public static void displayBook() {
        // Duyệt các thể loại
        categoryList.stream().forEach(category -> {
            bookList.stream().filter(book -> book.getCategoryId() == category.getId()).forEach(book -> book.output());

        });

    }
}
