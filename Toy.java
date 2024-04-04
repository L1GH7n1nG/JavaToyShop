import java.io.Serializable;

public class Toy implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private int quantity;
	private double frequency;

	public Toy(int id, String name, int quantity, double frequency) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.frequency = frequency;
	}

	// Геттеры и сеттеры
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	// Метод для увеличения количества игрушек
	public void increaseQuantity(int amount) {
		this.quantity += amount;
	}

	// Метод для уменьшения количества игрушек
	public void decreaseQuantity() {
		quantity--;
	}

	// Метод для преобразования игрушки в строку CSV
	public String toCSVString() {
		return id + "," + name + "," + quantity + "," + frequency;
	}

	// Метод для преобразования игрушки в JSON
	public String toJSONString() {
		return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"quantity\":" + quantity + ",\"frequency\":" + frequency
				+ "}";
	}
}
