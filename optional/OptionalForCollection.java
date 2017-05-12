package optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import annotations.Bad;
import annotations.Good;

public class OptionalForCollection {
	private static final String ADMIN_ROLE = "admin";

	@Bad
	class TooVerbose {
		public User findAnyAdmin() {
			Optional<List<User>> users = findUsersByRole(ADMIN_ROLE);
			if (users.isPresent() && !users.get().isEmpty()) {
				return users.get().get(0);
			}
			throw new IllegalStateException("No admins found");
		}

		private Optional<List<User>> findUsersByRole(String role) {
			return Optional.empty();
		}
	}

	@Good
	class Correct {
		public User.Correct findAnyAdmin() {

			return findUserByRole(ADMIN_ROLE).stream().findAny()
					.orElseThrow(() -> new IllegalStateException("No admins"));
		}

		private List<User.Correct> findUserByRole(String role) {
			return Collections.emptyList();
		}
	}
}
