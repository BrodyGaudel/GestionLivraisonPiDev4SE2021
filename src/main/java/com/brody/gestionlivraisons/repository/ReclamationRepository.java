package com.brody.gestionlivraisons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.gestionlivraisons.entities.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
