import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    int customer_stt;
    int customer_id;
    String customer_name;
    int customer_age;
    String customer_dayBooking;
    String customer_dayReturn;



    public Customer() {}

    public Customer(int customer_stt, int customer_id, String customer_name, int customer_age, String customer_dayBooking, String customer_dayReturn) {
        this.customer_stt = customer_stt;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_age = customer_age;
        this.customer_dayBooking = customer_dayBooking;
        this.customer_dayReturn = customer_dayReturn;
    }


    public int getCustomer_stt() {
        return customer_stt;
    }

    public void setCustomer_stt(int customer_stt) {
        this.customer_stt = customer_stt;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_age() {
        return customer_age;
    }

    public void setCustomer_age(int customer_age) {
        this.customer_age = customer_age;
    }

    public String getCustomer_dayBooking() {
        return customer_dayBooking;
    }

    public void setCustomer_dayBooking(String customer_dayBooking) {
        this.customer_dayBooking = customer_dayBooking;
    }

    public String getCustomer_dayReturn() {
        return customer_dayReturn;
    }

    public void setCustomer_dayReturn(String customer_dayReturn) {
        this.customer_dayReturn = customer_dayReturn;
    }

    static void showAllListCustomer(ArrayList<Customer> customerArrayList) {

        System.out.println("6. Xem danh sách khách hàng");
        for (Customer customer : customerArrayList) {
            System.out.println(customer.getCustomer_stt() +
                    " | " + customer.getCustomer_id() +
                    " | " + customer.getCustomer_name() +
                    " | " + customer.getCustomer_age() +
                    " | " + customer.getCustomer_dayBooking() +
                    " | " + customer.getCustomer_dayReturn());
        }
    }

    static void detailCustomer(ArrayList<Customer> customerArrayList, int customer_id) {

        System.out.println("7. Xem chi tiết khách hàng");
        for (Customer customer : customerArrayList) {

            if (customer.getCustomer_id() == customer_id) {
                System.out.println(customer.getCustomer_stt() +
                        " | " + customer.getCustomer_id() +
                        " | " + customer.getCustomer_name() +
                        " | " + customer.getCustomer_age() +
                        " | " + customer.getCustomer_dayBooking()+
                        " | " + customer.getCustomer_dayReturn());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng.");
    }

    public static void addCustomer(ArrayList<Customer> customerArrayList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("8. Thêm khách hàng");

        System.out.print("Nhập số thứ tự Khách hàng: ");
        int customer_stt = sc.nextInt();
        System.out.print("Nhập số id Khách hàng: ");
        int customer_id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập tên khách hàng: ");
        String customer_name = sc.nextLine();

        System.out.print("Nhập tuổi khách hàng: ");
        int customer_age = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập ngày giờ đặt phòng (dd-MM-yyyy): ");
        String dayBooking = sc.nextLine();


        System.out.print("Nhập ngày trả phòng (dd-MM-yyyy): ");
        String customer_dayReturn = sc.nextLine();

        Customer newCustomer = new Customer(customer_stt, customer_id, customer_name, customer_age, dayBooking, customer_dayReturn);
        customerArrayList.add(newCustomer);

        System.out.println("Đã thêm khách hàng mới:");
        System.out.println(newCustomer);
    }

    static void editCustomer(ArrayList<Customer> customerArrayList) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID khách hàng cần chỉnh sửa: ");
        int customer_id = scanner.nextInt();
        scanner.nextLine();

        for (Customer customer : customerArrayList) {
            if (customer.getCustomer_id() == customer_id) {
                System.out.print("Nhập tên khách hàng mới: ");
                String customer_name = scanner.nextLine();
                System.out.print("Nhập tuổi khách hàng mới: ");
                int customer_age = scanner.nextInt();
                scanner.nextLine();
                if (customer_age < 18) {
                    System.out.println("Khách hàng phải trên 18 tuổi.");
                    return;
                }
                System.out.print("Nhập ngày giờ đặt phòng mới (yyyy-mm-dd): ");
                String dayBooking = scanner.nextLine();


                System.out.print("Nhập ngày trả phòng mới (yyyy-mm-dd): ");
                String customer_dayReturn = scanner.nextLine();

                customer.setCustomer_name(customer_name);
                customer.setCustomer_age(customer_age);
                customer.setCustomer_dayBooking(dayBooking);
                customer.setCustomer_dayReturn(customer_dayReturn);
                System.out.println("Đã cập nhật thông tin khách hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng.");
    }

    static void deleteCustomer(ArrayList<Customer> customerArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID khách hàng cần xoá: ");
        int customer_id = sc.nextInt();
        for (Customer customer : customerArrayList) {
            if (customer.getCustomer_id() == customer_id) {
                customerArrayList.remove(customer);
                System.out.println("Đã xoá khách hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng.");
    }
}
