package project;

import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private ArrayList<Income> incomes;
    
    //Constructor
    public ExpenseManager() {
        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
    }
    
    //Add object Expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
    
    //Add object Income
    public void addIncome(Income income) {
        incomes.add(income);
    } 
    
    //Goi toan bo danh sach Expense
    public ArrayList<Expense> getAllExpenses() {
        return expenses;
    }
    
    //Goi toan bo danh sach Income
    public ArrayList<Income> getAllIncomes() {
        return incomes;
    }
    
    //Tinh Tong So tien Chi Tieu
    public double getTotalExpense() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
    
    //Tinh Tong thu nhap
    public double getTotalIncome() {
        double total = 0;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

}
