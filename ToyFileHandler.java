import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToyFileHandler {
	private String fileName;

	public ToyFileHandler(String fileName) {
		this.fileName = fileName;
	}

	// Метод для записи игрушек в CSV-файл
	public void writeToFile(List<Toy> toys) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Toy toy : toys) {
				writer.write(toy.toCSVString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Метод для чтения игрушек из CSV-файла
	public List<Toy> readFromFile() {
		List<Toy> toys = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0]);
				String name = parts[1];
				int quantity = Integer.parseInt(parts[2]);
				double frequency = Double.parseDouble(parts[3]);
				toys.add(new Toy(id, name, quantity, frequency));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toys;
	}
}
