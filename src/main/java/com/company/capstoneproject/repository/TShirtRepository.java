package com.company.capstoneproject.repository;

import com.company.capstoneproject.model.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Integer> {

    Optional<List<TShirt>> findByColor(String color);

    Optional<List<TShirt>> findBySize(String size);
}
