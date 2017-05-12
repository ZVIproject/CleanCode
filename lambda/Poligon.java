package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import annotations.Good;

public class Poligon {
	public static void main(String[] args) {
		Stream.of(new Car("First car", 200), new Car("Second car", 300)).findFirst().ifPresent(System.out::println);

		Stream.of("a1", "a2", "b1", "b2").map(s -> {
			System.out.println("Map :" + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("Filter :" + s);
			return s.startsWith("a");

		}).forEach(s -> System.out.println("ForEach :" + s));

		collectionWithMap();
	}

	/**
	 * Convert to list with filter
	 */
	@Good
	static void collectionWithMap() {
		List<Car> cars = Arrays.asList(new Car("Vasya", 18), new Car("Julia", 17), new Car("Vasya", 20));

		List<Car> car = cars.stream().filter(p -> p.name.equals("Vasya")).collect(Collectors.toList());

		workingWithMap(cars);
		System.out.println("\nAverage cost of cars" + getAverageCostOfCars(cars));

		createParsedMap(cars);

	}

	/**
	 * Creating keys
	 * 
	 * @param cars
	 */
	static public void workingWithMap(List<Car> cars) {
		Map<Integer, List<Car>> sortedCarsByCost = cars.stream().collect(Collectors.groupingBy(car -> car.cost));

		sortedCarsByCost.forEach((age, car) -> System.out.format("cost %s cars %s", age, car));
	}

	/**
	 * Average cost of cars
	 * 
	 * @param cars
	 * @return
	 */
	static public double getAverageCostOfCars(List<Car> cars) {
		return cars.stream().collect(Collectors.averagingInt(car -> car.cost));
	}

	static void createParsedMap(List<Car> cars) {
		Map<Integer, String> mapOfCras = cars.stream().collect(Collectors.toMap(car -> car.cost, car -> car.name));

		mapOfCras.forEach((cost, name) -> System.out.format("Cost %s, name %s.   ", cost, name));

	}
	
	static public void flatMapWorking() {
		
		List<Food> foods = new ArrayList<>();
		List<Ingradient> ingradients = new ArrayList<>();
			IntStream.range(1, 4).forEach(food -> foods.add(new Food("Food"+ food )));
			
			foods.forEach(f -> 	IntStream.range(1, 4).forEach(i -> f.setIngradients(i -> i.foringradients.add(new Ingradient("Ingradient"+ingardient, 200)))));
	}
}

class Car {

	public String name;
	public Integer cost;

	public Car() {

	}

	public Car(String name, Integer cost) {
		this.name = name;
		this.setCost(cost);
	}

	public String getName() {
		return name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}

class Food{
	private String name;
	
	
	private List<Ingradient> ingradients;

	
	public Food(String name) {
		this.name = name;
	}

	public List<Ingradient> getIngradients() {
		return ingradients;
	}

	public void setIngradients(List<Ingradient> ingradients) {
		this.ingradients = ingradients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
	
	class Ingradient{
		private String name;
		private Integer cost;
		
		public Ingradient(String name, Integer cost) {
			this.name = name;
			
			this.cost = cost;				
		}
		
		public Integer getCost() {
			return cost;
		}
		public void setCost(Integer cost) {
			this.cost = cost;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
