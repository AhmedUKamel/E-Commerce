package org.ahmedukamel.ecommerce.util;

import lombok.AllArgsConstructor;
import org.ahmedukamel.ecommerce.model.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocalizedEnumUtils {
    private MessageSourceUtils messageSourceUtils;

    public String getCountry(Country country) {
        return messageSourceUtils.getMessage("enumeration.country." + country.name() + ".name");
    }

    public String getCountry(String country) {
        return messageSourceUtils.getMessage("enumeration.country." + country + ".name");
    }

    public String getRole(Role role) {
        return messageSourceUtils.getMessage("enumeration.role." + role.name() + ".name");
    }

    public String getReportType(ReportType type) {
        return messageSourceUtils.getMessage("enumeration.report.type." + type.name() + ".name");
    }

    public String getOrderStatus(String status) {
        return messageSourceUtils.getMessage("enumeration.order.status." + status + ".name");
    }

    public String getAdvertisementStatus(String status) {
        return messageSourceUtils.getMessage("enumeration.advertisement.status." + status + ".name");
    }
}
