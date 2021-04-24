package Model.CardEnum;

public enum MagicSpeed {
    UNLIMITED,
    LIMITED;

    public static MagicSpeed setSpeed(String speed) {
        switch (speed) {
            case "Unlimited": {
                return UNLIMITED;
            }
            case "Limited": {
                return LIMITED;
            }
            default:
                return null;
        }
    }
}
