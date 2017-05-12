package optional;

import java.util.Optional;

import annotations.Bad;
import annotations.Good;

public class CheckValuePresence {
	@Bad
	class ManualCheckForPresenceToThrowException {
		public String getUserName(Integer userId) {
			Optional<User.Correct> user = findById(userId);
			if (user.isPresent()) {
				return user.get().getName();
			}
			throw new IllegalStateException("User not found");
		}

	}

	@Good
	class Correct {
		public String getUserName(Integer userId) {
			return findById(userId).orElseThrow(() -> new IllegalStateException("Empty")).getName();
		}
	}

	public Optional<User.Correct> findById(Integer userId) {
		return null;
	}

}
