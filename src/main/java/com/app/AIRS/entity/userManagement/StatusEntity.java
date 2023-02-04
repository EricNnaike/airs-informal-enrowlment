package com.app.AIRS.entity.userManagement;

import com.app.AIRS.Enum.GenericStatusConstant;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class StatusEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    protected LocalDateTime dateDeactivated;
    @Basic
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    protected GenericStatusConstant status;
    @ManyToOne
    private PortalUser deactivatedBy;
    @ManyToOne
    private PortalUser createdBy;
    @Basic
    private LocalDateTime createdAt;
    @Basic
    private LocalDateTime lastUpdatedAt;

}