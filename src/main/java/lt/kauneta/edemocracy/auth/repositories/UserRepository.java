package lt.kauneta.edemocracy.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.kauneta.edemocracy.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
