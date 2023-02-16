import java.util.Scanner;

class Employee{
    private static int counter = 1001;
    private int empID;
    private String name;
    private String designation;
    private String department;
    private double salary;

    Employee(){
        this.empID = counter++;
    }

    Employee(String name, String dept, String desg, double sal){
        this.name = name;
        this.designation = desg;
        this.department = dept;
        this.salary = sal;
        this.empID = counter++;
    }

    public int getEmpID(){
        return this.empID;
    }
    public String getName(){
        return this.name;
    }
    public String getDesg(){
        return this.designation;
    }
    public String getDept(){
        return this.department;
    }
    public double getSal(){
        return this.salary;
    }

    public void setEmpID(int id){
        this.empID = id;
    }
    public void setName(String name){
        Scanner sc = new Scanner(System.in);
        while(true){
            if(name.matches("^[A-Z][a-zA-Z ]+")){
                break;
            }
            else{
                System.out.println("Enter valid name (Start with caps)\n");
                System.out.print("Enter name: ");
                name = sc.nextLine();
            }
        }
        this.name = name;
    }
    public void setDesg(String desg){
        String[] designation_array = {"Manager", "Senior developer", "Software developer", "Intern"};
        Scanner scin = new Scanner(System.in);
        boolean invalidInput = false;
        int desg_choice = 0;
        do{
            do{
                invalidInput = false;
                try{
                    desg_choice = Integer.parseInt(desg);
                }
                catch(NumberFormatException e){
                    System.out.println("Enter only one integer option\n");
                    invalidInput = true;
                    System.out.print("Designation choice\n1.Manager\n2.Senior developer\n3.Software developer\n4.Intern\nEnter designation choice: ");
                    desg = scin.nextLine();
                }
            }while(invalidInput);
            if(desg_choice>4 || desg_choice<0){
                System.out.println("Enter an available option (1-4)\n");
            }
        }while(desg_choice>4 || desg_choice<0);

        this.designation = designation_array[desg_choice-1];
    }
    public void setDept(String dept){
        String[] department_array = {"R & D", "IT", "Admin", "HR", "Support"};
        Scanner scin = new Scanner(System.in);
        boolean invalidInput;
        int dept_choice = 0;
        do{
            do{
                invalidInput = false;
                    try{
                        dept_choice = Integer.parseInt(dept);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Enter only one integer option\n");
                        invalidInput = true;
                        System.out.print("\nDepartment choices \n1.R & D\n2.IT\n3.Admin\n4.HR\n5.Support\nEnter department choice:");
                        dept = scin.nextLine();
                    }
            }while(invalidInput);
            if(dept_choice>5 || dept_choice<0){
                System.out.println("Enter an available option (1-5)\n");
            }
        }while(dept_choice>5 || dept_choice<0);
        this.department = department_array[dept_choice-1];
    }
    public void setSal(double sal){
        this.salary = sal;
    }

    public double SetAllowance(){
        if(this.designation.compareTo("Manager") == 0){
            return (20 * this.salary / 100);
        }
        else{
            return (10 * this.salary / 100);
        }
    }
    @Override
    public String toString(){
        SetAllowance();
        System.out.println();
        return ("ID:\t\t\t\t" + this.empID + "\nName:\t\t\t\t" + this.name + "\nDesignation:\t\t\t" + this.designation + "\nDepartment:\t\t\t" + this.department + "\n\nSalary Without allowance\t" + this.salary + "\nSalary with allowance:\t\t" + (this.SetAllowance() + this.salary) + "\nEmployee allowance:\t\t" + this.SetAllowance());
    }
}