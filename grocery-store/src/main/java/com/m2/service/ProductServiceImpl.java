package com.m2.service;

import com.m2.dto.ProductDTO;
import com.m2.entity.Product;
import com.m2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    /**
     * @return All available products from database
     */
    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> products=productRepository.findAll();

        return products.stream().map(product -> convertEntity(product)).toList();
    }

    private ProductDTO convertEntity(Product product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .sellingRate(product.getSellingRate())
                .availableQuantity(product.getAvailableQuantity())
                .description(product.getDescription())
                .name(product.getName())
                .build();
    }

    /**
     * @param dto
     * @return insert new product into database
     */
    @Override
    public String saveProduct(ProductDTO dto) {
        Product product=productRepository.save(convertDTO(dto));
        return Objects.nonNull(product)?"Item added":"Item not added";
    }

    private Product convertDTO(ProductDTO dto){
        return Product.builder()
                .productId(dto.getProductId())
                .availableQuantity(dto.getAvailableQuantity())
                .name(dto.getName())
                .description(dto.getDescription())
                .sellingRate(dto.getSellingRate())
                .purchaseRate(dto.getPurchaseRate())
                .build();
    }

    /**
     * @param ids
     * @return confirmation message after delete the records
     */
    @Override
    public String deleteProduct(List<Integer> ids) {
        productRepository.deleteAllById(ids);
        return "Item deleted";
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public String updateProductDetails(ProductDTO dto) {
        productRepository.save(checkAndConvert(dto));
        return "Item information updated";
    }

    private Product checkAndConvert(ProductDTO dto) {
        Product product=new Product();
        product.setProductId(dto.getProductId());

        if (Objects.nonNull(dto.getName()))
            product.setName(dto.getName());
        if (Objects.nonNull(dto.getDescription()))
            product.setDescription(dto.getDescription());
        if (Objects.nonNull(dto.getPurchaseRate()))
            product.setPurchaseRate(dto.getPurchaseRate());
        if (Objects.nonNull(dto.getSellingRate()))
            product.setSellingRate(dto.getSellingRate());
        if (Objects.nonNull(dto.getAvailableQuantity()))
            product.setAvailableQuantity(dto.getAvailableQuantity());

        return product;
    }
}
