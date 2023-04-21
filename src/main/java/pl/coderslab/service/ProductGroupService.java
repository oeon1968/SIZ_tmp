package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.ProductGroupDao;
import pl.coderslab.model.ProductGroup;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGroupService {
    private final ProductGroupDao productGroupDao;

    public void insert(ProductGroup productGroup) {
        productGroupDao.insert(productGroup);
    }

    public void update(ProductGroup productGroup) {
        productGroupDao.update(productGroup);
    }

    public void delete(ProductGroup productGroup) {
        productGroupDao.delete(productGroup);
    }

    public ProductGroup getProductGroup(int id) {
        return productGroupDao.findObject(id);
    }

    public List<ProductGroup> getProductGroupList() {
        return productGroupDao.productGroupList();
    }
}
