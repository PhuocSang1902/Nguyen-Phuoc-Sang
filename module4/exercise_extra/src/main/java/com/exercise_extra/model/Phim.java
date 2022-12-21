package com.exercise_extra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "flag_remove = false")
@SQLDelete(sql = "update phim set flag_remove = true where id = ?")
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String tên;
    boolean flagRemove = false;
    @OneToMany(mappedBy = "phim")
    Set<SuatChieu> suatChieuSet;
}
