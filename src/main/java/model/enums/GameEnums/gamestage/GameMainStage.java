package model.enums.GameEnums.gamestage;

public enum GameMainStage {
    DRAW_PHASE(1),
    STAND_BY_PHASE(2),
    FIRST_MAIN_PHASE(3),
    BATTLE_PHASE(4),
    SECOND_MAIN_PHASE(5),
    END_PHASE(6);

    int phaseNumber;

    GameMainStage(int phaseNumber) {
        phaseNumber = this.phaseNumber;
    }

    private static GameMainStage getStageByNumber(int phaseNumber) {
        switch (phaseNumber) {
            case 1:
            case 7:
                return DRAW_PHASE;
            case 2:
                return STAND_BY_PHASE;
            case 3:
                return FIRST_MAIN_PHASE;
            case 4:
                return BATTLE_PHASE;
            case 5:
                return SECOND_MAIN_PHASE;
            case 6:
                return END_PHASE;
        }
        return null;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public static GameMainStage getNextPhase(int currentStage) {
        return getStageByNumber(currentStage + 1);
    }
}
