package com.blabber.blabber.repositories;

import com.blabber.blabber.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
