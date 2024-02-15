package org.ahmedukamel.ecommerce.util;

import org.ahmedukamel.ecommerce.model.*;

public class EntityDetailsUtils {
    public static CustomerDetail supplyCustomerDetail(Customer customer, Integer languageId) {
        return customer.getCustomerDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(CustomerDetail::new);
    }

    public static ProductDetail supplyProductDetail(Product product, Integer languageId) {
        return product.getProductDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(ProductDetail::new);
    }

    public static BlogPostDetail supplyBlogPostDetail(BlogPost post, Integer languageId) {
        return post.getBlogPostDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(BlogPostDetail::new);
    }

    public static CategoryDetail supplyCategoryDetail(Category category, Integer languageId) {
        return category.getCategoryDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(CategoryDetail::new);
    }

    public static CartItem supplyCartItem(Customer customer, Integer productId) {
        return customer.getCart().getCartItems().stream().filter(item -> item.getProduct().getProductId().equals(productId)).findFirst().orElseGet(CartItem::new);
    }

    public static AdvertisementDetail supplyAdvertisementDetail(Advertisement advertisement, Integer languageId) {
        return advertisement.getAdvertisementDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(AdvertisementDetail::new);
    }

    public static NotificationDetail supplyNotificationDetail(Notification notification, Integer languageId) {
        return notification.getNotificationDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(NotificationDetail::new);
    }

    public static MainCategoryDetail supplyMainCategoryDetail(MainCategory mainCategory, Integer languageId) {
        return mainCategory.getMainCategoryDetails().stream().filter(item -> item.getLanguage().getLanguageId().equals(languageId)).findFirst().orElseGet(MainCategoryDetail::new);
    }
}
