package gem.androidtraining3.enterprisenetwork.session;

import gem.androidtraining3.enterprisenetwork.model.ResponseUserInfo;

/**
 * Created by huylv on 19/02/2016.
 */
public class Session {
    private static ResponseUserInfo user;

    public static void setUser(ResponseUserInfo user) {
        Session.user=user;
    }

    public static void removeUser(){
        if(user!=null){
            user =null;
        }
    }

    public static ResponseUserInfo getCurrentUser(){
        return user;
    }
}