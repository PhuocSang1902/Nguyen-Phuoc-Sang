package com.case_study.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "roleSet")
    private Set<UserEmployee> userSet;
}
