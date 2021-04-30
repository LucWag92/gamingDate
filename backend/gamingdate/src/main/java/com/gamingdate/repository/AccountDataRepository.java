package com.gamingdate.repository;
import com.gamingdate.model.ModelAccountData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends CrudRepository<ModelAccountData, Long> {
    
}
