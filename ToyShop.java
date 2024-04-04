import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
	private List<Toy> toys;
	private ToyFileHandler fileHandler;

	public ToyShop(String fileName) {
		toys = new ArrayList<>();
		fileHandler = new ToyFileHandler(fileName);
	}

	public void loadToys() {
		toys = fileHandler.readFromFile();
	}

	public void saveToys() {
		fileHandler.writeToFile(toys);
	}

	// Метод для изменения веса игрушки по ее ID
	public void changeFrequency(int toyId, double frequency) {
		for (Toy toy : toys) {
			if (toy.getId() == toyId) {
				toy.setFrequency(frequency);
				fileHandler.writeToFile(toys);
				return;
			}
		}
		System.out.println("Toy with ID " + toyId + " not found.");
	}

	// Метод для добавления новой игрушки или обновления существующей
	public void addToy(Toy newToy) {
		boolean toyExists = false;
		for (Toy toy : toys) {
			if (toy.getId() == newToy.getId()) {
				toy.increaseQuantity(newToy.getQuantity());
				toyExists = true;
				break;
			}
		}
		if (!toyExists) {
			toys.add(newToy);
		}
		fileHandler.writeToFile(toys); // Обновление файла с игрушками
	}

	// Метод для розыгрыша игрушек
	public Toy drawToy() {
		if (toys.isEmpty()) {
			System.out.println("No toys available for draw.");
			return null;
		}

		List<Toy> toysCopy = new ArrayList<>(toys); // Создание временной копии списка игрушек

		double totalFrequency = toysCopy.stream().mapToDouble(Toy::getFrequency).sum();
		Random random = new Random();
		double randomNumber = random.nextDouble() * totalFrequency;

		double currentFrequency = 0;
		for (Toy toy : toys) {
			currentFrequency += toy.getFrequency();
			if (randomNumber <= currentFrequency) {
				toy.decreaseQuantity(); // Уменьшаем количество игрушки
				if (toy.getQuantity() == 0) {
					toys.remove(toy); // Удаляем игрушку из списка, если количество стало равно 0
				}
				fileHandler.writeToFile(toys); // Обновление файла с игрушками
				return new Toy(toy.getId(), toy.getName(), 1, toy.getFrequency());
			}
		}

		return null;
	}

}
