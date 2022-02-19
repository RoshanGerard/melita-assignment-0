package com.melita.domain.model;

/**
 * Installation date time schedule details model.
 *
 * @author Roshan Bolonna
 */
public class InstallationTimeScheduleModel {

    private String installDate;
    private String installTime;

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getInstallTime() {
        return installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = installTime;
    }
}
