package com.rajeev.playground.japancoronastats.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "corona_details")
public class CoronaDetailsEntity {
    @Id
    @Column(name = "prefecture_name")
    private final String prefectureName;
    private final Long tested;
    private final Long confirmed;
    private final Long recovered;
    private final Long active;
    private final Long critical;
    private final Long deaths;
    @Column(name = "created_at")
    private final Timestamp createdAt;
    @Column(name = "updated_at")
    private final Timestamp updatedAt;
}
