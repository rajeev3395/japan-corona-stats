package com.rajeev.playground.japancoronastats.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaStatsRepository extends JpaRepository<CoronaDetailsEntity, Long> {
    CoronaDetailsEntity getByPrefectureName(String prefectureName);
}
