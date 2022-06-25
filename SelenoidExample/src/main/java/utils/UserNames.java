package utils;

public enum UserNames {
    HERMIONE_GRANGER ("Hermoine Granger"),
    HARRY_POTTER ("Harry Potter"),
    RON_WEASLY ("Ron Weasly"),
    ALBUS_DUMBLEDORE ("Albus Dumbledore"),
    NEVILLE_LONGBOTTOM ("Neville Longbottom");
    
    private final String userName;

    UserNames(String userName) {
        this.userName = userName;
    }

    public String getUserName() { return userName; }

}
