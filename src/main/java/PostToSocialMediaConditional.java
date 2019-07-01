import dummy.FacebookClient;
import dummy.IgStory;
import dummy.InstagramClient;
import dummy.TwitterClient;

import java.net.UnknownServiceException;

public class PostToSocialMediaConditional implements PostToSocialMedia {
    Integer TWITTER_MAX_LEN_CHAR = 140;

    @Override
    public String postToSocialMedia(String socialMediaType, String content) {
        String result = null;
        //THIS ALSO MANIFESTS ITSELF MORE COMMONLY AS GIANT SWITCH STATEMENTS
        if ("facebook".equals(socialMediaType.toLowerCase())) {
            FacebookClient facebookClient = new FacebookClient();
            String facebookSessionId = facebookClient.getSessionId();
            try {
                return convertFacebookSocialMediaUniqueIdToGdId(facebookClient.post(content, facebookSessionId));
            } catch (UnknownServiceException e) {
                facebookClient.recoveryOperation(facebookSessionId);
                throw new RuntimeException();
            }
        } else if ("instagram".equals(socialMediaType.toLowerCase())) {
            String igAccountId = "igAccId";
            InstagramClient instagramClient = new InstagramClient(igAccountId);
            if (instagramClient.isHasAccountId()) {
                IgStory igStory = instagramClient.createStory(igAccountId);
                return convertInstagramSocialMediaUniqueIdToGdId(igStory.postToStoryAndGetId(content));
            }
        } else if ("twitter".equals(socialMediaType.toLowerCase())) {
            TwitterClient twitterClient = new TwitterClient();
            content = content.substring(0, Math.min(TWITTER_MAX_LEN_CHAR, content.length())); //<----- THIS COULD HAPPEN
            String existingMessageId = twitterClient.findMessageByContent(content);
            if (existingMessageId != null) {
                return existingMessageId;
            }
            result = twitterClient.postMessage(content);
        } else {
            throw new UnsupportedOperationException();
        }
        return result;
    }

    private static String convertFacebookSocialMediaUniqueIdToGdId(String socialMediaId){
        return socialMediaId; //dummy
    }

    private static String convertInstagramSocialMediaUniqueIdToGdId(Long socialMediaId){
        return socialMediaId.toString(); //dummy
    }
}
