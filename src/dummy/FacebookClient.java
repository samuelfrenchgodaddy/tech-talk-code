package dummy;

import java.net.UnknownServiceException;

public class FacebookClient {
    public String getSessionId(){
        return "abc";
    }

    /**
     *
     * @param message
     * @param sessionId
     * @return facebook unique id representing the post
     * @throws UnknownServiceException
     */
    public String post(String message, String sessionId) throws UnknownServiceException {
        throw new UnknownServiceException();
    }
    public void recoveryOperation(String sessionId){
        return;
    }
}
