package controller.enums.GameEnums.gamestage;

public enum GameMainStage {
    DRAW_PHASE(1),
    STAND_BY_PHASE(2),
    FIRST_MAIN_PHASE(3),
    BATTLE_PHASE(4),
    SECOND_MAIN_PHASE(5),
    END_PHASE(6);

    int phase;

    GameMainStage(int phase) {
        phase = this.phase;
    }
}
