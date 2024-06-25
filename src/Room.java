import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    int room_stt;
    int room_id;
    String room_name;
    int room_number;
    boolean room_status;

    Customer customer;

    public Room() {
    }

    public Room(int room_stt, int room_id, String room_name, int room_number, boolean room_status) {
        this.room_stt = room_stt;
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_number = room_number;
        this.room_status = room_status;
    }

    int getRoom_stt() {
        return room_stt;
    }

    void setRoom_stt(int room_stt) {
        this.room_stt = room_stt;
    }

    int getRoom_id() {
        return room_id;
    }

    void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    String getRoom_name() {
        return room_name;
    }

    void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getRoom_number() {
        return room_number;
    }

    void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    String isRoom_status() {
        if (room_status) {
            return "Con Phong";
        } else {
            return "Het Phong";
        }
    }


    void setRoom_status(boolean room_status) {
        this.room_status = room_status;
    }

    static void showAllListRoom(ArrayList<Room> roomArrayList) {
        System.out.println("1.Xem danh sách phòng");

        for (Room room : roomArrayList) {
            System.out.println(room.getRoom_stt() +
                    "|" + room.getRoom_id() +
                    "|" + room.getRoom_name() +
                    "|" + room.getRoom_number() +
                    "|" + room.isRoom_status());
        }
    }

    static void detailRoom(ArrayList<Room> roomArrayList, int room_id) {
        System.out.println("2.Xem chi tiết phòng");

        for (Room room : roomArrayList) {
            if (room.getRoom_id() == room_id) {
                System.out.println(room.getRoom_stt() +
                        "|" + room.getRoom_id() +
                        "|" + room.getRoom_name() +
                        "|" + room.getRoom_number() +
                        "|" + room.isRoom_status());
                if (room.room_status && room.customer != null) {
                    System.out.println("Khach dang dat: " + room.customer.getCustomer_id());
                    System.out.println("Khach dang dat: " + room.customer.getCustomer_name());
                }
            }
        }
    }

    public static void addRoom(ArrayList<Room> roomArrayList) {
        if (roomArrayList.size() <= 5) {
            Scanner sc = new Scanner(System.in);
            System.out.println("3. Thêm phòng");

            System.out.print("Nhập số thứ tự Phòng: ");
            int room_stt = sc.nextInt();
            System.out.print("Nhập số id Phòng: ");
            int room_id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhập tên phòng: ");
            String room_name = sc.nextLine();

            System.out.print("Nhập số phòng: ");
            int room_number = sc.nextInt();
            sc.nextLine();

            System.out.print("Trạng thái phòng (true: còn phòng / false: hết phòng): ");
            boolean room_status = sc.nextBoolean();

            Room newRoom = new Room(room_stt, room_id, room_name, room_number, room_status);
            roomArrayList.add(newRoom);

            System.out.println("Đã thêm phòng mới:");
            System.out.println(newRoom);
        } else {
            System.out.println("Toi da chi co 5 phong");
        }
    }

    static void editRoom(ArrayList<Room> roomArrayList) {
        System.out.println("Nhap id Phong can chinh sua: ");
        Scanner scanner = new Scanner(System.in);
        int room_id = scanner.nextInt();

        for (Room rooms : roomArrayList) {
            if (rooms.getRoom_id() == room_id) {
                System.out.print("Nhập tên phòng mới: ");
                String room_name = scanner.next();
                System.out.print("Nhập số phòng mới: ");
                int room_number = scanner.nextInt();
                rooms.setRoom_name(room_name);
                rooms.setRoom_number(room_number);
                return;
            }
        }
        System.out.println("Không tìm thấy phòng.");
    }

    static void deleteRoom(ArrayList<Room> roomArrayList) {
        Scanner scanner = new Scanner(System.in);
        int room_id = scanner.nextInt();
        for (Room room : roomArrayList) {
            if (room.getRoom_id() == room_id) {
                roomArrayList.remove(room);
                System.out.println("Da xoa Phong");
                return;
            }
        }
        System.out.println("Không tìm thấy Phong.");
    }

    static void bookRoom(ArrayList<Room> roomArrayList, ArrayList<Customer> customerArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id phòng cần đặt: ");
        int room_id = sc.nextInt();

        Room roomBook = null; // Bien tam de luu phong tim dc
        //Tim phong
        for (Room rooms : roomArrayList) {
            if (rooms.getRoom_id() == room_id) {
                roomBook = rooms;
                break;
            }
        }

        if (roomBook == null) {
            System.out.println("Khong tim thay phong");
        }

        if (!roomBook.room_status) {
            System.out.println("Phong da duoc dat");
        }

        //Tim khach hang
        System.out.println("Nhap id Khach hang");
        int customer_id = sc.nextInt();
        Customer customerBooking = null;
        for (Customer customers : customerArrayList) {
            if (customers.getCustomer_id() == customer_id) {
                customerBooking = customers;
                break;
            }
        }

        if (customerBooking == null) {
            System.out.println("Không tìm thấy khách hàng.");
        }

        roomBook.setRoom_status(false);
        roomBook.customer = customerBooking;

        System.out.println("Dat phong thanh cong");
        detailRoom(roomArrayList, room_id);
        
    }
}
