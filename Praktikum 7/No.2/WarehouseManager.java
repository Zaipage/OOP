import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse Manager class with generic methods for managing warehouse
 * operations
 */
public class WarehouseManager {

  /**
   * Generic method to find items in a container that match a specific condition
   * Uses bounded type parameter
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Check if each item's category matches the specified category.
   * - If it matches, add it to the result list.
   * - Return the result list.
   * 
   * @param <T>       type that extends Product
   * @param container the container to search in
   * @param category  the category to filter by
   * @return list of matching products
   */
  public static <T extends Product> List<T> findByCategory(Container<T> container, String category) {
    // TODO: Implement
    List<T> result = new ArrayList<>(); // karena dia static yang artinya berdiri sendiri maka dia ga terikat yg lain
    // makanya harus buat arraylist baru untuk nyimpan hasil iterasi
    for (T item : container.getItems()){
      if(item.getCategory().equals(category)){
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Generic method to calculate total weight of items in a container
   * 
   * Hint:
   * - Iterate through the items in the container.
   * - Sum the weight of each item.
   * 
   * @param <T>       type that extends Product
   * @param container the container
   * @return total weight in kg
   */
  public static <T extends Product> double calculateTotalWeight(Container<T> container) {
    // TODO: Implement
    double totalWeight = 0;
    for (T item : container.getItems()){
      totalWeight += item.getWeight();
    }
    return totalWeight;
  }

  /**
   * Generic method to transfer items from one container to another
   * Uses wildcards to allow flexibility
   * 
   * Hint:
   * - Iterate through the items in the source container.
   * - For each item, attempt to add it to the destination container.
   * - If added successfully, remove it from the source container.
   * - Stop when the specified count is reached or source is empty.
   * - Return the number of items actually transferred.
   * 
   * @param <T>         the type of items
   * @param source      source container
   * @param destination destination container
   * @param count       number of items to transfer
   * @return number of items actually transferred
   */
  public static <T> int transferItems(Container<T> source, Container<T> destination, int count) {
    // TODO: Implement
    int transfer = 0; // nyimpen jumlah item yg berhasil dipindah
    List<T> sourceItems = new ArrayList<>(source.getItems());
    // buat arraylist baru dari source karena mau ngehapus item
    // kalo misal langsung hapus dari source dan bukan salinannya maka akan error
    // karena itu akan ubah list yg lagi diiterasi
    // jadi kalau mau remove sambil iterasi better buat salinan listnya dulu
    for (T item : sourceItems){
      if (transfer >= count || source.getItems().isEmpty()){
        // kalau berhasil transfer sebanyak count item maka berhenti
        // lebih duluan daripada add karena harus cek dulu masih lanjut tf atau engga
        break;
      }

      if (destination.addItem(item)){
        // kalo berhasil add ke destinasi maka hapus dari source
        source.removeItem(item);
        transfer++; // dan transfer bertambah karena berhasil
      } else {
        break;
      }
    }
    return transfer;
  }

  /**
   * Generic method to count items in a shelf
   * Uses wildcard with upper bound
   * 
   * Hint:
   * - Use the shelf's method to get total items.
   * 
   * @param <T>   base type
   * @param shelf the shelf to count items from
   * @return total number of items
   */
  public static <T> int countItemsInShelf(Shelf<T> shelf) {
    // TODO: Implement
    return shelf.getTotalItems(); 
    // karena shelf udah punya method untuk ngitung jumlah item
    // makanya dia cukup return pake getTotalItems() dari shelf
  }

  /**
   * Generic method to find container by ID in a shelf
   * 
   * Hint:
   * - Iterate through the containers in the shelf.
   * - Check if each container's ID matches the specified ID.
   * - If a match is found, return the container.
   * - If no match is found, return null.
   * 
   * @param <T>         base type
   * @param shelf       the shelf to search
   * @param containerId the container ID to find
   * @return the container if found, null otherwise
   */
  public static <T> Container<? extends T> findContainerById(Shelf<T> shelf, String containerId) {
    // TODO: Implement
    for (Container<? extends T> container : shelf.getContainers()){
      // make 'Container<? extends T>' karena getContainers() mengembalikan tipe list tersebut
      // di class shelf kaya gini methodnya:
      // public List<Container<? extends T>> getContainers(){}
      // yang artinya tipe dari listnya adalah 'Containe<? extends T>'
      if (container.getContainerId().equals(containerId)){
        return container;
      }
    }
    return null;
  }
}
