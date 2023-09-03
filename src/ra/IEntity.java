package ra;

import ra.entity.Category;

import java.util.List;
import java.util.Scanner;

public interface IEntity<T> {
    void input(Scanner scanner, List<T>list);
    void output(List<Category>categoryList);

}
