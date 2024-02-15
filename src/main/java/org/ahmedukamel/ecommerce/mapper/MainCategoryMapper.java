package org.ahmedukamel.ecommerce.mapper;

import org.ahmedukamel.ecommerce.dto.MainCategoryDto;
import org.ahmedukamel.ecommerce.model.MainCategory;
import org.ahmedukamel.ecommerce.model.MainCategoryDetail;
import org.ahmedukamel.ecommerce.util.EntityDetailsUtils;

import java.util.Collection;
import java.util.List;

public class MainCategoryMapper {
    public static MainCategoryDto toResponse(MainCategory mainCategory, Integer languageId) {
        MainCategoryDetail mainCategoryDetail = EntityDetailsUtils.supplyMainCategoryDetail(mainCategory, languageId);
        MainCategoryDto response = new MainCategoryDto();
        response.setCategoryId(mainCategory.getCategoryId());
        response.setName(mainCategoryDetail.getName());
        response.setDescription(mainCategoryDetail.getDescription());
        return response;
    }

    public static List<MainCategoryDto> toResponse(Collection<MainCategory> items, Integer languageId) {
        return items.stream().map(item -> toResponse(item, languageId)).toList();
    }
}
