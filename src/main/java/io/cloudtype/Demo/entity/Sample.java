package io.cloudtype.Demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "SAMPLE")
@Table(name = "SAMPLE")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATA")
    private String data;

    @Builder
    public Sample(Long id, String data) {
        this.id = id;
        this.data = data;
    }

}
