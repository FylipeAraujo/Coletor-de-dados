package com.example.coletorDeDados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coletorDeDados.Entity.consultaDeDados;

@Repository
public interface consultaDeDadosRepository extends JpaRepository<consultaDeDados, Long> {

}
