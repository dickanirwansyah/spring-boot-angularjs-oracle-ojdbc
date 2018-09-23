package com.fusi24.springfusi24angularjs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVINCE_SEQUENCE")
    @SequenceGenerator(sequenceName = "seq_province", allocationSize = 1, name = "PROVINCE_SEQUENCE")
    private Long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<City> cities;

}
