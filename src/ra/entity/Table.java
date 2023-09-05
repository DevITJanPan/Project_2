package ra.entity;

public class Table {
    /**
     * Hiển thị bảng trong lớp Category
     */
    public static String tableCategory() {
        return String.format("| %-15s | %-25s | %-25s |"
                , "CategoryId", "CategoryName", "status");
    }

    /**
     * Hiển thị table trong displayCategory
     */
    public static String borderCategory() {
        String border = "-";
        String repeated = new String(new char[71]).replace("\0", border);
        return String.format("+ " + repeated + " +");
    }
    /**
     * Hiển thị table trong thống kê thể loại và số sách có trong mỗi thể loại
     */
    public static String tableStatisticCategory() {
        String border = "-";
        String repeated = new String(new char[84]).replace("\0", border);
        return String.format("+ " + repeated + " +");
    }

    /**
     * Hiển thị table trong displayBook
     */
    public static String border() {
        String border = "-";
        String repeated = new String(new char[130]).replace("\0", border);
        return String.format("+ " + repeated + " +");
    }
}
