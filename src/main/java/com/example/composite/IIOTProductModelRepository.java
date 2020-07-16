package com.example.composite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIOTProductModelRepository extends JpaRepository<IIOTProductModel, IIOTProductModelPK> {

}
