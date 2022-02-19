package com.melita.domain.dto;

import com.melita.domain.model.InstallationAddressModel;
import com.melita.domain.model.InstallationTimeScheduleModel;
import com.melita.domain.model.PersonalDetailsModel;
import com.melita.domain.model.ProductServiceModel;

/**
 * Order place request DTO model.
 *
 * @author Roshan Bolonna
 */
public class OrderRequestDto {

    private PersonalDetailsModel personalDetails;
    private InstallationAddressModel installationAddress;
    private InstallationTimeScheduleModel installationTimeSchedule;
    private ProductServiceModel productServiceModel;

    public PersonalDetailsModel getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsModel personalDetails) {
        this.personalDetails = personalDetails;
    }

    public InstallationAddressModel getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(InstallationAddressModel installationAddress) {
        this.installationAddress = installationAddress;
    }

    public InstallationTimeScheduleModel getInstallationTimeSchedule() {
        return installationTimeSchedule;
    }

    public void setInstallationTimeSchedule(InstallationTimeScheduleModel installationTimeSchedule) {
        this.installationTimeSchedule = installationTimeSchedule;
    }

    public ProductServiceModel getProductServiceModel() {
        return productServiceModel;
    }

    public void setProductServiceModel(ProductServiceModel productServiceModel) {
        this.productServiceModel = productServiceModel;
    }
}