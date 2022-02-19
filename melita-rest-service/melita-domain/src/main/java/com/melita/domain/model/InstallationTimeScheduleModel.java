package com.melita.domain.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Installation date time schedule details model.
 *
 * @author Roshan Bolonna
 */
public class InstallationTimeScheduleModel {

    private Date installDate;
    private Time installTime;

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

    public Time getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Time installTime) {
        this.installTime = installTime;
    }
}
