package ra;

import ra.entity.Book;
import ra.entity.Category;

import java.util.List;
import java.util.Scanner;

public interface IEntity {
    void input(Scanner scanner, List<Category>categoryList, List<Book>bookList);
    void output(List<Category>categoryList);

}
