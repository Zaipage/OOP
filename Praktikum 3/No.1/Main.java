public class Main {
    public static void main(String[] args) {
        Staff staff1 = new Staff("Kebin Sitorus", 8000000, "IT");
        Staff staff2 = new Staff("Gro Siregar", 6000000, "Marketing");
        
        Freelancer freelancer1 = new Freelancer("Pop Nasution", 750000);
        Freelancer freelancer2 = new Freelancer("Luiy Simanjuntak", 1000000);

        Intern intern1 = new Intern("Toto Hutabarat", 2500000, 6, "UI");
        Intern intern2 = new Intern("Asep", 2000000, 3, "ITB");
        
        System.out.println("Jumlah Karyawan : " + Employee.getEmployeeCount());
        
        Employee[] employees = {staff1, staff2, freelancer1, freelancer2, intern1, intern2};
        
        for (int i = 0; i < employees.length; i++) {
            employees[i].displayInfo();
            System.out.println("Bonus : " + employees[i].calculateBonus());
        }
        
        System.out.println("Gaji Staff 1 : " + staff1.getSalary());
        staff1.work();
        System.out.println("Gaji Staff 1 setelah bekerja : " + staff1.getSalary());
        staff1.requestLeave(5);
        
        System.out.println("Gaji Staff 2 : " + staff2.getSalary());
        staff2.work();
        System.out.println("Gaji Staff 2 setelah bekerja : " + staff2.getSalary());
        
        System.out.println("Jumlah Proyek Freelancer 1 : " + freelancer1.getProjectCount());
        System.out.println("Gaji Freelancer 1 : " + freelancer1.getSalary());
        
        for (int i = 1; i <= 7; i++) {
            freelancer1.work();
            System.out.println("Gaji Freelancer 1 setelah proyek " + i + " : " + freelancer1.getSalary());
            System.out.println("Jumlah Proyek Freelancer 1 : " + freelancer1.getProjectCount());
            
            if (i == 5) {
                System.out.println("Bonus Freelancer 1 : " + freelancer1.calculateBonus());
            }
        }
        
        for (int i = 1; i <= 2; i++) {
            freelancer2.work();
            System.out.println("Gaji Freelancer 2 setelah proyek " + i + " : " + freelancer2.getSalary());
        }
        
        System.out.println("Gaji Intern 1 : " + intern1.getSalary());
        intern1.work();
        System.out.println("Gaji Intern 1 setelah bekerja : " + intern1.getSalary());
        intern1.submitReport();
        
        System.out.println("Gaji Intern 2 : " + intern2.getSalary());
        intern2.work();
        intern2.submitReport();
        
        System.out.println("Nama Staff 1 : " + staff1.getName());
        staff1.setName("Kebin Napitupulu");
        System.out.println("Nama Staff 1 setelah diubah : " + staff1.getName());
        
        System.out.println("Departemen Staff 2 : " + staff2.getDepartment());
        staff2.setDepartment("Human Resources");
        System.out.println("Departemen Staff 2 setelah diubah : " + staff2.getDepartment());
        
        System.out.println("Universitas Intern 1 : " + intern1.getUniversity());
        intern1.setUniversity("UGM");
        System.out.println("Universitas Intern 1 setelah diubah : " + intern1.getUniversity());
        
        System.out.println("Durasi Magang Intern 1 : " + intern1.getDuration());
        System.out.println("Bayaran per Proyek Freelancer 1 : " + freelancer1.getPayPerProject());
        
        System.out.println("Gaji Staff 2 sebelum diubah : " + staff2.getSalary());
        staff2.setSalary(7500000);
        System.out.println("Gaji Staff 2 setelah diubah : " + staff2.getSalary());
        
        System.out.println("Bayaran per Proyek Freelancer 1 sebelum diubah : " + freelancer1.getPayPerProject());
        freelancer1.setPayPerProject(850000);
        System.out.println("Bayaran per Proyek Freelancer 1 setelah diubah : " + freelancer1.getPayPerProject());
        
        System.out.println("Durasi Magang Intern 1 sebelum diubah : " + intern1.getDuration());
        intern1.setDuration(8);
        System.out.println("Durasi Magang Intern 1 setelah diubah : " + intern1.getDuration());
        
        for (Employee emp : employees) {
            emp.work();
        }
        
        System.out.println("Jumlah Karyawan Aktif : " + Employee.getEmployeeCount());
        
        intern2.resign();
        freelancer2.resign();
        staff1.resign();
        
        System.out.println("Jumlah Karyawan setelah resign : " + Employee.getEmployeeCount());
        
        Employee[] activeEmployees = {staff2, freelancer1, intern1};
        for (Employee emp : activeEmployees) {
            System.out.println("Nama Karyawan Aktif : " + emp.getName());
        }
    }
}

//java Main > (nama file bebas).txt