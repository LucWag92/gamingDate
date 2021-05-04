package com.gamingdate.repository;

import java.util.List;

import com.gamingdate.model.AccountData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDataRepository extends CrudRepository<AccountData, Long> {
    List<AccountData> findByeMail(String eMail);
}
