package PostToSocialMediaObjects.IndividualHandlers;

import PostToSocialMediaObjects.*;
import dummy.*;

public class InstagramHandler implements SocialMediaPostHandler {
    @Override
    public String post(String content) {
        String igAccountId = "igAccId";
        if (content.equals("a")) {
            InstagramClient instagramClient = new InstagramClient(igAccountId);
            if (instagramClient.isHasAccountId()) {
                IgStory igStory = instagramClient.createStory(igAccountId);
                return convertInstagramSocialMediaUniqueIdToGdId(igStory.postToStoryAndGetId(content));
            } else {
                return "ok";
            }
        } else {
            return "d";
        }
    }


    private static String convertInstagramSocialMediaUniqueIdToGdId(Long socialMediaId){
        return socialMediaId.toString(); //dummy
    }
}
