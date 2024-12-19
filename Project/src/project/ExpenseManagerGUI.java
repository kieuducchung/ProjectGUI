package project;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ExpenseManagerGUI {

    private ExpenseManager expenseManager;

    //Constructor
    public ExpenseManagerGUI() {
        expenseManager = new ExpenseManager();
        //Khởi tạo đối tượng ExpenseManager
        createAndShowGUI();
        //Gọi phương thức để tạo và hiển thị giao diện người dùng
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Expense Manager");  //Tạo cửa sổ với tiêu đề Expense Manager
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Dùng để đảm bảo khi đóng của sổ chương trình sẽ dừng hoàn toàn
        frame.setSize(600, 500); //Đặt kích thước cửa sổ, chiều rộng 600 pixel, chiều dài 500 pixel

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Create buttons
        JButton addExpense = new JButton("Add Expense");
        JButton addIncome = new JButton("Add Income");
        JButton viewAllExpenses = new JButton("View All Expenses");
        JButton viewAllIncomes = new JButton("View All Incomes");
        JButton totalExpense = new JButton("Total Expense");
        JButton totalIncome = new JButton("Total Income");

        addExpense.setBackground(Color.GREEN); // Đổi màu nền của nút thành xanh lá cây
        addExpense.setForeground(Color.BLACK); // Chữ trên nút màu đen

        addIncome.setBackground(Color.GREEN); // Đổi màu nền xanh lá cây
        addIncome.setForeground(Color.BLACK); // Chữ màu đen

        viewAllExpenses.setBackground(Color.ORANGE); //Đổi màu nền của nút thành màu cam
        viewAllExpenses.setForeground(Color.BLACK); // Chữ màu đen

        viewAllIncomes.setBackground(Color.ORANGE);
        viewAllIncomes.setForeground(Color.BLACK);

        totalExpense.setBackground(Color.RED);
        totalExpense.setForeground(Color.BLACK);

        totalIncome.setBackground(Color.RED);
        totalIncome.setForeground(Color.BLACK);

        //Thêm từng nút vào trong panel
        panel.add(addExpense);
        panel.add(addIncome);
        panel.add(viewAllExpenses);
        panel.add(viewAllIncomes);
        panel.add(totalExpense);
        panel.add(totalIncome);

        frame.getContentPane().add(panel); //Gắn panel chứa các button hiển trị trên cửa số farme.  
        frame.setVisible(true); //Hiển thị cửa sổ

        // Xử lý khi nhấn nút ADD Expense
        addExpense.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Hiển thị hộp nhập thông tin chi tiêu
                String name = JOptionPane.showInputDialog("Enter Expense Name:");
                String category = JOptionPane.showInputDialog("Enter Expense Category:");
                String amountStr = JOptionPane.showInputDialog("Enter Expense Amount:");
                String date = JOptionPane.showInputDialog("Enter Expense Date (yyyy-mm-dd):");

                try {
                    double amount = Double.parseDouble(amountStr);
                    //Chuyển đổi thành số thực
                    expenseManager.addExpense(new Expense(name, category, amount, date));
                    //Thêm khoản chi tiêu vào danh sách.
                    JOptionPane.showMessageDialog(frame, "Expense added successfully.");
                    //Neu nhập dúng định dạng nó sẽ thông báo thành công
                } catch (NumberFormatException ex) {
                    // Nếu nhập sai định dạng số.
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Xử lý khi nhấn nút ADD Income
        addIncome.addActionListener(new ActionListener() {
            //Hiển thị hộp nhập thông tin thu nhập
            public void actionPerformed(ActionEvent e) {
                String source = JOptionPane.showInputDialog("Enter Income Source:");
                String amountStr = JOptionPane.showInputDialog("Enter Income Amount:");
                String date = JOptionPane.showInputDialog("Enter Income Date (yyyy-mm-dd):");

                try {
                    double amount = Double.parseDouble(amountStr);
                    //Chuyển đổi thành số thực
                    expenseManager.addIncome(new Income(source, amount, date));
                    // Thêm khoản thu nhập vào danh sách.
                    JOptionPane.showMessageDialog(frame, "Income added successfully.");
                    //Neu nhập dúng định dạng nó sẽ thông báo thành công
                } catch (NumberFormatException ex) {
                    // Nếu nhập sai định dạng số
                    JOptionPane.showMessageDialog(frame, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Xử lý khi nhấn nút view All Expenses
        viewAllExpenses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Expense> expenses = expenseManager.getAllExpenses();
                // Lấy danh sách các khoản chi tiêu
                StringBuilder message = new StringBuilder("All Expenses:\n");
                // Dùng StringBuilder để xây dựng chuỗi hiển thị
                for (Expense expense : expenses) {
                    message.append(expense.getName()).append(" - ").append(expense.getCategory()).append(" - ")
                            .append(expense.getAmount()).append(" - ").append(expense.getDate()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, message.toString());
                // Hiển thị danh sách các khoản chi tiêu.
            }
        });

        //Xử lý khi nhấn nút view All Incomes
        viewAllIncomes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Income> incomes = expenseManager.getAllIncomes();
                // Lấy danh sách các khoản thu nhập.
                StringBuilder message = new StringBuilder("All Incomes:\n");
                // Dùng StringBuilder để xây dựng chuỗi hiển thị
                for (Income income : incomes) {
                    message.append(income.getSource()).append(" - ").append(income.getAmount()).append(" - ").append(income.getDate()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, message.toString());
                //Hiển thị danh sách các khoản thu nhập
            }
        });
        //Xử lý khi nhấn nút Total Expense
        totalExpense.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalExpense = expenseManager.getTotalExpense();
                // Tính tổng chi tiêu
                JOptionPane.showMessageDialog(frame, "Total Expense: $" + totalExpense);
                // Hiển thị tổng chi tiêu.
            }
        });
        //Xử lý khi nhấn nút Total Income
        totalIncome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totalIncome = expenseManager.getTotalIncome();
                // Tính tổng thu nhập
                JOptionPane.showMessageDialog(frame, "Total Income: $" + totalIncome);
                // Hiển thị tổng thu nhập.
            }
        });
    }

    public static void main(String[] args) {
        new ExpenseManagerGUI();
        //Tạo và khởi chạy giao diện GUI
    }

}
