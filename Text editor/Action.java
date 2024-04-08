package action;

import java.time.LocalDateTime;

public class Action {
    int actionId;
    LocalDateTime localDtaeTime;
    boolean isAddition;
    int lineNumber;
    String text;

    public Action(int actionId, LocalDateTime localDateTime, boolean isAddition, int lineNumber, String text) {
        this.actionId = actionId;
        this.localDtaeTime = localDateTime;
        this.isAddition = isAddition;
        this.lineNumber = lineNumber;
        this.text = text;
    }

    public int getActionId() {
        return this.actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDtaeTime;
    }

    public boolean getIsAddition() {
        return this.isAddition;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getText() {
        return this.text;
    }

}
