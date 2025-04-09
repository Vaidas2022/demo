package lt.kauneta.edemocracy.auth.model;

public enum UserRole {
    OBSERVER("Stebėtojas"),
    CITIZEN("Pilietis"),
    FACT_CHECKER("Faktų tikrintojas"),
    COUNCILOR("Tarybos narys"),
    WIZARD("Konstitucijos guru"),
    AGITATOR("Agitatorius"),
    SYSTEM("Sistema");

    private final String displayNameLt;

    UserRole(String displayNameLt) {
        this.displayNameLt = displayNameLt;
    }

    public String getDisplayNameLt() {
        return displayNameLt;
    }
}
