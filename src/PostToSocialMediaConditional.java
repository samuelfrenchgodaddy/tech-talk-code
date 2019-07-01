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
        switch(socialMediaType.toLowerCase()){
            case "facebook":
                FacebookClient facebookClient = new FacebookClient();
                String facebookSessionId = facebookClient.getSessionId();
                try {
                    return convertFacebookSocialMediaUniqueIdToGdId(facebookClient.post(content, facebookSessionId));
                } catch (UnknownServiceException e) {
                    facebookClient.recoveryOperation(facebookSessionId);
                    throw new RuntimeException();
                }
                break;
            case "instagram":
                String igAccountId = "igAccId";
                InstagramClient instagramClient = new InstagramClient(igAccountId);
                if(instagramClient.isHasAccountId()){
                    IgStory igStory = instagramClient.createStory(igAccountId);
                    return convertInstagramSocialMediaUniqueIdToGdId(igStory.postToStoryAndGetId(content));
                }
                break;
            case "twitter":
                TwitterClient twitterClient = new TwitterClient();
                content = content.substring(0,Math.min(TWITTER_MAX_LEN_CHAR,content.length())); //<----- THIS COULD HAPPEN
                String existingMessageId = twitterClient.findMessageByContent(content);
                if(existingMessageId != null){
                    return existingMessageId;
                }
                result = twitterClient.postMessage(content);
                //do a ton of unique stuff and check the content size too - do not have this method early exit
                //set result here
                break;
            default:
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
