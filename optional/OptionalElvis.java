package optional;

import static java.util.Optional.ofNullable;

import annotations.Bad;
import annotations.Good;

public class OptionalElvis {
	@Bad
	class BeforeJava8 {
		public String getUserName(User.Correct user) {
			return (user != null && user.getName() != null) ? user.getName() : "default";
		}
	}

	@Bad
	class UsingOptionalIsPresent {
		public String getUserName(User.Correct user) {
			if (ofNullable(user).isPresent()) {
				if (ofNullable(user.getName()).isPresent()) {
					return user.getName();
				}
			}
			return "default";
		}
	}

	@Good
	class Correct {
		public String getUserName(User.Correct user) {
			return ofNullable(user).map(User.Correct::getName).orElse("default");

		}
	}
}