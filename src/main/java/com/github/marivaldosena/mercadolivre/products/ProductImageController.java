package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ProductImageController.RESOURCE_URL)
public class ProductImageController {
    public final static String RESOURCE_URL = "/api/v1/products/{id}/images";

    private ProductImageRepository imageRepository;
    private ProductRepository productRepository;

    public ProductImageController(ProductImageRepository imageRepository, ProductRepository productRepository) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<?> uploadImageForProduct(@PathVariable("id") UUID productId, @RequestParam("image") List<MultipartFile> uploadedImages, @AuthenticationPrincipal UserCredentials userCredentials) {
        // TODO: Implement validation, data persistence and file uploading properly
        Set<ProductImage> productImages = new HashSet<>();
        Optional<Product> product = productRepository.findById(productId);

        uploadedImages.forEach(image -> productImages.add(new ProductImage(image.getOriginalFilename(), image.getSize(), product.get())));

        return ResponseEntity.ok(productImages.stream().map(img -> img.getName()).collect(Collectors.toList()));
    }
}
