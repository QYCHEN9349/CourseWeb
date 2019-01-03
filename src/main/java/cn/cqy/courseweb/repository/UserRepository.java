package cn.cqy.courseweb.repository;

import cn.cqy.courseweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByUsername(String username);
}
