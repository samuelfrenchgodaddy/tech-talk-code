import dummy.*;

import java.net.*;

public class PostToSocialMediaConditionalExtractedMethod implements PostToSocialMedia {
    Integer TWITTER_MAX_LEN_CHAR = 5;

    public String postToSocialMedia(String socialMediaType, String content) {
        if ("facebook".equals(socialMediaType.toLowerCase())) {
            return handleFacebook(content);
        } else if ("instagram".equals(socialMediaType.toLowerCase())) {
            return handleInstagram(content);
        } else if ("twitter".equals(socialMediaType.toLowerCase())) {
            return handleTwitter(content);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private String handleTwitter(String content) {
        TwitterClient twitterClient = new TwitterClient();
        //here we are modifying local variables that could have adverse effects
        content = content.substring(0, Math.min(TWITTER_MAX_LEN_CHAR, content.length()));
        String existingMessageId = twitterClient.findMessageByContent(content);
        if (existingMessageId != null) {
            return existingMessageId;
        }
        return twitterClient.postMessage(content);
    }

    private String handleInstagram(String content) {
        String igAccountId = "igAccId";
        if(content.equals("a")){
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

    private String handleFacebook(String content) {
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

    private static String convertInstagramSocialMediaUniqueIdToGdId(Long socialMediaId){
        return socialMediaId.toString(); //dummy
    }
}
