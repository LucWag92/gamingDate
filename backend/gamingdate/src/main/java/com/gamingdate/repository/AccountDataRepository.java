package com.gamingdate.repository;
import com.gamingdate.model.AccountData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends CrudRepository<AccountData, Long> {
    
}
