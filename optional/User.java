package optional;

import java.util.Optional;
import java.util.Scanner;

import annotations.Bad;
import annotations.Good;

/**
 * How to use optional in set methods and variables
 * 
 * @author zviproject
 *
 */

public class User {

	@Bad
	class Standart {
		private String name;
		private Integer age;
		private String groupName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGroupName() {
			return groupName;
		}

		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
	}

	/**
	 *
	 * Optional.of() - set data that non-null <br>
	 * Optional.ofNullable() - if input data is null, return empty Optional Use
	 * onky for controll access.<br>
	 * If entity in uncontrolled part Optional doesn't need
	 * 
	 * @author zviproject
	 *
	 */
	@Good
	class Correct {
		private String name;
		private Optional<Integer> age;
		private Optional<String> groupName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Optional<Integer> getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = Optional.of(age);
		}

		public Optional<String> getGroupName() {
			return groupName;
		}

		public void setGroupName(String groupName) {
			this.groupName = Optional.ofNullable(groupName);
		}
	}

	/**
	 * How to use optional without entity
	 * 
	 * @author zviproject
	 *
	 */
	@Good

	static class InputOptional {

		private Optional<Man> man;

		/**
		 * Strat runing if man is present
		 */
		public void runMan() {

			try (Scanner inputName = new Scanner(System.in)) {

				man.ifPresent(m -> m.run(inputName.nextLine()));
			}
		}

		public void setMan(Man man) {
			this.man = Optional.ofNullable(man);
		}
	}

	interface Man {
		public void run(String name);
	}

}
