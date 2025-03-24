package mg.app.crm.dto.campaign;

import lombok.Getter;

public enum CampaignStatus {
    DRAFT(0),
    CANCELLED(1),
    CONFIRMED(2),
    ON_PROGRESS(3),
    ON_HOLD(4),
    FINISHED(5),
    ARCHIVED(6);

    @Getter
    private final int value;

    CampaignStatus(int value) {
        this.value = value;
    }
}
