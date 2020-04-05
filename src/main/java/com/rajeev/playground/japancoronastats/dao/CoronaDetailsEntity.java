package com.rajeev.playground.japancoronastats.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corona_details")
public class CoronaDetailsEntity {
    @Id
    @Column(name = "prefecture_name")
    private String prefectureName;
    private Long tested;
    private Long confirmed;
    private Long recovered;
    private Long active;
    private Long critical;
    private Long deaths;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
