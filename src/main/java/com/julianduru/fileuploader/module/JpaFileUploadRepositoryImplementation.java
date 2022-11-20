package com.julianduru.fileuploader.module;

import com.julianduru.fileuploader.api.FileUpload;
import com.julianduru.fileuploader.jpa.JpaFileUploadRepository;
import com.julianduru.fileuploader.repositories.FileUploadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * created by julian on 20/11/2022
 */
@Component
@RequiredArgsConstructor
@Primary
public class JpaFileUploadRepositoryImplementation implements FileUploadRepository {


    private final JpaFileUploadRepository uploadRepository;


    @Override
    public FileUpload save(FileUpload upload) {
        var fileUpload = uploadRepository.save(com.julianduru.fileuploader.entities.FileUpload.from(upload));
        return fileUpload.toApi();
    }

    @Override
    public Page<FileUpload> findAll(Pageable pageable) {
        return uploadRepository.findAll(pageable).map(com.julianduru.fileuploader.entities.FileUpload::toApi);
    }

    @Override
    public Optional<FileUpload> findByReference(String reference) {
        return uploadRepository.findByReference(reference).map(com.julianduru.fileuploader.entities.FileUpload::toApi);
    }

    @Override
    public boolean existsByReference(String reference) {
        return uploadRepository.existsByReference(reference);
    }

    @Override
    public List<FileUpload> findByReferenceIn(Collection<String> references) {
        return uploadRepository.findByReferenceIn(references)
            .stream()
            .map(com.julianduru.fileuploader.entities.FileUpload::toApi)
            .collect(Collectors.toList());
    }


}

