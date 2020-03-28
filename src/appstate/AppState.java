package appstate;


enum MenuState { CREATION, INSERTION, EXITING }

public class AppState {
    private UserData userData;
    private MenuState menuState;
    
    public AppState(){
        userData = new UserData();
        menuState = MenuState.CREATION;
    }
}
