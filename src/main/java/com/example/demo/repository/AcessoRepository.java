package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Acesso;

@Repository
@Transactional
public interface AcessoRepository  extends JpaRepository<Acesso, Long> {

}
