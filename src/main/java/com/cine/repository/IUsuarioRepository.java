package com.cine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cine.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
