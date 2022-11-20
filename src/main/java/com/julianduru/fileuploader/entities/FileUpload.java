package com.julianduru.fileuploader.entities;


import com.julianduru.fileuploader.UploadConstants;
import com.julianduru.fileuploader.UploadRequest;
import com.julianduru.fileuploader.providers.UploadProvider;
import com.julianduru.fileuploader.util.ZonedDateTimeConverter;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * created by julian
 */
@Data
@Entity
@Table(name = UploadConstants.TABLE_PREFIX + "file_upload")
public class FileUpload {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, updatable = false)
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime timeAdded;


    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime timeUpdated;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UploadProvider provider;


    @Column(nullable = false, length = 200)
    private String containerName;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String fileKey;


    @Column(nullable = false, length = 200)
    private String originalFileName;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String fileType;


    @NaturalId
    @Column(nullable = false, unique = true, length = 200)
    private String reference;


    @Column(columnDefinition = "TEXT")
    private String publicUrl;


    @Column(columnDefinition = "TEXT")
    private String metaData;



    @PrePersist
    public void prePersist() {
        timeAdded = ZonedDateTime.now();
    }


    @PreUpdate
    public void preUpdate() {
        timeUpdated = ZonedDateTime.now();
    }

    
    public static FileUpload fromRequest(UploadRequest uploadRequest, UploadProvider defaultUploadProvider) {
        var upload = new FileUpload();
        
        upload.setContainerName(uploadRequest.getContainerName());
        upload.setFileKey(uploadRequest.getFileKey());
        upload.setReference(uploadRequest.getReference());
        upload.setMetaData(uploadRequest.getMetaData());
        upload.setOriginalFileName(uploadRequest.getFileName());
        upload.setFileType(uploadRequest.getFileType());
        
        if (uploadRequest.providerless()) {
            upload.setProvider(defaultUploadProvider);
        }
        else {
            upload.setProvider(uploadRequest.getProvider());
        }
        
        return upload;
    }


    public static FileUpload from(com.julianduru.fileuploader.api.FileUpload upload) {
        var fileUpload = new FileUpload();
        fileUpload.setContainerName(upload.getContainerName());
        fileUpload.setFileKey(upload.getFileKey());
        fileUpload.setReference(upload.getReference());
        fileUpload.setMetaData(upload.getMetaData());
        fileUpload.setOriginalFileName(upload.getOriginalFileName());
        fileUpload.setFileType(upload.getFileType());
        fileUpload.setProvider(upload.getProvider());
        fileUpload.setId(upload.getId());
        fileUpload.setPublicUrl(upload.getPublicUrl());

        return fileUpload;
    }
    
    
    public com.julianduru.fileuploader.api.FileUpload toApi() {
        var fileUpload = new com.julianduru.fileuploader.api.FileUpload();
        fileUpload.setContainerName(getContainerName());
        fileUpload.setFileKey(getFileKey());
        fileUpload.setReference(getReference());
        fileUpload.setMetaData(getMetaData());
        fileUpload.setOriginalFileName(getOriginalFileName());
        fileUpload.setFileType(getFileType());
        fileUpload.setProvider(getProvider());
        fileUpload.setId(getId());
        fileUpload.setPublicUrl(getPublicUrl());
        fileUpload.setTimeAdded(getTimeAdded());
        fileUpload.setTimeUpdated(getTimeUpdated());

        return fileUpload;
    }
    

}
