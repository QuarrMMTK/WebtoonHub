package com.mmtk.manga.Repository;

import com.mmtk.manga.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
