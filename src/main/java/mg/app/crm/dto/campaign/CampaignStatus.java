package mg.app.crm.dto.campaign;

import lombok.Getter;

public enum CampaignStatus {
    DRAFT("Draft"),
    CANCELLED("Cancelled"),
    CONFIRMED("Confirmed"),
    ON_PROGRESS("OnProgress"),
    ON_HOLD("OnHold"),
    FINISHED("Finished"),
    ARCHIVED("Archived");

    @Getter
    private final String description;

    CampaignStatus(String description) {
        this.description = description;
    }
}
