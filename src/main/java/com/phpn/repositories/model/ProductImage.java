package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_images")
@Accessors(chain = true)
public class ProductImage {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_folder")
    private String fileFolder;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "cloud_id")
    private String cloudId;

    @Column(columnDefinition = "BIGINT(20) DEFAULT 0")
    private Long ts = new Date().getTime();

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "updated_by")
    private long updatedBy;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted = false;
}
