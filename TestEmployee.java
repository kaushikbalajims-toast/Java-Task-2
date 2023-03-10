import java.util.*;

public class TestEmployee{
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int choice = 1, idToFind = 0;
        boolean invalidInput = false;
        LinkedHashMap<Employee,Integer> empHash = new LinkedHashMap<Employee, Integer>();
        HashMap<Integer, Employee> employeeIdMapping = new HashMap<Integer, Employee>();
        
        MasterData mData = new MasterData(employees);
        Scanner scin = new Scanner(System.in);
        
        while(true){
            Employee employee = new Employee();
            do{
                invalidInput = false; 
                try{
                    System.out.print("---- Menu ----\n1.Add employees\n2.Display Employees list\n3.Add all employee attendance\n4.Update Attendance for an Employee ID\n5.Show Eligible Employees\n6.Exit\nEnter choice: ");
                    choice = Integer.parseInt(scin.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println("Enter valid menu option (only numbers)\n");
                    invalidInput = true;
                }
            }while(invalidInput); // proper choice at this point
            
            // choice = getAnInteger(1, 1, 0);

            if(choice == 1){      // when adding employee
                employee.setName(""); //to validate name
                employee.setDesg(""); //to validate department
                employee.setDept(""); //to validate designation
                employee.setSal(0);  //to set the correct salary
                employeeIdMapping.put(employee.getEmpID(), employee);
                employees.add(employee);
                System.out.println();
            }
            else if(choice == 2){
                mData.displayEmployees();    
            }

            else if(choice == 3){
                ArrayList<Employee> empList = mData.getEmpList();
                if(empList.size()>0){
                    for (Employee emp : empList){
                        int attendance = 0;
                        invalidInput = false;
                        do{
                            invalidInput = false;
                            try{
                                System.out.print("\nEnter attendance for Employee "+emp.getEmpID() + " " + emp.getName() + ": ");
                                attendance = Integer.parseInt(scin.nextLine());
                            }
                            catch(NumberFormatException e){
                                System.out.println("Enter attendance as a number\n");
                                invalidInput = true;
                            }
                            if(attendance<0 && !invalidInput){
                                System.out.println("Enter positive value for attendance\n");
                                invalidInput = true;
                            }
                        }while(invalidInput);   
                        empHash.put(emp, attendance);  //valid attendance inserted to hashmap
                    }
                }
                else{
                    System.out.println("No employees to add attendance to");
                }

            }

            else if(choice == 4){
                do{
                    invalidInput = false;
                    if(employees.size() == 0){
                        System.out.println("No employee to update attendance to");
                        invalidInput = true;
                        break;
                    }
                    else{
                        try{
                            System.out.print("Enter employee id to update attendance: ");
                            idToFind = Integer.parseInt(scin.nextLine());
                        }
                        catch(NumberFormatException e){
                            System.out.println("Enter valid Id number");
                            invalidInput = true;
                        }
                        if(!(!invalidInput && (idToFind>1000 && (idToFind<=employees.size()+1000)))){
                            System.out.println("Enter an available employee ID\n");
                            invalidInput = true;
                        }    
                    }
                }while(invalidInput);
                if(empHash.get(employeeIdMapping.get(idToFind)) == null){
                    System.out.println("\nOld attendence: 0 days");
                }
                else{
                    System.out.println("Old attendence: " + empHash.get(employeeIdMapping.get(idToFind)));
                }
                // proper employee id at this point
                int attendance = 0;
                do{
                    invalidInput = false;
                    try{
                        System.out.print("New attendance for Employee " + idToFind + " :  ");
                        attendance = Integer.parseInt(scin.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println("Enter attendance as a number\n");
                        invalidInput = true;
                    }
                    if(attendance<0 && !invalidInput){
                        System.out.println("Enter positive value for attendance\n");
                        invalidInput = true;
                    }
                }while(invalidInput);
                    
                empHash.put(employeeIdMapping.get(idToFind), attendance);
            }

            else if(choice == 5){
                if(empHash.size() > 0){
                    AttendanceMaster am = new AttendanceMaster(empHash);
                    am.showEligibleList();
                }
                else{
                    System.out.println("Attendance not entered for any employees\n");
                }
            }
            else if(choice == 6){
                System.out.println("Bye Bye");
                System.exit(0);
            }

            else{
                System.out.println("Enter valid menu option");
            }
        }
    }
}