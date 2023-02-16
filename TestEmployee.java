import java.util.*;

public class TestEmployee{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int choice = 1;
        double salary = 0;
        Scanner scin = new Scanner(System.in);
        boolean invalidInput = false;
        while(choice == 1){
            Employee employee = new Employee();
            do{
                invalidInput = false;
                try{
                    System.out.print("---- Menu ----\n1.Add employees\nAny other key to display and exit\nEnter choice: ");
                    choice = Integer.parseInt(scin.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println("Enter valid menu option (only integers)\n");
                    invalidInput = true;
                }
            }while(invalidInput);
            if(choice == 1){
                System.out.print("Enter name: ");
                employee.setName(scin.nextLine());
                System.out.print("\nDepartment choices \n1.R & D\n2.IT\n3.Admin\n4.HR\n5.Support\nEnter department choice:");
                employee.setDept(scin.nextLine());
                System.out.print("Designation choice\n1.Manager\n2.Senior developer\n3.Software developer\n4.Intern\nEnter designation choice: ");
                employee.setDesg(scin.nextLine());
                do{
                    invalidInput = false;
                    try{
                        System.out.print("Enter Salary: ");
                        salary = Double.parseDouble(scin.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println("Enter valid salary");
                        invalidInput = true;
                    }
                    if(salary < 10000){
                        System.out.println("Enter 5 figure salary");
                        invalidInput = true;
                    }
                }while(invalidInput);
                employee.setSal(salary);
                
                employees.add(employee);
                System.out.println();
                }
            }
            scin.close();
        if(employees.size() != 0){
            System.out.println("..... All Employees available .....");
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i).toString());
                System.out.println();
            }
        }
        else{
            System.out.println("No employees to display");
        }
    }
}