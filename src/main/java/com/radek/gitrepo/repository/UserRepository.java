package com.radek.gitrepo.repository;

import com.radek.gitrepo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByUsername(String username);

    boolean existsByPesel(String pesel);

    boolean existsByEmail(String email);

}
