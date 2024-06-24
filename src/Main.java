import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Room> roomArrayList = new ArrayList<>();
        roomArrayList.add(new Room(1, 1, "Phong1", 2, false));
        roomArrayList.add(new Room(2, 2, "Phong2", 4, true));
        roomArrayList.add(new Room(3, 3, "Phong3", 1, true));
        roomArrayList.add(new Room(4, 4, "Phong4", 3, false));

        ArrayList<Customer> customerArrayList = new ArrayList<>();
        customerArrayList.add(new Customer(1, 1, "KhachHang1", 18,"24-06-2024", "24-06-2024"));
        customerArrayList.add(new Customer(2, 2, "KhachHang2", 20, "25-06-2024", "25-06-2024"));
        customerArrayList.add(new Customer(3, 3, "KhachHang3", 22, "26-06-2024", "26-06-2024"));
        customerArrayList.add(new Customer(4, 4, "KhachHang4", 25, "27-06-2024", "27-06-2024"));

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("----------Hotel Booking--------");
            System.out.println("-------------------------------");
            System.out.println("-----------Phòng---------------");
            System.out.println("1. Xem danh sách phòng");
            System.out.println("2. Xem chi tiết phòng");
            System.out.println("3. Thêm phòng: Tên phòng, số phòng");
            System.out.println("4. Sửa phòng: Tên phòng, số phòng");
            System.out.println("5. Xóa phòng");
            System.out.println("-----------Khách hàng----------");
            System.out.println("6. Xem danh sách khách hàng");
            System.out.println("7. Xem chi tiết khách hàng");
            System.out.println("8. Thêm khách hàng: Tên khách hàng, tuổi, ngày trả phòng");
            System.out.println("9. Sửa khách hàng: Tên khách hàng, tuổi, ngày trả phòng");
            System.out.println("10. Xóa khách hàng");
            System.out.println("11. Dat phong");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng: ");
            int condition = sc.nextInt();
            switch (condition) {
                case 1:
                    Room.showAllListRoom(roomArrayList);
                    break;
                case 2:
                    System.out.print("Nhập số id Phòng: ");
                    int id = sc.nextInt();
                    Room.detailRoom(roomArrayList, id);
                    break;
                case 3:
                    Room.addRoom(roomArrayList);
                    break;
                case 4:
                    Room.editRoom(roomArrayList);
                    break;
                case 5:
                    Room.deleteRoom(roomArrayList);
                    break;
                case 6:
                    Customer.showAllListCustomer(customerArrayList);
                    break;
                case 7:
                    System.out.print("Nhập số id khách hàng: ");
                    int idCustomer = sc.nextInt();
                    Customer.detailCustomer(customerArrayList, idCustomer);
                    break;
                case 8:
                    Customer.addCustomer(customerArrayList);
                    break;
                case 9:
                    Customer.editCustomer(customerArrayList);
                    break;
                case 10:
                    Customer.deleteCustomer(customerArrayList);
                    break;
                case 11:
                    Room.bookRoom(roomArrayList, customerArrayList);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn chức năng hợp lệ");
                    break;
            }
        }
    }
}
