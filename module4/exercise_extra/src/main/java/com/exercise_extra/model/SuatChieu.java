package com.exercise_extra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "flag_remove = false")
@SQLDelete(sql = "update suat_chieu set flag_remove = true where id = ?")
public class SuatChieu {
    @Id
    @Column(columnDefinition = "varchar(25)")
    String id;
    String ten;
    boolean flag_remove = false;
    @ManyToOne
    Phim phim;
}
