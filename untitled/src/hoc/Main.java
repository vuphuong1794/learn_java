package hoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ReportGroup {
    private int id;
    private String name;
    private int memberCount;

    public ReportGroup(int id, String name, int memberCount) {
        this.id = id;
        this.name = name;
        this.memberCount = memberCount;
    }

    @Override
    public String toString() {
        return "Group ID: " + id + ", Name: " + name + ", Members: " + memberCount;
    }
}

class ReportGroupManager {
    private List<ReportGroup> groups;

    public ReportGroupManager(Scanner sc) {
        groups = new ArrayList<>();
        System.out.println("=== Nhập thông tin các nhóm báo cáo ===");
        // Khởi tạo 19 nhóm báo cáo với id, tên và nhập số lượng thành viên
        for (int i = 1; i <= 19; i++) {
            System.out.println("----------------------------------------");
            System.out.print("Nhập số lượng thành viên cho Nhóm " + i + " (ID: " + i + "): ");
            int members = sc.nextInt();
            groups.add(new ReportGroup(i, "Nhóm " + i, members));
        }
        System.out.println("=== Hoàn thành nhập thông tin nhóm ===");
    }

    public List<ReportGroup> getRandomGroups() {
        // Tạo danh sách ngẫu nhiên từ các nhóm
        Collections.shuffle(groups);
        return groups;
    }

    public void printGroupsByWeek() {
        List<ReportGroup> shuffledGroups = getRandomGroups();
        int totalGroups = shuffledGroups.size();
        int week = 1;
        int groupsPerWeek = 7;
        System.out.println("=== Phân chia các nhóm báo cáo theo tuần ===");

        // Chia các nhóm thành từng tuần
        for (int i = 0; i < totalGroups; i += groupsPerWeek) {
            System.out.println("Tuần " + week + ":");
            for (int j = i; j < i + groupsPerWeek && j < totalGroups; j++) {
                System.out.println("  " + shuffledGroups.get(j));
            }
            week++;
            System.out.println("------------------------------------------");
        }

        System.out.println("=== Hoàn thành phân chia nhóm ===");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReportGroupManager manager = new ReportGroupManager(sc);
        // In ra các nhóm báo cáo theo tuần
        manager.printGroupsByWeek();
        sc.close();
    }
}
