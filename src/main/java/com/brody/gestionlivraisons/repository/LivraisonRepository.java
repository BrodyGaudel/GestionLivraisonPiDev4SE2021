package com.brody.gestionlivraisons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.gestionlivraisons.entities.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

}
