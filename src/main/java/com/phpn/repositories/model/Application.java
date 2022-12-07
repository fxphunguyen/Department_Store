package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "app_key", nullable = false, length = 36)
    private String appKey;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "version_name", nullable = false, length = 50)
    private String versionName;
    @Column(name = "version_code", nullable = false, length = 50)
    private Integer versionCode;

}