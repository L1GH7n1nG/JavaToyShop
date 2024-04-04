public class ToyShopMain {
	public static void main(String[] args) {
		String filePath = "C:\\Users\\L1GHT\\Desktop\\Study\\GEEKTEST\\HELLOPYTHON\\FinalPythonCourse\\Java\\Javatoys.csv";
		ToyShop toyShop = new ToyShop(filePath);

		// Загрузка игрушек из файла
		toyShop.loadToys();

		// Добавление игрушек в магазин

		// Задаваемые параметры id, Название, Количество, Частота выпадения.
		toyShop.addToy(new Toy(1, "Кукла", 1, 20));
		toyShop.addToy(new Toy(2, "Машинка", 1, 30));
		toyShop.addToy(new Toy(3, "Мяч", 2, 50));
		// toyShop.addToy(new Toy(3, "name", 2, 50)); - шаблон
		// toyShop.changeToyFrequency(1, 0.5); - шаблон для изменения частоты выпадения
		// игрушки (id, на сколько меняем частоту выпадения).

		// Розыгрыш игрушек

		Toy drawnToy = toyShop.drawToy();
		if (drawnToy != null) {
			System.out.println("Congratulations! You've won a " + drawnToy.getName() + "!");
		} else {
			System.out.println("Sorry, no toys available for draw.");
		}

		// Сохранение игрушек в файл
		toyShop.saveToys();
	}
}
