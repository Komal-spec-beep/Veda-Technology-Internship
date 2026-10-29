package day29.genericrepository;

import java.util.ArrayList;

public class GenericRepository<T> {
	
	private ArrayList<T> items = new ArrayList<>();

	public static void main(String[] args) {
		
		GenericRepository<String> repository = new GenericRepository<>();

		repository.add("Java");
		repository.add("Python");
		repository.add("C Programming");

		System.out.println(repository.getAll());
		System.out.println("Deleted: " + repository.delete("Python"));
		System.out.println(repository.getAll());
		
		System.out.println("Updated: " +
		        repository.update("Java", "Core Java"));

		System.out.println(repository.getAll());
		
		GenericRepository<Integer> numberRepository =
		        new GenericRepository<>();

		numberRepository.add(10);
		numberRepository.add(20);
		numberRepository.add(30);

		System.out.println(numberRepository.getAll());

	}
	
	public void add(T item) {
	    items.add(item);
	}
	
	public ArrayList<T> getAll() {
	    return items;
	}
	
	public boolean delete(T item) {
	    return items.remove(item);
	}

	public boolean update(T oldItem, T newItem) {
	    int index = items.indexOf(oldItem);

	    if (index != -1) {
	        items.set(index, newItem);
	        return true;
	    }

	    return false;
	}
}
