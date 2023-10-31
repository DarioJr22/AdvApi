package com.br.thomasvcgApi.repository;

import com.br.thomasvcgApi.domain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
