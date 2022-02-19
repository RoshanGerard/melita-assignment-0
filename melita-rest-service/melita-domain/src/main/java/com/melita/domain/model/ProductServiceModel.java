package com.melita.domain.model;

import com.melita.domain.type.Product;
import com.melita.domain.type.ProductPackage;

/**
 * Product service specification model.
 *
 * @author Roshan Bolonna.
 */
public class ProductServiceModel {

    private Product product;
    private ProductPackage productPackage;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(ProductPackage productPackage) {
        this.productPackage = productPackage;
    }
}
