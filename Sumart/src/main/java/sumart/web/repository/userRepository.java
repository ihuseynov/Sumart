package sumart.web.repository;

import org.springframework.data.repository.CrudRepository;

import sumart.web.entity.User;

import java.util.List;

public interface userRepository extends CrudRepository<User, Integer> {
    List<User> findByNameIgnoreCase(String name);
    List<User> findByDistrictIgnoreCase(String district);
}
