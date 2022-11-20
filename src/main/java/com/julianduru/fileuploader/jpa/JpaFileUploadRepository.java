package com.julianduru.fileuploader.jpa;


import com.julianduru.fileuploader.entities.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * created by julian
 */
@Repository
public interface JpaFileUploadRepository extends JpaRepository<FileUpload, Long>  {


    Optional<FileUpload> findByReference(String reference);


    boolean existsByReference(String reference);


    List<FileUpload> findByReferenceIn(Collection<String> references);


}

