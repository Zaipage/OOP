import java.util.ArrayList;

public class TransportSystem {
    private String name;
    private ArrayList<Vehicle> vehicles;

    public TransportSystem(String name) {
  	    /**
	 * TODO: Buatlah konstruktor untuk sistem transportasi
	 * */ 
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
       	/**
	 * TODO: Fungsinya untuk menambahkan objek kendaraan ke list kendaraan 
	 * */ 
        vehicles.add(vehicle);
    }

    public Vehicle findVehicleByDriver(String driverName) {
	    /**
	 * TODO: Fungsi untuk mencari kendaraan berdasarkan nama dari driver, 
	 * kembalikan nulljika tidak ditemukan
	 * */
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getDriver().getName().equalsIgnoreCase(driverName)) {
                return vehicle;
            }
        }
        return null;
    }

    public int totalPassengerCapacity() {
	    /**
	 * TODO: Menghitung seluruh kapasitas yang tersedia
	 * */	
        int totalCapacity = 0;
        for (Vehicle vehicle : vehicles) {
            totalCapacity += vehicle.getCapacity();
        }
        return totalCapacity;
    }

    public void showAllVehicles() {
        System.out.println("=== Transport System: " + name + " ===");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system.");
        } else {
            for (Vehicle v : vehicles) {
                v.showInfo();
                System.out.println("-------------------");
            }
        }
	    /**
	 * TODO: Menampilkan seluruh info kendaraan dengan format
	 * 	"=== Transport System: {name} ===
	 * 	{info vehicles}
	 *	-------------------
	 *	{info vehicles}
	 *	-------------------
	 *	...
	 *	"
	 * */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}