package PostToSocialMediaObjects.IndividualHandlers;

import PostToSocialMediaObjects.*;
import dummy.*;

public class TwitterHandler implements SocialMediaPostHandler {

    Integer TWITTER_MAX_LEN_CHAR = 5;

    @Override
    public String post(String content) {
        TwitterClient twitterClient = new TwitterClient();
        //here we are modifying local variables that could have adverse effects
        content = content.substring(0, Math.min(TWITTER_MAX_LEN_CHAR, content.length()));
        String existingMessageId = twitterClient.findMessageByContent(content);
        if (existingMessageId != null) {
            return existingMessageId;
        }
        return twitterClient.postMessage(content);
    }
}
