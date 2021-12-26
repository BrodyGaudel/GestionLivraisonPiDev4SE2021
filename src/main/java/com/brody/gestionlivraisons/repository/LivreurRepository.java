package com.brody.gestionlivraisons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.gestionlivraisons.entities.Livreur;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {

}
