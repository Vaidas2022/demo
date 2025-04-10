package lt.kauneta.edemocracy.auth.model;

public enum UserRole {
    ANONYMOUS("Svečias"),
    OBSERVER("Stebėtojas"),
    CITIZEN("Forumo dalyvis"),
    COUNCILOR("Tarybos narys"),
    GUARDIAN("Saugos pareigūnas"),
    WIZARD("Konstitucijos guru"),
    ADMIN("Administratorius");

    private final String label;

    UserRole(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
