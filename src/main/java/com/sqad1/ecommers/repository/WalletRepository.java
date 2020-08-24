package com.sqad1.ecommers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqad1.ecommers.entity.Wallet;
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
