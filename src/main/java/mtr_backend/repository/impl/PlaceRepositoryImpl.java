package mtr_backend.repository.impl;
import mtr_backend.dto.PlaceSearchCondition;
import mtr_backend.entity.Place;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.persistence.TypedQuery;

@Repository
public class PlaceRepositoryImpl implements PlaceRepositoryCustom {

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Place> findByConditions(PlaceSearchCondition condition) {

    StringBuilder jpql = new StringBuilder("SELECT p FROM Place p WHERE 1=1");
    Map<String, Object> params = new HashMap<>();

    if (condition.hasIsPublic()) {
      jpql.append(" AND p.isPublic = :isPublic");
      params.put("isPublic", condition.getIsPublic());
    }
    if (condition.hasCategoryId()) {
      jpql.append(" AND p.categoryId = :categoryId");
      params.put("categoryId", condition.getCategoryId());
    }

    jpql.append(" ORDER BY p.updatedAt DESC, p.id DESC");

    TypedQuery<Place> query = em.createQuery(jpql.toString(), Place.class);
    params.forEach(query::setParameter);

    return query.getResultList();
  }
}

