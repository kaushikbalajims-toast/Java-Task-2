import java.util.*;

public class AttendanceMaster {
    private LinkedHashMap<Employee, Integer> empAtten = new LinkedHashMap<Employee,Integer>();

    AttendanceMaster( LinkedHashMap<Employee, Integer> emphash){
        this.empAtten = emphash;
    }
    public HashMap<Employee,Integer> getEmpAtten(){
        return this.empAtten;
    }

    public void showEligibleList(){
        int eligibleCount = 0;
        System.out.println("---------- Eligible employees ----------\n");
        ArrayList<Employee> emList = new ArrayList<Employee>(this.empAtten.keySet()) ;
        for (Employee emp : emList) {
            if(this.empAtten.get(emp) > 9){
                System.out.println(emp.toString());
                eligibleCount++;
            }
        }

        if(eligibleCount == 0){
            System.out.println("No employees eligible\n");
        }
    }
}
