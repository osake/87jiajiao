package com.zjy.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.zjy.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, QueryDslPredicateExecutor<Account> {
}
