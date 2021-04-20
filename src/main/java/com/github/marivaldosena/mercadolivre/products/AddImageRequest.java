package com.github.marivaldosena.mercadolivre.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import feign.form.FormProperty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AddImageRequest {
    @NotNull
    @Size(min = 1)
    @FormProperty("image")
    @Valid
    private List<MultipartFile> image;

    @JsonCreator
    public AddImageRequest(List<MultipartFile> image) {
        this.image = image;
    }

    public List<MultipartFile> getImages() {
        return image;
    }
}
