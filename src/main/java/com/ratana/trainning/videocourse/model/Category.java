package com.ratana.trainning.videocourse.model;


import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(allocationSize = 1, name = "categories_seq")
    private Integer id;
    private String name;
}
