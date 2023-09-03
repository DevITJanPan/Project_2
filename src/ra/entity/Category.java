package ra.entity;

import ra.IEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Category implements IEntity, Serializable {
    private int id;
    private String name;
    private boolean status;
    // Các construstor không tham số
    public Category() {
    }
    // Các construstor có tham số
    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    // Các phương thức get/set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Nhập thông tin thể loại
     * @param scanner
     * @param list
     */

    @Override
    public void input(Scanner scanner, List list) {
        this.id=validateCategoryId(scanner,list);
        this.name=validateName(scanner,list);
        this.status=validateStatus(scanner);
    }
    public static boolean validateNull(String str){
        if (str!=null||str.trim().length()>0){
            return true;
        }else {
            return false;
        }
    }
    public static int validateCategoryId(Scanner scanner, List<Category> list) {
        boolean isExit = false;
        do {
            System.out.println("Nhập mã thể loại sách: ");
            String categoryIdStr = scanner.nextLine();
            if (validateNull(categoryIdStr)) {
                try {
                    int categoryId = Integer.parseInt(categoryIdStr);
                    boolean isCategoryId = list.stream().anyMatch(category -> category.getId() == categoryId);
                    if (isCategoryId) {
                        System.err.println("Mã đã tồn tại,vui lòng nhập lại.");
                    } else {
                        isExit = true;
                        return categoryId;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.err.println("Dữ liệu nhập vào là số, vui lòng nhập lại..");
                } catch (NullPointerException nullPointerException) {
                    System.err.println("Lỗi mảng Category null");
                } catch (Exception e) {
                    System.err.println("Lỗi xảy ra trong quá trình thực hiện, vui lòng liên hệ hệ thống.");
                }
            } else {
                System.err.println("Vui lòng không để trống.");
            }
        } while (!isExit);
        return -1;
    }
    public static String validateName(Scanner scanner, List<Category>list){
        System.out.println("Nhập vào tên thể loại:");
        do {
            String categoryName= scanner.nextLine();
            if(validateNull(categoryName)){
                boolean isExit=false;
                for (Category category:list) {
                    if(category.getName().equals(categoryName)){
                        isExit=true;
                        break;
                    }
                }
                if(isExit){
                    System.err.println("Tên thể loại đã tồn tại, vui lòng nhập lại.");
                }else{
                    if(categoryName.length()>=6 && categoryName.length()<=30){
                        return categoryName;
                    }else{
                        System.err.println("Tên thể loại có độ dài từ 6-30 ký tự, vui lòng nhập lại.");
                    }
                }
            }else{
                System.err.println("Vui lòng không để trống.");
            }
        }while (true);
    }
    public static boolean validateStatus(Scanner scanner){
        System.out.println("Nhập vào trạng thái thể loại :");
        do {
            String status=scanner.nextLine();
            if(validateNull(status)){
                if(status.equalsIgnoreCase("true")||status.equalsIgnoreCase("false")){
                    return Boolean.parseBoolean(status);
                }else{
                    System.err.println("Trạng thái thể loại chỉ nhận giá trị true | false, vui lòng nhập lại");
                }
            }else{
                System.err.println("Vui lòng không để trống.");
            }

        }while (true);
    }

    /**
     *
     */
    @Override
    public void output() {
        String statusCategory=this.status?"Hoạt động": "Không hoạt động";
        System.out.printf("CategoryId:%d - CategoryName:%s - status:%s\n",this.id,this.name,statusCategory);
//        String leftAlignFormat = "| %-4d | %-15s | %-15s |%n";
//
//        System.out.format("+------+-----------------+-----------------+%n");
//        System.out.format("| CategoryId     | CategoryName   | status     |%n");
//        System.out.format("+------+-----------------+-----------------+%n");
//        for (int i = 0; i < 100; i++) {
//            System.out.format(leftAlignFormat, "Category" + i, i * i);
//        }
//        System.out.format("+------+-----------------+-----------------+%n");
    }
}
