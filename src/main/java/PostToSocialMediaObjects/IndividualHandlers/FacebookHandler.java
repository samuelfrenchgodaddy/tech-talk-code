package PostToSocialMediaObjects.IndividualHandlers;

import PostToSocialMediaObjects.*;
import dummy.*;

import java.net.*;

public class FacebookHandler implements SocialMediaPostHandler {

    @Override
    public String post(String content) {
        FacebookClient facebookClient = new FacebookClient();
        String facebookSessionId = facebookClient.getSessionId();
        try {
            return convertFacebookSocialMediaUniqueIdToGdId(facebookClient.post(content, facebookSessionId));
        } catch (UnknownServiceException e) {
            facebookClient.recoveryOperation(facebookSessionId);
            throw new RuntimeException();
        }
    }


    private static String convertFacebookSocialMediaUniqueIdToGdId(String socialMediaId){
        return socialMediaId; //dummy
    }
}
