package com.impact.monster.domain.roadmap;

import com.impact.monster.domain.roadmap.types.StatusTypes.StatusType;
import com.impact.monster.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roadmap")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roadmap_id")
    private Long id;

    private String info;

    private String detail;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @OneToMany(mappedBy = "roadmap")
    private List<User> users;

    @Builder
    public Roadmap(Long id, String info, String detail, StatusType status, List<User> users) {
        this.id = id;
        this.info = info;
        this.detail = detail;
        this.status = status;
        this.users = users;
    }
}
