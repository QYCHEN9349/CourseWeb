package cn.cqy.courseweb.repository;

import cn.cqy.courseweb.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    public Role findRoleById(int id);
}
