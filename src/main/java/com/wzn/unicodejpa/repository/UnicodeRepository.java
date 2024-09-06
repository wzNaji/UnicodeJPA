package com.wzn.unicodejpa.repository;


import com.wzn.unicodejpa.model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicodeRepository extends JpaRepository<Unicode, Long> {

    boolean existsByUnicodeValue(int c);
}

