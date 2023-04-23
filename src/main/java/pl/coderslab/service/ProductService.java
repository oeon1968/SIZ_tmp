package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.dao.ProductGroupDao;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductGroup;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;
    private final ProductGroupDao productGroupDao;

    public void insert(Product product) {
        productDao.insert(product);
    }
    public void update(Product product) {
        productDao.update(product);
    }
    public void delete(Product product) {
        productDao.delete(product);
    }
    public Product getProduct(Integer id) {
        return productDao.findObject(id);
    }
    public List<Product> getProductList() {
        return productDao.productList();
    }
    //dane powiązane
    public List<ProductGroup> productGroups() {
        return productGroupDao.productGroupList();
    }
}
