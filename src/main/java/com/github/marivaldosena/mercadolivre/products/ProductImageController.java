package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
    @Transactional
    public ResponseEntity<ProductDto> uploadImageForProduct(@PathVariable("id") UUID productId, @Valid AddImageRequest request, @AuthenticationPrincipal UserCredentials userCredentials) {
        // TODO: Implement validation, data persistence and file uploading properly
        Set<ProductImage> productImages = new HashSet<>();
        Optional<Product> product = productRepository.findById(productId);

        if (!product.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        request.getImages().forEach(img -> {
            ProductImage prodImage = new ProductImage(img.getOriginalFilename(), img.getSize(), product.get());
            productImages.add(prodImage);
            saveImageInServer(product.get(), img);
            imageRepository.save(prodImage);
        });

        return ResponseEntity.ok(new ProductDto(product.get()));
    }

    private void saveImageInServer(Product product, MultipartFile uploadedImage) {
        // Rename file with product identification for future deletion
        String newImageName = product.getId() + "-" + uploadedImage.getOriginalFilename();
        Path baseDirPath = Paths.get("").toAbsolutePath().getParent();
        Path filePath = Paths.get(baseDirPath.resolve("uploads").toString(), newImageName);

        try {
            checkServerFileIntegrity(baseDirPath.resolve("uploads"), filePath);
            uploadedImage.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkServerFileIntegrity(Path baseDirPath, Path filePath) throws IOException {
        // Check upload directories existence
        // TODO: This nested if is a sign of bad code smell, it is recommended to refactor
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        } else {
            if (!Files.exists(baseDirPath)) {
                Files.createDirectory(baseDirPath);
            }
            Files.createFile(filePath);
        }
    }
}
