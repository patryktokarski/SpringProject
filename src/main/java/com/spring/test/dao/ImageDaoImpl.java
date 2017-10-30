package com.spring.test.dao;

import com.spring.test.model.Image;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl extends AbstractDao<Integer, Image> implements ImageDao {

    public void create(Image image) {
        persist(image);
    }

    public void update(Image image) {
        merge(image);
    }

    public void deleteById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Image image = (Image) criteria.uniqueResult();
        delete(image);
    }
}
