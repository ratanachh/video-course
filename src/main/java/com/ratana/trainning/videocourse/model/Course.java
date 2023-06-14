package com.ratana.trainning.videocourse.model;

import lombok.*;

import jakarta.persistence.*;

@Data
@Builder
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_seq")
    @SequenceGenerator(allocationSize = 1, name = "courses_seq")
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
}
